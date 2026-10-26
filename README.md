# Bank Management System

A Java-based bank management system built with Maven, SQLite, and JavaFX/Swing UI prototypes. The project currently focuses on the core banking model and database operations.

## What has been implemented

- Created a SQLite database named `bank_db.sqlite`.
- Added automatic database initialization for:
  - Banks
  - Users
  - Accounts
  - Account transaction logs
- Added foreign-key relationships and account uniqueness constraints.
- Added the `Bank` interface for standard banking operations.
- Implemented the bank with:
  - User and account registration
  - Deposits
  - Transfers between accounts
  - Account closing
  - Account lookup and validation
- Added the `Account` model with:
  - Account number and balance handling
  - Balance refresh from SQLite
  - Withdrawal validation
- Added a login screen prototype with card number and PIN fields, login, sign-up, and clear buttons.
- Added a JavaFX FXML view and controller structure for future UI development.
- Configured Maven to compile the project and create an executable shaded JAR.
- Added a Windows batch script for packaging and running the application.
- Added a GitHub Actions workflow that builds the project and uploads the generated JAR as an artifact.

## Technology stack

- Java
- Maven
- SQLite
- SQLite JDBC
- JavaFX
- Swing
- GitHub Actions

## Project structure

```text
src/main/java/me/chip/
├── App.java                  # JavaFX application entry point
├── SQLite.java               # SQLite connection and schema initialization
├── bank/
│   ├── Account.java          # Account model and balance operations
│   ├── Bank.java             # Banking operation interface
│   └── ChipBank.java         # ChipBank implementation
├── controller/
│   └── LoginController.java  # Login view controller
└── view/
    └── Login.java            # Swing login screen prototype

src/main/resources/me/chip/
├── fxml/login.fxml           # JavaFX login layout
└── images/bank.png           # Login screen image
```

## Database design

The application creates the following tables when it starts database initialization:

- `bank`: Stores bank identifiers and names.
- `user`: Stores registered users.
- `account`: Stores account numbers, balances, bank ownership, and user ownership.
- `account_log`: Stores deposit, withdrawal, and transfer transaction details with timestamps.

The default `Bank` identifier is `4012`. New account numbers use this bank identifier followed by a generated four-digit user number.

## Requirements

- Java 17 or newer
- Maven

## Build and run

Build the executable JAR with:

```bash
mvn clean package
```

Run the packaged application with:

```bash
java -jar target/bank-1.0-SNAPSHOT.jar
```

On Windows, the included script can be used:

```bat
custom_run.bat
```

## Current status

The database and core banking operations are in place. The login screens and JavaFX application entry point are still prototypes: authentication, button event handling, and the complete banking user interface have not yet been connected to the database operations.
