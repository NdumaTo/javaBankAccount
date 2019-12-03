package javaseminars.bankAccount;

import java.util.HashMap;
import java.util.Map;

public class CashMachine {
    private Map<Integer,Account> accounts;

    public CashMachine() {
        this.accounts = new HashMap<>();
    }

    public boolean addAccount(int id, double initialDeposit, String pin){
        if(!(pin.matches("\\d{4}")||initialDeposit<0)){
            return false;
        }
        accounts.put(id,new Account(id, initialDeposit,pin));
        return true;
    }

    public void run(){
        //TODO: add ui here?
    }

    public static void main(String[] args) {
        CashMachine cashMachineTest = new CashMachine();
        cashMachineTest.addAccount(12345,0,"1234");
        cashMachineTest.run();
    }
}