package me.chip.bank.Bank;

public interface Bank {
    String getBankName();
    String getBankID();

    String register(String username);

    void deposit(String accountId, double amount);

    double withdraw(String accountId, double amount);

    boolean transfer(
        String fromAccountId,
        String toAccountId,
        String toBankId,
        double amount
    );

    boolean closeAccount(String accountId);
}
