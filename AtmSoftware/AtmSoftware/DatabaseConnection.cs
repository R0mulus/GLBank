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
            String query = "SELECT idCard FROM Cards WHERE cardNumber LIKE " + cardNum;
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

        public bool isCardBlocked(long cardNum)
        {
            String query = "SELECT blocked FROM Cards WHERE cardNumber LIKE " + cardNum;
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
            String query = "SELECT pin FROM Cards WHERE cardNumber LIKE " + cardNum;
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
            String query = "SELECT balance FROM Accounts " + 
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
            if(isBalanceSmallerOrSameThanWithdrawal(withdrawal, cardNum))
            {
                string query = "UPDATE Accounts " + 
                    "INNER JOIN Cards ON Accounts.idacc = Cards.idacc " +
                    "SET balance = balance - " + withdrawal +
                    " WHERE Cards.cardNumber LIKE " + cardNum;

                MySqlConnection conn = getConnection();
                if (conn != null)
                {
                    MySqlCommand cmd = new MySqlCommand(query, conn);
                    cmd.ExecuteNonQuery();
                    return true;
                }
                return false;
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
            String query = "SELECT balance FROM Accounts " +
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


    }
}
