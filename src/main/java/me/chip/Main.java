package me.chip;

//import javafx.application.Application;

import me.chip.bank.ChipBank;
import me.chip.bank.Account;

import java.sql.SQLException;

public class Main{

    public static void main(String[] args) {

        SQLite sql = new SQLite();
        ChipBank bank= new ChipBank();
        Account dummy = new Account("Dummy","40120056");
        bank.deposit(dummy.getID(),1000);
//        try{}
//      catch(SQLException e){
//          System.out.println(e.getMessage());
//      }

    }
}
