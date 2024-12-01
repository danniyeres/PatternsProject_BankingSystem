package org.example.pattern.facade;


import org.example.pattern.decoratorAccount.Account;
import org.example.pattern.decoratorAccount.CommissionDecorator;
import org.example.pattern.builderTransation.Transaction;
import org.example.pattern.singletonDatabase.User;
import org.example.pattern.observer.UserObserver;
import org.example.pattern.singletonDatabase.Database;
import org.example.pattern.command.Command;
import org.example.pattern.command.DepositCommand;
import org.example.pattern.command.WithdrawCommand;
import org.example.pattern.command.TransferCommand;
import org.example.pattern.observer.TransactionNotify;
import java.util.Stack;

/*
    Facade
        Class:
            BankingSystemFacade
        Purpose:
            To provide a unified interface for interacting with subsystems like Database, Account, and Transaction.
        Implementation:
            The BankingSystemFacade encapsulates the complexity of individual subsystems, offering simplified methods such as deposit, withdraw, and transfer.
        Code Example:
            facade.deposit(currentUser, "ACC001", 500);
            facade.viewAccountDetails(currentUser);
        Why Used:
            Simplifies the user interface for interacting with the banking system,
            reducing the coupling between modules.
 */

public class BankingSystemFacade {
    private final Database database = Database.getInstance();
    private final TransactionNotify transactionNotify = new TransactionNotify();
    public User registerUser(String name, String password) {
        String userId = "ID" + (int) (Math.random() * 1000);
        User user = new User(name, password);
        database.addUser(userId, user);
        transactionNotify.addObserver(new UserObserver(name));
        System.out.println("User registered: " + name +", "+userId);
        return user;
    }

    public User loginUser(String name, String password) {
        if (database.checkUser(name, password)) {
            User user = database.getUserByUserName(name);
            System.out.println("User sign in: " + name);
            return user;
        } else {
            System.out.println("Login error: Invalid username or password.");
            return null;
        }
    }

    public void createAccount(User user, double initialBalance) {
        String accountId = "ACC" + (int) (Math.random() * 10000);
        Account account = new Account(accountId, initialBalance);
        database.addAccountToUser(user.getUserId(), account);
        System.out.println("Account created: ID " + accountId);
    }

    public void deposit(User user, String accountId, double amount) {
        Account account = database.findAccountById(user.getUserId(), accountId);
        if (account != null) {
            Command deposit = new DepositCommand(user,account, amount, transactionNotify);
            deposit.execute();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(User user, String accountId, double amount) {
        Account account = database.findAccountById(user.getUserId(), accountId);

        if (account != null) {
            account = new CommissionDecorator(account, 2.0);
            Command withdraw = new WithdrawCommand(user,account, amount, transactionNotify);
            withdraw.execute();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(User user, String fromAccountId, String toAccountId, double amount) {
        Account fromAccount = database.findAccountById(user.getUserId(), fromAccountId);
        Account toAccount = database.findAccountById(user.getUserId(), toAccountId);
        if (fromAccount != null && toAccount != null) {
            Command transfer = new TransferCommand(user, fromAccount, toAccount, amount, transactionNotify);
            transfer.execute();
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void viewAccountDetails(User user) {
        System.out.println("\n=== Account details ===");

        if (user.getAccounts().isEmpty()) {
            System.out.println("You don't have any accounts..");
            return;
        }
        System.out.println("Your accounts:");
        for (Account account : user.getAccounts()) {
            account.displayAccountInfo();

        }
    }
    public void viewTransactionHistory(User user) {
        Stack<Transaction> transactions = user.getTransactions();
        if (transactions.isEmpty()) {
            System.out.println("No transaction history.");
            return;
        }
        System.out.println("Transaction history:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getTransactionDetails());
        }
    }
}
