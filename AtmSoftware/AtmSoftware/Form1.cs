using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

enum State
{
    LANGUAGE, PIN, PINOK, PINWRONG, INVALIDCARD, WITHDRAW, SHOWBALANCE, CHANGEPIN
}

enum Language
{
    SVK,ENG
}


namespace AtmSoftware
{
    public partial class Form1 : Form
    {

        private State state;
        private Language language;
        private long cardNumber;
        private string pin;
        private string hiddenPin;
        private DatabaseConnection database;

        public Form1(long cardNumber)
        {
            InitializeComponent();
            state = State.LANGUAGE;
            this.CenterToScreen();
            pin = "";
            hiddenPin = "";
            setBackground(Color.White, "");
            this.cardNumber = cardNumber;
            database = new DatabaseConnection();
            printScreen();
            
        }

        private void printScreen()
        {
            switch (state)
            {
                case State.LANGUAGE:
                    {
                        newCanvas();
                        drawText("Vyberte si jazyk", 20, 40, 20);
                        drawText("SVK", 15, 10, 250);
                        drawText("ENG", 15, 260, 250);
                        saveImage("picBoxLayout.png");
                        break;
                    }
                    
                case State.PIN:
                    {
                        newCanvas();
                        drawText("Zadajte PIN", 20, 80, 20);
                        drawText("" + hiddenPin, 20, 80, 175);
                        saveImage("zadajtePIN.png");
                        break;
                    }
                case State.PINOK:
                    {
                        newCanvas();
                        drawText("Výber z účtu", 15, 10, 5);
                        drawText("Zostatok na účte", 15, 10, 85);
                        drawText("Zmena pinu", 15, 10, 165);
                        saveImage("pinOKsvk.png");
                        break;
                    }
                case State.WITHDRAW:
                    {
                        newCanvas();
                        drawText("10", 15, 10, 5);
                        drawText("20", 15, 10, 85);
                        drawText("50", 15, 10, 165);
                        drawText("Späť", 15, 10, 250);
                        drawText("100", 15, 260, 5);
                        drawText("200", 15, 260, 85);
                        drawText("500", 15, 260, 165);
                        saveImage("vyberPeniaze.png");
                        break;
                    }
                case State.SHOWBALANCE:
                    {
                        newCanvas();
                        drawText("Zostatok", 20, 90, 20);
                        drawText("Nič moc", 15, 100, 75);
                        saveImage("zostatok.png");
                        break;
                    }
                case State.CHANGEPIN:
                    {
                        newCanvas();
                        drawText("Zmena pinu", 20, 85, 20);
                        saveImage("zmenaPinu.png");
                        break;
                    }
                case State.PINWRONG:
                    {
                        newCanvas();
                        drawText("Chybný pin!", 20, 85, 20);
                        saveImage("chybnyPin.png");
                        break;
                    }
                case State.INVALIDCARD:
                    {
                        newCanvas();
                        drawText("Zablokovaná karta!", 20, 20, 20);
                        saveImage("neplatnaKarta.png");
                        break;
                    }
            }
        }

        private void setBackground(Color col, string paperFile)
        {
            if (paperFile == "") pictureBox1.BackColor = col;
            else pictureBox1.BackgroundImage = Image.FromFile(paperFile);
        }

        private void newCanvas()
        {
            Bitmap bmp = new Bitmap(pictureBox1.ClientSize.Width, pictureBox1.ClientSize.Height);
            pictureBox1.Image = bmp;
        }

        private void drawText(String text, int fontSize, int left, int top)
        {
            using (Font font = new Font("Arial", fontSize))
            using (Graphics G = Graphics.FromImage(pictureBox1.Image))
            {
                // no anti-aliasing, please
                G.TextRenderingHint = System.Drawing.Text.TextRenderingHint.SingleBitPerPixel;
                G.DrawString(text, font, Brushes.Black, left, top);
            }
            pictureBox1.Invalidate();
        }

        private void saveImage(string filename)
        {
            using (Bitmap bmp = new Bitmap(pictureBox1.ClientSize.Width,
                                           pictureBox1.ClientSize.Height))
            {
                pictureBox1.DrawToBitmap(bmp, pictureBox1.ClientRectangle);
                bmp.Save(filename);
            }
        }



        private void button12_Click(object sender, EventArgs e)
        {
           if(state == State.PIN && pin.Length < 4)
            {
                pin = pin + "1";
                hiddenPin += "*";
            }
            printScreen();
            
        }

        private void button18_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "9";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button19_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "6";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button20_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "3";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button13_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "0";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button14_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "8";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button15_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "5";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button16_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "2";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button9_Click(object sender, EventArgs e)
        {

            if (state == State.PIN && pin.Length > 1)
            {
                pin = pin.Substring(0, pin.Length - 1);
                hiddenPin = hiddenPin.Substring(0, hiddenPin.Length - 1);
                printScreen();
            }
            else if(state == State.PIN)
            {
                pin = "";
                hiddenPin = "";
                printScreen();
            }
            Console.Write(pin + " ");

        }

        private void button10_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "7";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button11_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "4";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button17_Click(object sender, EventArgs e)
        {
            //todo activate check if pin is ok
            if(state == State.PIN) Console.Write(pin);

        }

        private void txtBoxMainPIN_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
            }
        }

        private void checkCard()
        {
            Console.Write(cardNumber);
            if (!database.isCardBlocked(cardNumber))
            {
                state = State.PIN;
                printScreen();
            }
            else
            {
                state = State.INVALIDCARD;
                printScreen();
            }
        }

        private void checkPinCode()
        {
            //todo spravny

            //todo nespravny
        }

        private void btnMain4_Click(object sender, EventArgs e)
        {
            switch (state)
            {
                case State.LANGUAGE:
                    this.language = Language.SVK;
                    checkCard();
                    break;
            }
        }

        private void btnMain8_Click(object sender, EventArgs e)
        {
            switch (state)
            {
                case State.LANGUAGE:
                    this.language = Language.ENG;
                    checkCard();
                    break;
            }
        }

        private void btnMain1_Click(object sender, EventArgs e)
        {

            if (state == State.PIN)
            {
                state = State.LANGUAGE;
            }
            else if (state == State.LANGUAGE)
            {
                state = State.CHANGEPIN;
            }
            else if(state == State.CHANGEPIN)
            {
                state = State.PINOK;
            }
            else if (state == State.PINOK)
            {
                state = State.PINWRONG;
            }
            else if (state == State.PINWRONG)
            {
                state = State.INVALIDCARD;
            }
            else if (state == State.INVALIDCARD)
            {
                state = State.SHOWBALANCE;
            }
            else if(state == State.SHOWBALANCE)
            {
                state = State.WITHDRAW;
            }

            else
            {
                state = State.PIN;
            }

            printScreen();
        }

        private void btnMain2_Click(object sender, EventArgs e)
        {

        }

        private void btnMain3_Click(object sender, EventArgs e)
        {

        }

        private void btnMain5_Click(object sender, EventArgs e)
        {

        }

        private void btnMain6_Click(object sender, EventArgs e)
        {

        }

        private void btnMain7_Click(object sender, EventArgs e)
        {

        }
    }
}
