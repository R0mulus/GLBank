/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import glbank.Account;
import glbank.Card;
import glbank.Client;
import glbank.Employee;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joseph
 */
public class ConnectionProviderTest {
    
    public ConnectionProviderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmployeePasswordValid method, of class ConnectionProvider.
     */
    @Test
    public void testIsEmployeePasswordValid1() {
        System.out.println("isEmployeePasswordValid");
        String username = "molnar";
        String password = "molnar";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = true;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmployeePasswordValid2() {
        System.out.println("isEmployeePasswordValid");
        String username = "molnarr";
        String password = "molnar";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeeId method, of class ConnectionProvider.
     */
    @Test
    public void testGetEmployeeId1() {
        System.out.println("getEmployeeId");
        String username = "kollar";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = 1;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetEmployeeId2() {
        System.out.println("getEmployeeId");
        String username = "molnar";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = 2;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetEmployeeId3() {
        System.out.println("getEmployeeId");
        String username = "Molnar";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = -1;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of logEmployeeAccess method, of class ConnectionProvider.
     */
    /*
    @Test
    public void testLogEmployeeAccess() {
        System.out.println("logEmployeeAccess");
        int id = 2;
        ConnectionProvider instance = new ConnectionProvider();
        instance.logEmployeeAccess(id);

    }
    */
    /**
     * Test of getDateTime method, of class ConnectionProvider.
     */
    /*
    @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        ConnectionProvider instance = new ConnectionProvider();
        String expResult = "";
        String result = instance.getDateTime();
        assertEquals(expResult, result);

    }
    */
    /**
     * Test of getEmployee method, of class ConnectionProvider.
     */
    @Test
    public void testGetEmployee1() {
        System.out.println("getEmployee");
        int id = 1;
        ConnectionProvider instance = new ConnectionProvider();
        Employee result = instance.getEmployee(id);
        assertEquals("Jan", result.getFirstname());
        assertEquals("Kollar", result.getLastname());
        assertEquals(1, result.getIdemp());
        assertEquals("kollar@pobox.sk", result.getEmail());
        assertEquals('C', result.getPosition());    
    }
    @Test
    public void testGetEmployee2() {
        System.out.println("getEmployee");
        int id = 2;
        ConnectionProvider instance = new ConnectionProvider();
        Employee result = instance.getEmployee(id);
        assertEquals("Daniel", result.getFirstname());
        assertEquals("Molnar", result.getLastname());
        assertEquals(2, result.getIdemp());
        assertEquals("molnar@pobox.sk", result.getEmail());
        assertEquals('C', result.getPosition());    
    }
    
    @Test
    public void testGetClientByID1(){
        System.out.println("get client by ID 1: ");
        int id = 1;
        ConnectionProvider instance = new ConnectionProvider();
        Client result = instance.getClientByID(id);
        assertEquals("Jozef", result.getFirstname());
        assertEquals("Balint", result.getLastname());
    }
    
    @Test
    public void testGetClientByID2(){
        System.out.println("get client by ID 2: ");
        int id = 2;
        ConnectionProvider instance = new ConnectionProvider();
        Client result = instance.getClientByID(id);
        assertEquals("Martin", result.getFirstname());
        assertEquals("Molnar", result.getLastname());
    }
    
    @Test
    public void testGetClientByID3(){
        System.out.println("get client by ID 3: ");
        int id = 3;
        ConnectionProvider instance = new ConnectionProvider();
        Client result = instance.getClientByID(id);
        assertEquals("Tana", result.getFirstname());
        assertEquals("Pauhoffova", result.getLastname());
    }


    /**
     * Test of logEmployeeAccess method, of class ConnectionProvider.
     */
    @Test
    public void testLogEmployeeAccess() {
        System.out.println("logEmployeeAccess");
        int id = 0;
        ConnectionProvider instance = new ConnectionProvider();
        instance.logEmployeeAccess(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateTime method, of class ConnectionProvider.
     */
    @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        ConnectionProvider instance = new ConnectionProvider();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String expResult = formatter.format(date);
        String result = instance.getDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class ConnectionProvider.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        int id = 0;
        ConnectionProvider instance = new ConnectionProvider();
        Employee expResult = null;
        Employee result = instance.getEmployee(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class ConnectionProvider.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        int idemp = 0;
        String newPassword = "";
        ConnectionProvider instance = new ConnectionProvider();
        instance.changePassword(idemp, newPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfAllClients method, of class ConnectionProvider.
     */
    @Test
    public void testGetListOfAllClients() {
        System.out.println("getListOfAllClients");
        ConnectionProvider instance = new ConnectionProvider();
        List<Client> expResult = null;
        List<Client> result = instance.getListOfAllClients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfAccounts method, of class ConnectionProvider.
     */
    @Test
    public void testGetListOfAccounts() {
        System.out.println("getListOfAccounts");
        int idc = 0;
        ConnectionProvider instance = new ConnectionProvider();
        List<Account> expResult = null;
        List<Account> result = instance.getListOfAccounts(idc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientByID method, of class ConnectionProvider.
     */
    @Test
    public void testGetClientByID() {
        System.out.println("getClientByID");
        int idc = 0;
        ConnectionProvider instance = new ConnectionProvider();
        Client expResult = null;
        Client result = instance.getClientByID(idc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAccounts method, of class ConnectionProvider.
     */
    @Test
    public void testGetAllAccounts() {
        System.out.println("getAllAccounts");
        ConnectionProvider instance = new ConnectionProvider();
        List expResult = null;
        List result = instance.getAllAccounts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of randomAcc method, of class ConnectionProvider.
     */
    @Test
    public void testRandomAcc() {
        System.out.println("randomAcc");
        ConnectionProvider instance = new ConnectionProvider();
        instance.randomAcc();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomBankAccount method, of class ConnectionProvider.
     */
    @Test
    public void testGetRandomBankAccount() {
        System.out.println("getRandomBankAccount");
        ConnectionProvider instance = new ConnectionProvider();
        long expResult = 0L;
        long result = instance.getRandomBankAccount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertRandomAccount method, of class ConnectionProvider.
     */
    @Test
    public void testInsertRandomAccount() {
        System.out.println("insertRandomAccount");
        int idc = 0;
        ConnectionProvider instance = new ConnectionProvider();
        instance.insertRandomAccount(idc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of controlFundsToSelectedAccount method, of class ConnectionProvider.
     */
    @Test
    public void testControlFundsToSelectedAccount() {
        System.out.println("controlFundsToSelectedAccount");
        long idacc = 0L;
        float balance = 0.0F;
        char type = ' ';
        ConnectionProvider instance = new ConnectionProvider();
        instance.controlFundsToSelectedAccount(idacc, balance, type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCards method, of class ConnectionProvider.
     */
    @Test
    public void testGetAllCards() {
        System.out.println("getAllCards");
        ConnectionProvider instance = new ConnectionProvider();
        List expResult = null;
        List result = instance.getAllCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of randomCard method, of class ConnectionProvider.
     */
    @Test
    public void testRandomCard() {
        System.out.println("randomCard");
        ConnectionProvider instance = new ConnectionProvider();
        instance.randomCard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomCardNumber method, of class ConnectionProvider.
     */
    @Test
    public void testGetRandomCardNumber() {
        System.out.println("getRandomCardNumber");
        ConnectionProvider instance = new ConnectionProvider();
        long expResult = 0L;
        long result = instance.getRandomCardNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertRandomCard method, of class ConnectionProvider.
     */
    @Test
    public void testInsertRandomCard() {
        System.out.println("insertRandomCard");
        long idacc = 0L;
        int pin = 0;
        ConnectionProvider instance = new ConnectionProvider();
        instance.insertRandomCard(idacc, pin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfCards method, of class ConnectionProvider.
     */
    @Test
    public void testGetListOfCards() {
        System.out.println("getListOfCards");
        long idacc = 0L;
        ConnectionProvider instance = new ConnectionProvider();
        List<Card> expResult = null;
        List<Card> result = instance.getListOfCards(idacc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleCard method, of class ConnectionProvider.
     */
    @Test
    public void testToggleCard() {
        System.out.println("toggleCard");
        int idCard = 0;
        char block = ' ';
        ConnectionProvider instance = new ConnectionProvider();
        instance.toggleCard(idCard, block);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePIN method, of class ConnectionProvider.
     */
    @Test
    public void testChangePIN() {
        System.out.println("changePIN");
        int newPIN = 0;
        int idCard = 0;
        ConnectionProvider instance = new ConnectionProvider();
        instance.changePIN(newPIN, idCard);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    

    
}
