package me.chip.bank;

import me.chip.SQLite;

import java.sql.*;


public class Account
{
    private final String accountHolderName;
    private String accountNumber;
    private double balance;

    public Account(String name, String accountNumber) {
        this.accountHolderName = name;
        this.accountNumber = accountNumber;
        init();
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

//    public void withdraw(double amount) {
//        if (this.balance - amount > 0) {
//            System.out.println("Insufficient amount");
//            return;
//        }
//        this.balance -= amount;
//    }


//    public void transfer(Account account, double amount){
//        if(this.balance - amount < 0 || amount < 0) {
//            System.out.println("Insufficient Amount Or The amount is invalid!");
//            return;
//        }
//        try(Connection conn = SQLite.getConnection()){
//            String transferSQL = "UPDATE account SET balance = balance - ? WHERE accountID = ?;" +
//                    "UPDATE account SET balance = balance + ? WHERE accountID = ?;";
//            try(PreparedStatement pstmt = conn.prepareStatement(transferSQL)){
//                //Take the balance from the transferrer
//                pstmt.setDouble(1,this.balance - amount);
//                pstmt.setString(2, this.accountNumber);
//
//                //put the money from
//            } catch(SQLException e){
//                conn.rollback();
//                System.out.println("The account is not found!");
//            }
//        } catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }

    public void withdraw( double amount) throws SQLException{

        if(getBalance() - amount < 0  ){
            System.out.println("Insufficient Balance!");
            return;
        }
        double balance = getBalance() - amount;
        try(Connection conn = SQLite.getConnection();
            Statement stmt = conn.createStatement()){
            String sql = "UPDATE account SET balance =" + balance + " WHERE accountID = "+ getID();
            stmt.execute(sql);
        }
        init();
        System.out.println("Withdraw Succeed!");
    }

    public void init(){
         String balanceSQL= "SELECT balance FROM account WHERE accountID = ?";
         try(Connection conn = SQLite.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(balanceSQL)){
             pstmt.setString(1,this.accountNumber);
             try(ResultSet rs = pstmt.executeQuery()){
                 while(rs.next()){
                     this.balance = rs.getDouble("balance");
                 }
             }
         }catch (SQLException e){
            System.out.println(e.getMessage());
         }
    }

}
