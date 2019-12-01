package javaseminars.bankAccount;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//TODO: FIND A CLI USER INTERFACE
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
//      use the Instant.now() method to get current date
        this.dateCreated = Date.from(Instant.now().truncatedTo(ChronoUnit.DAYS));
    }

    public void Account(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
        // use the Instant.now() method to get current date
        this.dateCreated = Date.from(Instant.now().truncatedTo(ChronoUnit.DAYS));
    }

    public Date getDate() { return this.dateCreated; }

    // getter for annualInterestRate
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate/12;
    }

    public void withdraw(double withdrawl) {
        this.balance -= withdrawl;
    }

    // fancy deposit method.
    // only allows positive deposits.
    public double deposit(double amount){
        if (amount > 0) {
            balance += amount;
            System.out.println("£"+String.format("%.2f",amount)+" Deposited");
            return balance;
        }
        System.out.println("Deposit must be Positive.");
        return -1;

    }
}
