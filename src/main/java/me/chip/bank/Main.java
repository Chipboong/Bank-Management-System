package me.chip.bank;

public class Main {

    public static void main(String[] args) {
        SQLite sql = new SQLite("jdbc:sqlite:bank_db");
        System.out.println(new java.io.File("bank_db").getAbsolutePath());
        Login login;
        login = new Login();
    }
}
