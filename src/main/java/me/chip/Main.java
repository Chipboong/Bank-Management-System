package me.chip;

//import javafx.application.Application;

import me.chip.bank.ChipBank;

public class Main{

    public static void main(String[] args) {

        SQLite sql = new SQLite();
        ChipBank bank= new ChipBank();
        bank.register("Dummy");
    }
}
