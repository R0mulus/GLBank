using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace AtmSoftware
{
    public class DatabaseConnection
    {
        private string server;
        private string uid;
        private string password;
        private string database;
        private MySqlConnection connection;
        private MySqlDataReader reader;

        public DatabaseConnection()
        {
            server = "localhost";
            uid = "root";
            password = "";
            database = "glbank";
            connection = getConnection();
        }

        public MySqlConnection getConnection()
        {
            if (connection == null) connection = openConnection();
            return connection;
        }

        private MySqlConnection openConnection()
        {
            string connectionString = "Server=" + server + ";Database=" + database + ";Uid=" + uid + ";Password=" + password + ";";
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            return connection;
        }

        public bool existsCard(long cardNum)
        {
            string query = "SELECT idCard FROM Cards WHERE cardNumber LIKE " + cardNum;
            MySqlConnection conn = getConnection();
            if(conn != null)
            {
                MySqlCommand cmd = new MySqlCommand(query, conn);
                reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    reader.Close();
                    return true;
                }
            }
            reader.Close();
            return false;
        }

        private int getIdCard(long cardNum)
        {
            int idCard = 0;
            string query = "SELECT idCard FROM Cards WHERE cardNumber LIKE " + cardNum;
            MySqlConnection conn = getConnection();
            if (conn != null)
            {
                MySqlCommand cmd = new MySqlCommand(query, conn);

                var str = cmd.ExecuteScalar();
                idCard = Convert.ToInt32(str);

                return idCard;
            }
            return idCard;
        }

        public bool isCardBlocked(long cardNum)
        {
            string query = "SELECT blocked FROM Cards WHERE cardNumber LIKE " + cardNum;
            MySqlConnection conn = getConnection();
            if (conn != null)
            {
                MySqlCommand cmd = new MySqlCommand(query, conn);
                reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    if(reader.GetChar("blocked") == 'T')
                    {
                        reader.Close();
                        return true;
                    }
                }
            }
            reader.Close();
            return false;
        }

        public bool isPinCorrect(long cardNum, int pin)
        {
            string query = "SELECT pin FROM Cards WHERE cardNumber LIKE " + cardNum;
            MySqlConnection conn = getConnection();
            if (conn != null)
            {
                MySqlCommand cmd = new MySqlCommand(query, conn);
                reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    if (reader.GetInt32("pin") == pin)
                    {
                        reader.Close();
                        return true;
                    }
                }
            }
            reader.Close();
            return false;
        }

        public float getBalance(long cardNum)
        {
            float balance = 0;
            string query = "SELECT balance FROM Accounts " + 
                "INNER JOIN Cards ON Accounts.idacc = Cards.idacc " +
                "WHERE cardNumber LIKE " + cardNum;
            MySqlConnection conn = getConnection();
            if (conn != null)
            {
                MySqlCommand cmd = new MySqlCommand(query, conn);

                var str = cmd.ExecuteScalar();
                balance = (float) Convert.ToDouble(str);

                return balance;
            }
            return balance;
        }
        
        public bool withdrawFromAccount(int withdrawal, long cardNum)
        {
            int idCard = getIdCard(cardNum);
            if(isBalanceSmallerOrSameThanWithdrawal(withdrawal, cardNum))
            {
                string query = "UPDATE Accounts " + 
                    "INNER JOIN Cards ON Accounts.idacc = Cards.idacc " +
                    "SET balance = balance - " + withdrawal +
                    " WHERE Cards.cardNumber LIKE " + cardNum;

                string query2 = "INSERT INTO atmwithdrawals " + 
                    "(amount, idatm, idcard) " + 
                    "VALUES (" + withdrawal + ", 1, " + idCard + ")";

                MySqlConnection conn = getConnection();
                MySqlTransaction trans = null;
                MySqlCommand cmd = new MySqlCommand();

                try
                {
                    if (conn != null)
                    {
                        
                        
                        trans = conn.BeginTransaction();
                        
                        cmd = new MySqlCommand(query, conn);
                        cmd.ExecuteNonQuery();
                        cmd = new MySqlCommand(query2, conn);
                        cmd.ExecuteNonQuery();

                        trans.Commit();
                        cmd.Dispose();
                        return true;
                    }
                    cmd.Transaction.Rollback();
                    return false;
                }
                catch (MySqlException ex)
                {
                    try
                    {
                        trans.Rollback();
                        return false;
                    }
                    catch (MySqlException ex1)
                    {
                        Console.WriteLine("Error: " + ex1.ToString());
                        return false;
                    }

                    Console.WriteLine("Error: " + ex.ToString());

                    return false;
                }

            }
            else
            {
                return false;
            }
        }
        

        private bool isBalanceSmallerOrSameThanWithdrawal(int withdrawal, long cardNum)
        {
            double balance = 0;
            long balanceRoundedDown = 0;
            string query = "SELECT balance FROM Accounts " +
                "INNER JOIN Cards ON Accounts.idacc = Cards.idacc " +
                "WHERE cardNumber LIKE " + cardNum;
            MySqlConnection conn = getConnection();
            if (conn != null)
            {
                MySqlCommand cmd = new MySqlCommand(query, conn);
                var str = cmd.ExecuteScalar();
                balance = Convert.ToDouble(str);
                balanceRoundedDown = (int)Math.Floor(balance);
                if (balanceRoundedDown >= withdrawal)
                {
                    return true;
                }
                return false;
            }
            return false;
        }

        public void changePin(long cardNum, int newPin)
        {
            
            string query = "UPDATE Cards " +
                    "SET pin = " + newPin +
                    " WHERE cardNumber = " + cardNum;

            try
            {
                MySqlCommand cmd = new MySqlCommand();
                MySqlConnection conn = getConnection();
                cmd = new MySqlCommand(query, conn);
                cmd.ExecuteNonQuery();
            }
            catch (MySqlException ex)
            {
                Console.Write("Error: " + ex.ToString());
            }

        }


    }
}
