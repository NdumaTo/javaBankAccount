package javaseminars.javaBankAccount.javaseminars.bankAccount;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//TODO: FIND A CLI USER INTERFACE
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private String pin;

    // default constructor (no parameters)
    Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
//      use the Instant.now() method to get current date/time (limited accuracy to minutes)
        this.dateCreated = Date.from(Instant.now().truncatedTo(ChronoUnit.MINUTES));
        // pin is default 0000
        this.pin = "0000";
        this.annualInterestRate = 3.9;
    }

    // Account constructor with id, initialBalance and pin specified as parameters.
    Account(int id, double initialBalance, String pin, double interestRate) {
        this.id = id;
        this.balance = initialBalance;
        // use the Instant.now() method to get current date and time (limited accuracy to minutes)
        this.dateCreated = Date.from(Instant.now().truncatedTo(ChronoUnit.MINUTES));
        // only allows 4 digit pin numbers, default 0000
        if (pin.matches("\\d{4}")){
            this.pin = pin;
        }else {
            this.pin = "0000";
        }
        
        this.annualInterestRate = interestRate;
    }

    // getters and setters for id and balance
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // correctPin method checks the validity of an inputted pin.
    boolean correctPin(String inputPin){
        return (inputPin.equals(this.pin));
    }

    public Date getDateCreated() { return this.dateCreated; }

    // getter for annualInterestRate
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate/12;
    }

    // fancy withdraw
    // withdrawal must be positive and less than or equal to balance.
    public boolean withdraw(double withdrawal) {
        if (withdrawal > 0 && withdrawal <= this.balance) {
            this.balance -= withdrawal;
            return true;
        }else {
            return false;
        }
    }

    // fancy deposit method.
    // only allows positive deposits.
    public boolean deposit(double amount){
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}
