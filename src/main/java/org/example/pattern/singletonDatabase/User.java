package org.example.pattern.singletonDatabase;



import org.example.pattern.decoratorAccount.Account;
import org.example.pattern.builderTransation.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class User {
    private String userId;
    private String name;
    private String password;
    private final List<Account> accounts;
    private final Stack<Transaction> transactions;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.transactions = new Stack<>();
        this.accounts = new ArrayList<>();
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Stack<Transaction> getTransactions() {
        return transactions;
    }
    public void addTransaction(Transaction transaction){
        transactions.push(transaction);
    }
}