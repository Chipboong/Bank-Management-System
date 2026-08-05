package me.chip.bank;

public class Account extends ChipBank
{
    private final String accountHolderName;
    private String accountNumber;
    private double balance;

    public Account(String name, String accountNumber) {
        super();
        this.accountHolderName = name;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName(){return this.accountHolderName;}

    public double getBalance() {
        return this.balance;
    }

    public void setBalance (double amount) {
        if (amount > 0) {
            this.balance = amount;
        }
    }

    public String getID() {
        return this.accountNumber;
    }

    public void withdraw(double amount) {
        if (this.balance - amount > 0) {
            System.out.println("Insufficient amount");
            return;
        }
        this.balance -= amount;
    }

}
