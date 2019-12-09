package javaseminars.javaBankAccount.javaseminars.bankAccount;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.gui2.*;
import javaseminars.javaBankAccount.javaseminars.bankAccount.frontEnd.*;

public class main {
    
    //Public variables to make data transfer easier
    public static CashMachine cashMachine = new CashMachine();
    public static int ID;
    public static String pin;
    public static double initialBalance;
    public static double transactionAmmount;
    public static Screen screen = new DefaultTerminalFactory().createScreen();
    public static MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
    public static int selectedAccount;
    public static int transactionType;
    
    static void setup() {
        //Add a bunch of accounts
        cashMachine.addAccount(321, 100.00, "1234", 5.00);
        cashMachine.addAccount(123, 200, "1234", 5.00);
        cashMachine.addAccount(132, 300, "1234", 5.00);
        cashMachine.addAccount(213, 400, "1234", 5.00);

        //Get the homepage
        BasicWindow currentWindow = homePage.getWindow();
        
        //Overlay the homepage onto the gui object and display the window, screen and gui
        gui.addWindow(currentWindow);
        screen.startScreen();
        currentWindow.waitUntilClosed();

    }
    
    public static void main(String[] args) {
        //Start the show
        setup();
    }
}
