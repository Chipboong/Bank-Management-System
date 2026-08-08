package me.chip.bank;

import me.chip.SQLite;

import java.sql.*;


public class Account
{
//    private final String accountHolderName;
    private String accountNumber;
    private double balance;

    public Account( String accountNumber) {
//        this.accountHolderName = name;
        this.accountNumber = accountNumber;
        updateBalance();
    }

//    public String getAccountHolderName(){return this.accountHolderName;}

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
        updateBalance();
        System.out.println("Withdraw Succeed!");
    }

    public void updateBalance(){
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
