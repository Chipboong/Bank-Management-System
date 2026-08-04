package me.chip.bank.Bank;

public class Account extends ChipBank
{
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public Account(String name) {
        super("ChipBank","112");
        this.accountHolderName = name;
    }



}
