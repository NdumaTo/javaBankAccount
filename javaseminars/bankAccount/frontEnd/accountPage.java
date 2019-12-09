package javaseminars.javaBankAccount.javaseminars.bankAccount.frontEnd;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.gui2.*;
import javaseminars.javaBankAccount.javaseminars.bankAccount.*;

public class accountPage {
    
    //Returns the account view
    public static BasicWindow getWindow() {
        
        BasicWindow window = new BasicWindow();
        
        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new GridLayout(1));
        
        Panel innerPanel = new Panel();
        innerPanel.setLayoutManager(new GridLayout(2));
        mainPanel.addComponent(new Label("Account Details"));
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        
        
        //Gets the account details and display
        innerPanel.addComponent(new Label("Account Balance:"));
        innerPanel.addComponent(new Label(Double.toString(main.cashMachine.getAccounts().get(main.selectedAccount).getBalance())));
        
        innerPanel.addComponent(new Label("Account Number:"));
        innerPanel.addComponent(new Label(Integer.toString(main.cashMachine.getAccounts().get(main.selectedAccount).getId())));
        
        innerPanel.addComponent(new Label("Interest Rate:"));
        innerPanel.addComponent(new Label(Double.toString(main.cashMachine.getAccounts().get(main.selectedAccount).getAnnualInterestRate())));
        
        mainPanel.addComponent(innerPanel);
        
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        mainPanel.addComponent(new Label("Actions"));

                
        mainPanel.addComponent(new Button("Deposit", new Runnable() {
            @Override
            public void run() {
                main.transactionType = 1;
                
                BasicWindow transactionPage = TransactionPage.getWindow();
                window.close();
                main.gui.removeWindow(window);
                main.gui.addWindow(transactionPage);
                transactionPage.waitUntilClosed();
            }                
        }));
        mainPanel.addComponent(new Button("Withdraw", new Runnable() {
            @Override
            public void run() {
                main.transactionType = 0;
                
                BasicWindow transactionPage = TransactionPage.getWindow();
                window.close();
                main.gui.removeWindow(window);
                main.gui.addWindow(transactionPage);
                transactionPage.waitUntilClosed();
            }
        }));

                        
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        mainPanel.addComponent(new Label("Options"));
        mainPanel.addComponent(new Button("Back", new Runnable() {
            @Override
            public void run() {
                BasicWindow home = homePage.getWindow();
                window.close();
                main.gui.removeWindow(window);
                main.gui.addWindow(home);
                home.waitUntilClosed();
            }
        }));
        mainPanel.addComponent(new Button("Exit", new Runnable() {
            @Override
            public void run() {
                window.close();
                main.screen.stopScreen();
            }
        }));

        
        window.setComponent(mainPanel);        
        return window;
    }
    
}

