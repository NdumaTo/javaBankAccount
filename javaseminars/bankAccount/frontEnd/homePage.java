package javaseminars.javaBankAccount.javaseminars.bankAccount.frontEnd;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.gui2.*;
import javaseminars.javaBankAccount.javaseminars.bankAccount.*;
import java.util.Map;

public class homePage {
    
    //Function that returns the homepage
    public static BasicWindow getWindow(){
        //Builds a window
        BasicWindow window = new BasicWindow();
        
        //Get all the registered accounts
        Map accounts = main.cashMachine.getAccounts();

        //Panels are used to hold components and build layouts
        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new GridLayout(1)); // Column layout
        
        Panel innerPanel = new Panel();
        innerPanel.setLayoutManager(new GridLayout(2)); //2 Column layout
        mainPanel.addComponent(new EmptySpace(new TerminalSize(2, 0)));//Spacing
        mainPanel.addComponent(new Label("Accounts"));
        
        //Dynamically generate entries on the window for each account
        //With the ID as the label and the balance as the button
        for(Map.Entry<Integer, Account> account : main.cashMachine.getAccounts().entrySet()) {
            innerPanel.addComponent(new Label(account.getKey().toString()));
            innerPanel.addComponent(new Button(Double.toString(account.getValue().getBalance()),
            
            // Actions to run when the button is activated
            new Runnable() {
                @Override
                
                //Set the selected account key to this account's ID
                //Show the account detail view
                public void run() {
                    main.selectedAccount = account.getKey();
                    BasicWindow accountWindow = accountPage.getWindow();
                    window.close();
                    
                    //Get rid of everything that the gui was showing before
                    //Then add the account detail view
                    main.gui.removeWindow(window);
                    main.gui.addWindow(accountWindow);
                    accountWindow.waitUntilClosed();
                }
            }));
        }
        
        // Nest the panels to build the layout        
        mainPanel.addComponent(innerPanel);
        
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        mainPanel.addComponent(new Label("Options"));
        
        //Go to the account creation view
        mainPanel.addComponent(new Button("Add account", new Runnable() {
            @Override
            public void run() {
                BasicWindow accountCreation = accountCreationPage.getWindow();
                window.close();
                main.gui.removeWindow(window);
                main.gui.addWindow(accountCreation);
                accountCreation.waitUntilClosed();
            }
        }));
        
        //Close everything
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
