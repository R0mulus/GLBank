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


    }
}
