package org.example.pattern.decoratorAccount;

public class Account implements AccountInterface {
    private final String accountId;
    private double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }


    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Replenishment: " + amount + ". Balance: " + balance);
    }
    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Not enough funds for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdraw: " + amount + ". Balance: " + balance);
        }
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("\nID: " + accountId);
        System.out.println("Balance: " + balance);
    }
}
