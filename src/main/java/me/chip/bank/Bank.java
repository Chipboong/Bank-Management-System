package me.chip.bank;

public interface Bank {
    String getBankName();
    String getBankID();

    void register(String username);

    void deposit(Account account, double amount);

    double withdraw(String accountId, double amount);

    boolean transfer(
        String fromAccountId,
        String toAccountId,
        String toBankId,
        double amount
    );

    boolean closeAccount(String accountId);
}
