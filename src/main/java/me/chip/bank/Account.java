package me.chip.bank;

public class Account extends ChipBank
{
    private final String accountHolderName;
    private String accountNumber;
    private double balance;

    public Account(String name) {
        super("ChipBank","112");
        this.accountHolderName = name;
    }

    public double getBalance() {
        return this.balance;
    }






}
