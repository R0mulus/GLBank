/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import glbank.Account;
import glbank.Card;
import glbank.Employee;
import glbank.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Martin
 */
public class ConnectionProvider {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String DBNAME = "GLBank";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private long randomBankAccount;
    private long randomCardNumber;

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL + DBNAME, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }
        return conn;
    }
    
    public boolean isEmployeePasswordValid(String username, String password) {
        String query = "SELECT idemp FROM LoginEmployee WHERE login LIKE BINARY ? AND password LIKE BINARY ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                boolean result = rs.next();

                conn.close();

                return result;
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return false;
    }
    
    public boolean isEmployeePasswordValid(int idemp, String password) {
        String query = "SELECT idemp FROM LoginEmployee WHERE idemp LIKE BINARY ? AND password LIKE BINARY ?";
        Connection conn = getConnection();
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, idemp);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                boolean result = rs.next();

                conn.close();

                return result;
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return false;
    }

    public int getEmployeeId(String username) {
        String query = "SELECT idemp FROM LoginEmployee WHERE login LIKE BINARY ?";
        Connection conn = getConnection();
        int id = -1;

        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    id = rs.getInt("idemp");
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        return id;
    }

    public void logEmployeeAccess(int id){
        String query = "INSERT INTO historyloginemployee(idemp, logindate) "
                + "VALUES(?, ?)";
        String date = getDateTime();
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.setString(2, date);
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }

    public String getDateTime(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    public Employee getEmployee(int id){
        String query = "SELECT * FROM Employees WHERE idemp LIKE ?";
        Connection conn = getConnection();
        Employee employee = null;
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");
                    char position = rs.getString("position").charAt(0);

                    employee = new Employee(id, firstname, lastname, email, position );

                }
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }

        return employee;
    }
    
    public void changePassword(int idemp, String newPassword) {
        String query = "UPDATE LoginEmployee SET password = ? WHERE idemp LIKE ?";
        Connection conn = getConnection();
        if (conn != null) {
            try(PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, newPassword);
                ps.setInt(2, idemp);
                ps.execute();
                conn.close();
            }
            catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }

    
    public List<Client> getListOfAllClients(){
        String query = "SELECT * FROM Clients " +
                "INNER JOIN ClientDetails ON Clients.idc = ClientDetails.idc " +
                "WHERE disable LIKE 'F' " +
                "ORDER BY clients.lastname, clients.firstname ";
        Connection conn = getConnection();
        List<Client> list= new ArrayList<>();
        if(conn != null){
           try(Statement statement = conn.createStatement()){
               ResultSet rs = statement.executeQuery(query);
               while(rs.next()){
                   int idc = rs.getInt("Clients.idc");
                   String firstname = rs.getString("firstname");
                   String lastname = rs.getString("lastname");
                   Date date = rs.getDate("dob");
                   Client client = new Client(idc, firstname, lastname, date);
                   list.add(client);
               }
               conn.close();
           
           }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
           }
                     
        }
        
       return list;
    }
    
    public List<Account> getListOfAccounts(int idc){
        Connection conn = getConnection();
        String query = "SELECT * FROM Accounts WHERE idc LIKE ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            List<Account> listAcc = new ArrayList<>();
            ps.setInt(1, idc);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Account account = new Account(rs.getLong("idacc"), idc, rs.getFloat("balance"));
                listAcc.add(account);
            }
            conn.close();
            return listAcc;
        } catch (SQLException ex){
                System.out.println("Error: " + ex.toString());
        }
        
        return null;
    } 
    
    
    public Client getClientByID(int idc) {
        String query = "SELECT * FROM Clients " +
                "INNER JOIN ClientDetails ON Clients.idc = ClientDetails.idc " +
                "INNER JOIN LoginClient ON Clients.idc = LoginClient.idc " +
                "WHERE Clients.idc LIKE ?";
        Connection conn = getConnection();
        Client client = null;
        if (conn != null) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, idc);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String firstname = rs.getString("Clients.firstname");
                    String lastname = rs.getString("Clients.lastname");
                    String email = rs.getString("ClientDetails.email");
                    String street = rs.getString("ClientDetails.street");
                    int housenumber = rs.getInt("ClientDetails.housenumber");
                    String postcode = rs.getString("ClientDetails.postcode");
                    String city = rs.getString("ClientDetails.city");
                    String username = rs.getString("LoginClient.username");
                    String password = rs.getString("LoginClient.password");
                    boolean disable = rs.getString("Clients.disable").charAt(0) == 'F';
                    boolean blocked = rs.getString("LoginClient.blocked").charAt(0) == 'F';
                    Date dob = rs.getDate("ClientDetails.dob");

                    client = new Client(idc, firstname, lastname, email, street, housenumber, postcode, city, username, password, disable, blocked, dob);
                    
                    
                }
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
        
        return client;
    }
    
    public List getAllAccounts(){
        Connection conn = getConnection();
        String query = "SELECT idacc FROM Accounts";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            List<Long> accNumbers = new ArrayList<>();
            long idacc = 0;
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                idacc = rs.getLong("idacc");
                accNumbers.add(idacc);
            }
            conn.close();
            return accNumbers;
        } catch (SQLException ex){
                System.out.println("Error: " + ex.toString());
        }
        
        return null;
    }
    
    private void createRandomAccNumber(){
        randomBankAccount = ThreadLocalRandom.current().nextLong(1000000, 900000000) * 11;
    }
    
    public void randomAcc(){     
        createRandomAccNumber();
        List<Long> allAccounts = getAllAccounts();
        for (long idacc : allAccounts) {
            while(randomBankAccount == idacc){
                createRandomAccNumber();
            }
        }
    }

    public long getRandomBankAccount() {
        return randomBankAccount;
    }
    
    public void insertRandomAccount(int idc){
        randomAcc(); //create new random acc number and save it to randomBankAccount;
                
        String query = "INSERT INTO Accounts VALUES(?, ?, ?)";
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setLong(1, randomBankAccount);
                ps.setInt(2, idc);
                ps.setInt(3, 0);
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    public void controlFundsToSelectedAccount(long idacc, float balance, char type){
        String query = "UPDATE Accounts SET balance = balance " + type + " ? WHERE idacc LIKE ?";
        Connection conn = getConnection();
        if (conn != null) {
            try(PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setFloat(1, balance);
                ps.setLong(2, idacc);
                ps.execute();
                conn.close();
            }
            catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    public List getAllCards(){
        Connection conn = getConnection();
        String query = "SELECT cardNumber FROM Cards";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            List<Long> cardNumbers = new ArrayList<>();
            long cardNumber = 0;
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cardNumber = rs.getLong("cardNumber");
                cardNumbers.add(cardNumber);
            }
            conn.close();
            return cardNumbers;
        } catch (SQLException ex){
                System.out.println("Error: " + ex.toString());
        }
        
        return null;
    }
    
    private void createRandomCardNumber(){
        long randomMultiple = ThreadLocalRandom.current().nextLong(10000000, 99999999);
        long randomBase = ThreadLocalRandom.current().nextLong(100000000, 100000001);
        randomCardNumber  = randomBase * randomMultiple;
    }
    
    public void randomCard(){
        createRandomCardNumber();
        List<Long> allCards = getAllCards();
        for (long idacc : allCards) {
            while(randomCardNumber == idacc){
                createRandomCardNumber();
            }
        }
    }

    public long getRandomCardNumber() {
        return randomCardNumber;
    }
    
    public void insertRandomCard(long idacc, int pin){
        randomCard(); //create new random card number and save it to randomCardNumber;
                
        String query = "INSERT INTO Cards(cardNumber, idacc, pin) VALUES(?, ?, ?)";
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setLong(1, randomCardNumber);
                ps.setLong(2, idacc);
                ps.setInt(3, pin);                
                ps.execute();
                conn.close();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    /*
    public int getLastClientID(){
        Connection conn = getConnection();
        String query = "SELECT MAX(idc) FROM Clients";
        int idc = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, idc);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
            }

            
        } catch (SQLException ex){
                System.out.println("Error: " + ex.toString());
        }
        
        return idc;
    }
    */
    
   
    /*
    public void insertNewClientIntoClients(String firstname, String lastname){
        String query = "INSERT INTO Clients SET (firstname, lastname) VALUES(?, ?)";
        Connection conn = getConnection();
        if(conn != null){
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, firstname);
                ps.setString(2, lastname);
                ps.execute();
            }catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    */
    
    public List<Card> getListOfCards(long idacc){
        Connection conn = getConnection();
        String query = "SELECT * FROM Cards WHERE idacc LIKE ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            List<Card> listCard = new ArrayList<>();
            ps.setLong(1, idacc);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idCard = rs.getInt("idCard");
                long cardNum = rs.getLong("cardNumber");
                int pin = rs.getInt("pin");
                boolean blocked = rs.getString("blocked").charAt(0) == 'T';
                Card card = new Card(idacc, idCard, cardNum, pin, blocked);
                listCard.add(card);
            }
            conn.close();
            return listCard;
        } catch (SQLException ex){
                System.out.println("Error: " + ex.toString());
        }
        
        return null;
    }
    
    public void toggleCard(int idCard, char block){
        String query = "";
        
        switch (block){
            case 'T': query = "UPDATE Cards SET blocked = REPLACE(blocked,'F','T') WHERE idCard LIKE ?";
            break;
            case 'F': query = "UPDATE Cards SET blocked = REPLACE(blocked,'T','F') WHERE idCard LIKE ?";
            break;
            default: System.out.println("toggleCard method bad parameters!");
        }
        
        Connection conn = getConnection();
        if (conn != null) {
            try(PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, idCard);
                ps.execute();
                conn.close();
            }
            catch(SQLException ex){
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    public void changePIN(int newPIN, int idCard){
        String query = "UPDATE Cards SET pin = ? WHERE idCard = ?";
        Connection conn = getConnection();
        
        if(conn != null){
            try(PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, newPIN);
                ps.setInt(2, idCard);
                ps.execute();
                conn.close();
                
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.toString());
            }
        }
    }
    
    
}
