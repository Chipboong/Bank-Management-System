package me.chip.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite{

    String url;

    SQLite(String URL) {
        this.url = URL;
        initDB();
    }

    public void execute(String sql) {
        try (
            Connection conn = DriverManager.getConnection(this.url);
            Statement stmt = conn.createStatement()
        ) {
            if (conn != null) {
                System.out.println("Connected to SQLite");
            }
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
   
    }

    public void initDB() {
        String sql =
            "PRAGMA foreign_keys = ON; " +
            "CREATE TABLE IF NOT EXISTS bank (" +
            "    bankID INTEGER PRIMARY KEY, " +
            "    name TEXT NOT NULL " +
            "); " +
            "CREATE TABLE IF NOT EXISTS user (" +
            "    userID INTEGER PRIMARY KEY, " +
            "    userName TEXT NOT NULL " +
            "); " +
            "CREATE TABLE IF NOT EXISTS account (" +
            "    accountID TEXT PRIMARY KEY, " +
            "    balance REAL NOT NULL DEFAULT 0.0, " +
            "    bankID INTEGER NOT NULL, " +
            "    userID INTEGER NOT NULL, " +
            "    FOREIGN KEY (bankID) REFERENCES bank(bankID), " +
            "    FOREIGN KEY (userID) REFERENCES user(userID), " +
            "    UNIQUE (bankID, userID) " +
            "); " +
            "CREATE TABLE IF NOT EXISTS account_log (" +
            "    logID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "    transactionType TEXT NOT NULL CHECK(transactionType IN ('DEPOSIT', 'WITHDRAW', 'TRANSFER')), " +
            "    amount REAL NOT NULL CHECK(amount > 0), " +
            "    fromBankID INTEGER, " +
            "    fromUserID INTEGER, " +
            "    fromAccountID TEXT, " +
            "    toBankID INTEGER, " +
            "    toUserID INTEGER, " +
            "    toAccountID TEXT, " +
            "    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP, " +
            "    FOREIGN KEY (fromBankID) REFERENCES bank(bankID), " +
            "    FOREIGN KEY (fromUserID) REFERENCES user(userID), " +
            "    FOREIGN KEY (fromAccountID) REFERENCES account(accountID), " +
            "    FOREIGN KEY (toBankID) REFERENCES bank(bankID), " +
            "    FOREIGN KEY (toUserID) REFERENCES user(userID), " +
            "    FOREIGN KEY (toAccountID) REFERENCES account(accountID) " +
            ");";
            execute(sql);
            System.out.println("testing");
    }
}
