package me.chip.bank;

import me.chip.bank.Bank.ChipBank;
import me.chip.bank.Bank.NeathBank;

public class Main {

    public static void main(String[] args) {
        SQLite sql = new SQLite("jdbc:sqlite:bank_db");
        System.out.println(new java.io.File("bank_db").getAbsolutePath());
        ChipBank chip = new ChipBank("ChipBank", "1");
        NeathBank neath = new NeathBank("NeathBank", "2");
    }
}
