package me.chip.bank;

import me.chip.SQLite;

import java.sql.Connection;

public class ChipBank implements Bank {

    final String bankName;
    final String bankId;
    final String url = "jdbc:sqlite:bank_db.sqlite";
    public ChipBank(String bankName, String bankId) {
        this.bankName = bankName;
        this.bankId = bankId;
    }

    @Override
    public String getBankName() {
        return this.bankName;
    }

    @Override
    public String getBankID() {
        return this.bankId;
    }

    @Override
    public void register(String username) {
        String reg = "";

    }

    @Override
    public void deposit(Account account, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'deposit'"
        );
    }

    @Override
    public double withdraw(String accountId, double amount) {
        // TODO Auto-generated method stub
        String
       try(Connection conn = SQLite.getConnection()){
           if (conn != null){

           }
       }
    }

    @Override
    public boolean transfer(
        String fromAccountId,
        String toAccountId,
        String toBankId,
        double amount
    ) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'transfer'"
        );
    }

    @Override
    public boolean closeAccount(String accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'closeAccount'"
        );
    }
}
