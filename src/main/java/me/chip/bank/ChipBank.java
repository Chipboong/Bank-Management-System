package me.chip.bank;

import me.chip.SQLite;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.lang.Math;

public class ChipBank implements Bank {

    final String bankName = "ChipBank";
    final String bankId = "4012";

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
        boolean success = false;
        while(!success) {
            int ID = (int) (Math.random() * 1000);
            try(Connection conn = SQLite.getConnection();
            Statement stmt = conn.createStatement()){
                String userReg = "INSERT INTO user VALUES(" + ID + ", \"" + username + "\");";
                stmt.execute(userReg);
                String last4ID = Integer.toString(ID);
                while(last4ID.length() < 4){
                    last4ID = "0" + last4ID;
                }
                String accountReg = "INSERT INTO account(accountID,balance,bankID,userID) VALUES (\'4012"+ last4ID + "\', 0, 4012,"+ID+");";
                stmt.execute(accountReg);
                success = true;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

        }
    System.out.println("User Created Successfully!");
    }

    @Override
    public void deposit(Account account, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'deposit'"
        );
    }

    @Override
    public void withdraw(Account account, double amount) throws SQLException{
        // TODO Auto-generated method stub
        double balance = account.getBalance() - amount;
        account.setBalance(balance);
       try(Connection conn = SQLite.getConnection();
           Statement stmt = conn.createStatement()){
           String sql = "UPDATE account SET balance =" + account.getBalance() + " WHERE accountID = "+ account.getID();
           stmt.execute(sql);
       }
//       catch(SQLException e) {
//           System.out.println(e.getMessage());
//       }
    }

    @Override
    public void transfer(
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
