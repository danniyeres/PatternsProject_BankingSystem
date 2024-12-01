package org.example.pattern.command;


import org.example.pattern.decoratorAccount.Account;
import org.example.pattern.builderTransation.Transaction;
import org.example.pattern.builderTransation.TransactionBuilder;
import org.example.pattern.singletonDatabase.User;
import org.example.pattern.observer.TransactionNotify;

public class DepositCommand implements Command {
    private final User currentUser;
    private final Account account;
    private final double amount;
    private final TransactionNotify transactionNotify;


    public DepositCommand(User currentUser, Account account, double amount, TransactionNotify transactionNotify) {
        this.currentUser = currentUser;
        this.account = account;
        this.amount = amount;
        this.transactionNotify=transactionNotify;
    }

    @Override
    public void execute() {
        account.deposit(amount);
        String transactionId = "TRX" + (int) (Math.random() * 10000);
        Transaction transaction = new TransactionBuilder()
                .setTransactionId(transactionId)
                .setToAccount(account.getAccountId())
                .setAmount(amount)
                .setType("DEPOSIT")
                .build();
        currentUser.addTransaction(transaction);
        transactionNotify.notifyObservers("Replenishment : " + amount);
    }
}
