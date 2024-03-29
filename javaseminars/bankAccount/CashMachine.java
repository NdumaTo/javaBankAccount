package javaseminars.javaBankAccount.javaseminars.bankAccount;

import java.util.HashMap;
import java.util.Map;

public class CashMachine {
    // accounts map stores Account objects with their id as the key.
    private Map<Integer,Account> accounts;

    // constructor
    public CashMachine() {
        this.accounts = new HashMap<>();
    }

    // adds a new account to the cash machine.
    public boolean addAccount(int id, double initialDeposit, String pin, double interestRate){
        // returns false if pin isn't valid or initial deposit is less than 0.
        if(!(pin.matches("\\d{4}")||initialDeposit<0)){
            return false;
        }
        accounts.put(id,new Account(id, initialDeposit, pin, interestRate));
        return true;
    }

    // overloaded addAccount method for adding default accounts.
    public boolean addAccount(){
        accounts.put(0, new Account());
        return true;
    }

    // returns accounts
    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    // runs the cash machine for a user.
    public void run(){
        //TODO: add ui here?
    }

    // test
    public static void main(String[] args) {
        CashMachine cashMachineTest = new CashMachine();
        cashMachineTest.addAccount(12345,0,"1234", 3.9);
        cashMachineTest.run();
    }
}