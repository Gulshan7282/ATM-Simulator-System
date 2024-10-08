
# ATM Simulator System – Java Project Overview
The ATM Simulator System is a real-world project developed in Java to simulate the working of an Automated Teller Machine. This type of project is commonly built to help developers understand core Java concepts, Object-Oriented Programming (OOP), database integration, user input handling, and other essential functionalities that are needed to build real-world applications. It mimics basic ATM operations such as balance inquiry, cash withdrawal, deposit, and pin management.

## Features and Functionalities
### 1. User Authentication: 
* Users are required to input their `Card Number` and `PIN` to log into the system. This is the first interaction, ensuring that the user is verified before accessing any bank-related actions.

### 2. Balance Inquiry:
* Once authenticated, users can check their current account balance. The system fetches data from a database or a data structure that simulates user accounts.

### 3. Cash Withdrawal:
* Users can withdraw a specified amount from their balance. The system checks if the user has enough funds before performing the transaction. The balance is updated accordingly after successful withdrawal.

### 4. Deposit Money:
* Users can deposit money into their account. The system updates the account balance by adding the deposited amount.

### 5. Change PIN:
* Users can change their current PIN. The system requires users to input their old PIN and a new PIN for security purposes, and the database is updated with the new credentials.

### 6. Transaction History:
* The system tracks and displays a history of recent transactions such as withdrawals, deposits, and balance inquiries for user review.

### 7. Exit/Logout:
* Users can securely log out of the system, ensuring that no unauthorized access is possible after the session ends.

## Components and Structure
### 1. Classes and Objects:
* The project is designed using object-oriented principles, where classes like `Account`, `Transaction`, and `ATM` are defined.
* Each class holds specific functionality; for example, the `Account` class may store user details, balance, and pin, while the `Transaction` class may handle withdrawal, deposit, and history.

### 2. Database (or Data Storage):
* In a more advanced version, the project might integrate a `MySQL` or `SQLite` database to store user information, such as account details, transaction records, and PINs.
* For a simpler version, data can be stored using file handling or in-memory data structures like `HashMap`.

### 3. User Interface:
* The system can either use a console-based UI for simplicity or a `Graphical User Interface (GUI)` using Java's Swing or JavaFX libraries. This would provide buttons for interactions, text boxes for inputs, and display areas for output.

### 4. Error Handling:
* The system includes exception handling for invalid inputs (such as incorrect PIN or insufficient balance) and ensures the program doesn't crash during an invalid operation.

## Learning Outcomes
### Developing an ATM Simulator System in Java helps students and developers understand:

### 1. Object-Oriented Programming (OOP):
* How to structure code using classes and objects.
* Implementing inheritance, encapsulation, and polymorphism (for example, multiple types of accounts).

### 2. Database Connectivity:
* Connecting Java with a database using JDBC (Java Database Connectivity).
* Performing SQL operations such as `SELECT`, `UPDATE`, `INSERT`, and `DELETE` for storing and retrieving user and account data.

### 3. Input Validation and Security:
* Managing user inputs and validating sensitive information like the PIN.
* Basic encryption techniques for PIN management can also be added.

### 4. File Handling:
* Managing and storing data through file input/output streams, if databases are not used.

### 5. GUI Development (optional):
* It is understanding how to create user-friendly interfaces using Java Swing or JavaFX.

### 6. Error Handling:
* Learning to implement robust error handling and corner-case management, such as preventing over-withdrawal, ensuring valid input formats, etc.

### 7. Project Structuring:
* Dividing the project into different modules, such as the login module, transaction module, etc., helps in understanding how real-world applications are structured and maintained.

## Example Functional Flow

### 1. Login:
* User enters card number and PIN.
* The system verifies the input from a database.

### 2. Main Menu:
* Options include `Balance Inquiry`, `Cash Withdrawal`, `Deposit`, `Change PIN`, and `Exit`.

### 3. Perform Transaction:
* Based on the user selection, corresponding actions take place.
* For withdrawals, the balance is updated after verifying sufficient funds.
* For deposits, the system adds the amount and updates the database.

### 4. Transaction History:
* Users can view recent transactions.

### 5. Exit:
* Users Exit, ending the session.
