package javaseminars.javaBankAccount.javaseminars.bankAccount.frontEnd;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.gui2.*;
import javaseminars.javaBankAccount.javaseminars.bankAccount.main;

public class TransactionPage {
    public static BasicWindow getWindow() {
        BasicWindow window = new BasicWindow();
        
        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new GridLayout(1));
        
        Panel innerPanel = new Panel();
        innerPanel.setLayoutManager(new GridLayout(2));


        innerPanel.addComponent(new Label("Transaction amount"));
        TextBox transaction = new TextBox();
        innerPanel.addComponent(transaction);
        
        mainPanel.addComponent(innerPanel);
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
                
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        mainPanel.addComponent(new Label("Options"));
        mainPanel.addComponent(new Button("Confirm", new Runnable() {
            @Override
            public void run() {
                if(main.transactionType == 1) {
                    main.cashMachine.
                            getAccounts().
                            get(main.selectedAccount).
                            deposit(Double.parseDouble(transaction.getText()));
                } else {
                    main.cashMachine.
                            getAccounts().
                            get(main.selectedAccount).
                            withdraw(Double.parseDouble(transaction.getText()));
                }
                
                BasicWindow account = accountPage.getWindow();
                window.close();
                main.gui.removeWindow(window);
                main.gui.addWindow(account);
                account.waitUntilClosed();
            }
        }));
        mainPanel.addComponent(new Button("Back", new Runnable() {
            @Override
            public void run() {
                BasicWindow account = accountPage.getWindow();
                window.close();
                main.gui.removeWindow(window);
                main.gui.addWindow(account);
                account.waitUntilClosed();
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
