package javaseminars.bankAccount;

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
    public boolean addAccount(int id, double initialDeposit, String pin){
        if(!(pin.matches("\\d{4}")||initialDeposit<0)){
            return false;
        }
        accounts.put(id,new Account(id, initialDeposit,pin));
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
        cashMachineTest.addAccount(12345,0,"1234");
        cashMachineTest.run();
    }
}