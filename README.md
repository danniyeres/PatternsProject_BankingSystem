# Banking System Project

## Overview
This project is a console-based banking system implementing key functionalities like user registration, account management, transactions, and transaction history tracking. It is designed using multiple design patterns to showcase their adaptability and reusability in solving common software design problems.

## Features
- **User Authentication**: Registration and login.
- **Account Management**: Create accounts and view account details.
- **Transactions**: Perform deposits, withdrawals, and transfers.
- **Transaction History**: View a detailed log of past transactions.
- **Dynamic Behavior**: Add flexible account functionalities like withdrawal fees using the Decorator pattern.

---

## Design Patterns Used

### 1. **Creational Patterns**
- **Builder**:
    - **Classes**: `TransactionBuilder`, `Transaction`
    - **Description**: Simplifies the creation of `Transaction` objects with multiple attributes.
    - **Benefit**: Reduces object creation complexity and improves code readability.

- **Singleton**:
    - **Class**: `Database`
    - **Description**: Ensures a single instance of the database is shared across the application.
    - **Benefit**: Provides centralized, thread-safe data management.

---

### 2. **Structural Patterns**
- **Decorator**:
    - **Classes**: `AccountDecorator`, `CommissionDecorator`
    - **Description**: Dynamically adds behavior (e.g., transaction fees) to the `Account` class without modifying its structure.
    - **Benefit**: Enhances flexibility by allowing runtime behavior modification.

- **Facade**:
    - **Class**: `BankingSystemFacade`
    - **Description**: Provides a simplified interface to interact with the banking system’s complex subsystems.
    - **Benefit**: Reduces the complexity of client interactions with the system.

---

### 3. **Behavioral Patterns**
- **Command**:
    - **Classes**: `DepositCommand`, `WithdrawCommand`, `TransferCommand`
    - **Description**: Encapsulates requests (e.g., transactions) as objects to decouple invokers from executors.
    - **Benefit**: Supports operation queuing, logging, and future extensions.

- **Observer**:
    - **Classes**: `TransactionNotify`, `UserObserver`
    - **Description**: Notifies users about transaction updates.
    - **Benefit**: Automatically informs dependent objects when changes occur in the observed object.

---

## Project Structure
The project is organized into the following packages:
- **`builderTransaction`**: Contains classes for building transaction objects.
- **`command`**: Implements command patterns for handling deposit, withdrawal, and transfer operations.
- **`decoratorAccount`**: Includes decorators for enhancing account functionalities.
- **`facade`**: Implements a Facade to streamline user interaction with subsystems.
- **`observer`**: Manages the notification system for transactions.
- **`singletonDatabase`**: Manages the application’s centralized database as a Singleton.

---

## How to Run
1. Run the `Main` class to start the banking system.
2. Follow the console prompts to interact with the system.

---

## Conclusion
This project demonstrates how design patterns can enhance the structure, readability, and scalability of software. By incorporating these patterns, the application achieves greater flexibility and maintainability.

---
