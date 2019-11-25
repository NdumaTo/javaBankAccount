package javaseminars.bankAccount;

//TODO: FIND THE DATE LIBRARY
//TODO: FIND A CLI USER INTERFACE
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    
    public void Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        
        //Todo: Instantiate date ting
    }
    
    public void Account(int id, double initialBalance) {
        this.id = id;
        this.balance = balance;
    //Todo: Instantiate date ting
    }
    
    public Date getDate() { return this.dateCreated; }
    
    public double getMonthlyInterestRate() {
        return this.annualInterestRate/12;
    }
    
    public void withdraw(double withdrawl) {
        this.balance -= withdrawl;
    }
    
    public void deposit(double deposit) {
        this.balance -= deposit;
    }
}
