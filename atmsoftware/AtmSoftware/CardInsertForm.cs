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
            Form1 form1 = new Form1(1111222233334444);
            form1.ShowDialog();
            this.Show();
        }
    }
}
