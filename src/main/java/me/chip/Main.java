package me.chip;

//import javafx.application.Application;

import me.chip.bank.ChipBank;
import me.chip.bank.Account;

import java.sql.SQLException;

public class Main{

    public static void main(String[] args) {

        SQLite sql = new SQLite();
        ChipBank bank= new ChipBank();
        Account dummy = new Account("40120107");
        bank.closeAccount("40120955");
//        try{dummy.withdraw(100);}
//        catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//        bank.transfer(dummy.getID(),"40120107","4012",1000);
//        try{}
//      catch(SQLException e){
//          System.out.println(e.getMessage());
//      }

    }
}
