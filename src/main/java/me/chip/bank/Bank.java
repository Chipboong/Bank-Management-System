package me.chip.bank;

public class Bank {

    String bankID;

    public void deposit(double amount, String account_id) {}

    public void withdraw(double amount, String account_id) {}

    public String createAccount(String username) {
        // return account_id
        return "Hello";
    }

    public boolean deleteAccount(String username) {
        return false;
    }

    public boolean transfer(
        String username,
        double amount,
        String toUser,
        Bank bank
    ) {
        return false;
    }
}
