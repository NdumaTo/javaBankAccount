package javaseminars.javaBankAccount.javaseminars.bankAccount.frontEnd;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.gui2.*;
import javaseminars.javaBankAccount.javaseminars.bankAccount.main;

public class accountCreationPage {
    
    public static BasicWindow getWindow() {
        BasicWindow window = new BasicWindow();
        
        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new GridLayout(1));
        
        Panel innerPanel = new Panel();
        innerPanel.setLayoutManager(new GridLayout(2));
        mainPanel.addComponent(new Label("Create An Account"));
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));       
        
        innerPanel.addComponent(new Label("Account ID"));
        TextBox initialId = new TextBox();
        innerPanel.addComponent(initialId);
        
        innerPanel.addComponent(new Label("Account Balance"));
        TextBox initialBalance = new TextBox();
        innerPanel.addComponent(initialBalance);
        
        innerPanel.addComponent(new Label("Interest Rate:"));
        TextBox initialInterest = new TextBox();
        innerPanel.addComponent(initialInterest);
        
        innerPanel.addComponent(new Label("Pin:"));
        TextBox initialPin = new TextBox();
        initialPin.setMask('*');
        innerPanel.addComponent(initialPin);
        
        mainPanel.addComponent(innerPanel);
        
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        mainPanel.addComponent(new Label("Actions"));

                
        mainPanel.addComponent(new Button("Create Default", new Runnable() {
            @Override
            public void run() {
                main.cashMachine.addAccount();
                
                BasicWindow home = homePage.getWindow();
                window.close();
                main.gui.removeWindow(window);
                main.gui.addWindow(home);
                home.waitUntilClosed();
            }
        }));
        mainPanel.addComponent(new Button("Create Custom", new Runnable() {
            @Override
            public void run() {
                System.out.println(main.cashMachine.addAccount(Integer.parseInt(initialId.getText()),
                        Double.parseDouble(initialBalance.getText()),
                        initialPin.getText(),
                        Double.parseDouble(initialInterest.getText())));
                
                BasicWindow home = homePage.getWindow();
                window.close();
                main.gui.removeWindow(window);
                main.gui.addWindow(home);
                home.waitUntilClosed();
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
