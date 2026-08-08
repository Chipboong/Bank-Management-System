package me.chip.bank;

import me.chip.SQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

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
    public void deposit(String accountID, double amount) {
        // TODO Auto-generated method stub
        boolean validID = getUserByID(accountID);
        if(!validID || amount <= 0){
            System.out.println("Account NOT found!");
            return;
        }
        String depSQL = "UPDATE account SET balance = balance + ? WHERE accountID = ?;";
        try(Connection conn = SQLite.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(depSQL)) {
            pstmt.setDouble(1,amount);
            pstmt.setString(2,accountID);
            pstmt.executeUpdate();
            System.out.println("Deposit Succeed!");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void transfer(
        String fromAccountId,
        String toAccountId,
        String toBankId,
        double amount
    ) {
        // TODO Auto-generated method stub
      if (!getUserByID(fromAccountId) || !getUserByID(toAccountId) || amount<= 0) {
            if(amount <= 0) {
                System.out.println("Please Enter a Valid Amount!");
                return;
            }
          System.out.println("Account Not Found!");
            return;

      }
      Account transferrerAcc = new Account(fromAccountId);
      if(transferrerAcc.getBalance() - amount < 0){
          System.out.println("Insufficient Amount!");
          return;
      }
      String withdrawSQL = "UPDATE account SET balance = balance - ? WHERE accountID = ?;";
       String depositSQL = " UPDATE account SET balance = balance + ? WHERE accountID = ?;";

       try(Connection conn = SQLite.getConnection()){

       try(PreparedStatement pstmt = conn.prepareStatement(withdrawSQL)) {
           pstmt.setDouble(1, amount);
           pstmt.setString(2, fromAccountId);
           pstmt.execute();
       } catch(SQLException e) {
           conn.rollback();
       }
       try(PreparedStatement pstmt = conn.prepareStatement(depositSQL)) {
           pstmt.setDouble(1, amount);
           pstmt.setString(2, toAccountId);
           pstmt.execute();
       } catch (SQLException e) {
           conn.rollback();
       }

          System.out.println("Transfer Succeed!");

          } catch(SQLException e){
          System.out.println(e.getMessage());
      }
    }

    @Override
    public boolean closeAccount(String accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
            "Unimplemented method 'closeAccount'"
        );
    }

    public static boolean getUserByID(String ID){
    String getUserSQL = "SELECT * from account where accountID = ?";
    try(Connection conn = SQLite.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(getUserSQL)){
        pstmt.setString(1,ID);
      try ( ResultSet rs = pstmt.executeQuery()){
          while(rs.next()){
              String accountID = rs.getString("accountID");
              if (accountID != null) {
                  return true;
              }
          }
      }

    } catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return false;
    }

}
