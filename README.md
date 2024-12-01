
# Banking System Project

## Overview
This project is a console-based banking system that demonstrates the use of fundamental design patterns in real-world applications. Users can perform the following actions:  
1. Register and log in to the system.  
2. Create bank accounts.  
3. Conduct transactions such as deposit, withdrawal, and transfer.  
4. View account details and transaction history.  

The system is designed to be modular, flexible, and reusable by leveraging well-known design patterns.


---

## Design Patterns Used

### **1. Creational Patterns**

#### **Builder**
- **Class**: `TransactionBuilder`  
- **Purpose**: To build `Transaction` objects with multiple optional parameters in a readable and flexible way.  
- **Implementation**:  
  - The `TransactionBuilder` allows the step-by-step creation of a `Transaction` object by setting properties such as `transactionId`, `fromAccount`, `toAccount`, and `amount`.  
- **Code Example**:  
  ```java
  Transaction transaction = new TransactionBuilder()
      .setTransactionId("TRX12345")
      .setFromAccount("ACC123")
      .setToAccount("ACC456")
      .setAmount(500)
      .setType("TRANSFER")
      .build();
  ```
- **Why Used**:  
  Simplifies the construction of complex `Transaction` objects with optional fields, improving code readability and maintainability.  

---

#### **Singleton**
- **Class**: `Database`  
- **Purpose**: To ensure a single shared instance of the database is accessible throughout the application.  
- **Implementation**:  
  - The `Database` class uses a private constructor and a static method `getInstance()` to return the single instance.  
- **Code Example**:  
  ```java
  Database database = Database.getInstance();
  database.addUser("ID001", user);
  ```
- **Why Used**:  
  Prevents the creation of multiple database instances, centralizing state management for user accounts and transactions.  

---

### **2. Structural Patterns**

#### **Decorator**
- **Class**: `CommissionDecorator`  
- **Purpose**: To dynamically add functionality (e.g., applying commission fees) to the `Account` class without altering its structure.  
- **Implementation**:  
  - The `CommissionDecorator` extends `AccountDecorator` and overrides the `withdraw` method to add a commission fee.  
- **Code Example**:  
  ```java
  Account account = new CommissionDecorator(existingAccount, 2.0); // Adds a 2% commission
  account.withdraw(100);
  ```
- **Why Used**:  
  Adds flexibility to enhance existing functionality (e.g., applying withdrawal fees) without modifying the original `Account` class.  

---

#### **Facade**
- **Class**: `BankingSystemFacade`  
- **Purpose**: To provide a unified interface for interacting with subsystems like `Database`, `Account`, and `Transaction`.  
- **Implementation**:  
  - The `BankingSystemFacade` encapsulates the complexity of individual subsystems, offering simplified methods such as `deposit`, `withdraw`, and `transfer`.  
- **Code Example**:  
  ```java
  facade.deposit(currentUser, "ACC001", 500);
  facade.viewAccountDetails(currentUser);
  ```
- **Why Used**:  
  Simplifies the user interface for interacting with the banking system, reducing the coupling between modules.  

---

### **3. Behavioral Patterns**

#### **Command**
- **Classes**: `DepositCommand`, `WithdrawCommand`, `TransferCommand`  
- **Purpose**: To encapsulate requests for different types of transactions into separate classes, decoupling the request sender and receiver.  
- **Implementation**:  
  - Each command class implements the `Command` interface and defines the `execute` method for specific transaction logic.  
- **Code Example**:  
  ```java
  Command deposit = new DepositCommand(user, account, 500, transactionNotify);
  deposit.execute();
  ```
- **Why Used**:  
  Makes it easier to add or modify transaction types without changing the client code.  

---

#### **Observer**
- **Classes**: `TransactionNotify`, `UserObserver`  
- **Purpose**: To notify subscribed users about transaction events (e.g., successful withdrawal, deposit).  
- **Implementation**:  
  - The `TransactionNotify` class maintains a list of observers and notifies them by calling their `update` method.  
- **Code Example**:  
  ```java
  transactionNotify.addObserver(new UserObserver("John"));
  transactionNotify.notifyObservers("Deposit of $500 successful.");
  ```
- **Why Used**:  
  Provides a scalable way to handle notifications, ensuring users are informed of relevant events.

---

## Key Components

### **1. User Management**
- Users can register and log in using the `BankingSystemFacade`.  
- User accounts and credentials are stored in the `Database` singleton.  

### **2. Account Management**
- Users can create accounts with an initial balance.  
- Accounts support operations like deposit, withdrawal, and displaying account details.  

### **3. Transactions**
- Transactions are recorded using the `Transaction` class and managed via the `TransactionBuilder`.  
- Commands handle specific transaction types, ensuring modularity.

---

## Conclusion
This project implements six distinct design patterns across three categories:  
1. **Creational**: `Builder`, `Singleton`.  
2. **Structural**: `Decorator`, `Facade`.  
3. **Behavioral**: `Command`, `Observer`.  

By leveraging these patterns, the system achieves flexibility, modularity, and maintainability, making it easy to extend and adapt to new requirements.
