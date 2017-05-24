using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AtmSoftware
{
    public partial class CardInsertForm : Form
    {
        public CardInsertForm()
        {
            InitializeComponent();
            this.CenterToScreen();
            this.ActiveControl = txtBoxCardNum;
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnOK_Click(object sender, EventArgs e)
        {
            this.Hide();
            long cardNum = Convert.ToInt64(txtBoxCardNum.Text);
            DatabaseConnection database = new DatabaseConnection();
            if (database.existsCard(cardNum))
            {
                Form1 form1 = new Form1(cardNum);
                form1.ShowDialog();
                this.Show();
            }
            else
            {
                MessageBox.Show("Invalid card number!");
                txtBoxCardNum.Text = "";
                this.Show();
            }
            
        }

        private long convertToLong(string text)
        {
            long num = 0;

            try {
                
                if (text.Length > 0) num = Convert.ToInt64(text);
                
            }
            catch(Exception e)
            {
                MessageBox.Show("Error: " + e);
            }

            return num;
        }
    }
}
