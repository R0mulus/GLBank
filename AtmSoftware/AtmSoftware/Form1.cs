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
    LANGUAGE, PIN, PINOK, PINWRONG, BLOCKEDCARD, WITHDRAW, SHOWBALANCE, CHANGEPIN
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
        private string newPin;
        private DatabaseConnection database;
        private float balance;

        public Form1(long cardNumber)
        {
            InitializeComponent();
            state = State.LANGUAGE;
            this.CenterToScreen();
            pin = "";
            hiddenPin = "";
            newPin = "";
            setBackground(Color.White, "");
            this.cardNumber = cardNumber;
            database = new DatabaseConnection();
            printScreen();
            
        }

        private void printScreen()
        {

            switch (language)
            {
                case Language.SVK:
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
                                drawText("Zmeniť pin", 15, 10, 165);
                                drawText("Koniec", 15, 10, 250);
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
                                drawText("" + balance, 15, 100, 75);
                                drawText("Späť", 15, 10, 250);
                                saveImage("zostatok.png");
                                break;
                            }
                        case State.CHANGEPIN:
                            {
                                newCanvas();
                                drawText("Zmena pin-u", 20, 85, 20);
                                drawText("Nový pin: " + hiddenPin, 20, 80, 175);
                                drawText("Späť", 15, 10, 250);
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
                        case State.BLOCKEDCARD:
                            {
                                newCanvas();
                                drawText("Zablokovaná karta!", 20, 20, 20);
                                saveImage("neplatnaKarta.png");
                                break;
                            }
                    }
                    break;
                case Language.ENG:
                    switch (state)
                    {
                        case State.LANGUAGE:
                            {
                                newCanvas();
                                drawText("Choose language", 20, 40, 20);
                                drawText("SVK", 15, 10, 250);
                                drawText("ENG", 15, 260, 250);
                                saveImage("picBoxLayoutENG.png");
                                break;
                            }

                        case State.PIN:
                            {
                                newCanvas();
                                drawText("Enter PIN", 20, 80, 20);
                                drawText("" + hiddenPin, 20, 80, 175);
                                saveImage("zadajtePINENG.png");
                                break;
                            }
                        case State.PINOK:
                            {
                                newCanvas();
                                drawText("Withdrawal", 15, 10, 5);
                                drawText("Account balance", 15, 10, 85);
                                drawText("Change pin", 15, 10, 165);
                                drawText("Exit", 15, 10, 250);
                                saveImage("pinOKeng.png");
                                break;
                            }
                        case State.WITHDRAW:
                            {
                                newCanvas();
                                drawText("10", 15, 10, 5);
                                drawText("20", 15, 10, 85);
                                drawText("50", 15, 10, 165);
                                drawText("Back", 15, 10, 250);
                                drawText("100", 15, 260, 5);
                                drawText("200", 15, 260, 85);
                                drawText("500", 15, 260, 165);
                                saveImage("vyberPeniazeENG.png");
                                break;
                            }
                        case State.SHOWBALANCE:
                            {
                                newCanvas();
                                drawText("Balance", 20, 90, 20);
                                drawText("" + balance, 15, 100, 75);
                                drawText("Back", 15, 10, 250);
                                saveImage("zostatokENG.png");
                                break;
                            }
                        case State.CHANGEPIN:
                            {
                                newCanvas();
                                drawText("Changing pin", 20, 85, 20);
                                drawText("New pin: " + hiddenPin, 20, 80, 175);
                                drawText("Back", 15, 10, 250);
                                saveImage("zmenaPinuENG.png");
                                break;
                            }
                        case State.PINWRONG:
                            {
                                newCanvas();
                                drawText("Wrong pin!", 20, 85, 20);
                                saveImage("chybnyPinENG.png");
                                break;
                            }
                        case State.BLOCKEDCARD:
                            {
                                newCanvas();
                                drawText("Card is blocked!", 20, 20, 20);
                                saveImage("neplatnaKartaENG.png");
                                break;
                            }
                    }
                    break;
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
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "1";
                hiddenPin += "*";
            }
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "1";
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
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "9";
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
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "6";
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
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "3";
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
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "0";
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
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "8";
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
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "5";
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
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "2";
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
            else if(state == State.CHANGEPIN && newPin.Length > 1)
            {
                newPin = newPin.Substring(0, newPin.Length - 1);
                hiddenPin = hiddenPin.Substring(0, hiddenPin.Length - 1);
                printScreen();
            }else if (state == State.CHANGEPIN)
            {
                newPin = "";
                hiddenPin = "";
                printScreen();
            }

        }

        private void button10_Click(object sender, EventArgs e)
        {
            if (state == State.PIN && pin.Length < 4)
            {
                pin = pin + "7";
                hiddenPin += "*";
            }
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "7";
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
            else if (state == State.CHANGEPIN && newPin.Length < 4)
            {
                newPin = newPin + "4";
                hiddenPin += "*";
            }
            printScreen();
        }

        private void button17_Click(object sender, EventArgs e)
        {
            switch (state)
            {
                case State.PIN:
                    checkPinCode();
                    printScreen();
                    break;
                case State.CHANGEPIN:
                    changePin();
                    printScreen();
                    break;
                case State.PINWRONG:
                    checkCard();
                    printScreen();
                    break;
            } 

        }

        private void changePin()
        {
            
            int newPinToInt = Convert.ToInt16(newPin);
            database.changePin(cardNumber, newPinToInt);
            state = State.PINOK;
            newPin = "";
            hiddenPin = "";
            MessageBox.Show("Pin changed!");

        }

        private void checkCard()
        {
            if (database.isCardBlocked(cardNumber))
            {
                state = State.BLOCKEDCARD;
                printScreen();
            }
            else
            {
                state = State.PIN;
                printScreen();
            }
            
        }

        private void checkPinCode()
        {
            if(pin != null)
            {
                int pinToInt = Convert.ToInt16(pin);
                if (database.isPinCorrect(cardNumber, pinToInt))
                {
                    database.findAndDeleteCardFromWrongPins(cardNumber);
                    state = State.PINOK;
                    pin = "";
                    hiddenPin = "";
                }
                else
                {
                    database.changeWrongPinState(cardNumber);
                    checkCard();
                    pin = "";
                    hiddenPin = "";
                    state = State.PINWRONG;
                    printScreen();
                }
            }
            else
            {
                database.changeWrongPinState(cardNumber);
                checkCard();
                pin = "";
                hiddenPin = "";
                state = State.PINWRONG;
                printScreen();

            }
        }

        private void btnMain4_Click(object sender, EventArgs e)
        {
            switch (state)
            {
                case State.LANGUAGE:
                    language = Language.SVK;
                    checkCard();
                    break;
                case State.WITHDRAW:
                    state = State.PINOK;
                    printScreen();
                    break;
                case State.SHOWBALANCE:
                    state = State.PINOK;
                    printScreen();
                    break;
                case State.PINOK:
                    this.Dispose();
                    break;
                case State.CHANGEPIN:
                    state = State.PINOK;
                    printScreen();
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
            switch (state)
            {
                case State.PINOK:
                    state = State.WITHDRAW;
                    printScreen();
                    break;
                case State.WITHDRAW:
                    withdrawal(10);
                    break;
            }
        }

        private void withdrawal(int sum)
        {
            if (database.withdrawFromAccount(sum, cardNumber))
            {
                MessageBox.Show(sum + " withdrew!");
            }
            else
            {
                MessageBox.Show("Not enough money on card!");
            }
        }

        private void showBalance()
        {
            state = State.SHOWBALANCE;
            balance = database.getBalance(cardNumber);
            printScreen();
        }

        private void btnMain2_Click(object sender, EventArgs e)
        {
            switch (state)
            {
                case State.PINOK:
                    showBalance();
                    break;
                case State.WITHDRAW:
                    withdrawal(20);
                    break;
            }
        }

        private void btnMain3_Click(object sender, EventArgs e)
        {
            switch (state)
            {
                case State.WITHDRAW:
                    withdrawal(50);
                    break;
                case State.PINOK:
                    state = State.CHANGEPIN;
                    printScreen();
                    break;
                      
            }
        }

        private void btnMain5_Click(object sender, EventArgs e)
        {
            switch (state)
            {
                case State.WITHDRAW:
                    withdrawal(100);
                    break;

            }
        }

        private void btnMain6_Click(object sender, EventArgs e)
        {
            switch (state)
            {
                case State.WITHDRAW:
                    withdrawal(200);
                    break;

            }
        }

        private void btnMain7_Click(object sender, EventArgs e)
        {
            switch (state)
            {
                case State.WITHDRAW:
                    withdrawal(500);
                    break;

            }
        }
    }
}
