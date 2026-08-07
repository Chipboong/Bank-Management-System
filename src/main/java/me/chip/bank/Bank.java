package me.chip.bank;

import java.sql.SQLException;

public interface Bank {
    String getBankName();
    String getBankID();

    void register(String username);

    void deposit(String accountID, double amount);

//    void withdraw(Account account, double amount) throws SQLException;

    void transfer(
        String fromAccountId,
        String toAccountId,
        String toBankId,
        double amount
    );

    boolean closeAccount(String accountId);
}
