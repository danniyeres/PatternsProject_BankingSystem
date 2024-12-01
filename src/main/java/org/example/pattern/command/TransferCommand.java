package org.example.pattern.command;


import org.example.pattern.decoratorAccount.Account;
import org.example.pattern.builderTransation.Transaction;
import org.example.pattern.builderTransation.TransactionBuilder;
import org.example.pattern.singletonDatabase.User;
import org.example.pattern.observer.TransactionNotify;


public class TransferCommand implements Command {
    private final User currentUser;
    private final Account fromAccount;
    private final Account toAccount;
    private final double amount;
    private final TransactionNotify transactionNotify;

    public TransferCommand(User currentUser, Account fromAccount, Account toAccount, double amount, TransactionNotify transactionNotify) {
        this.currentUser = currentUser;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.transactionNotify = transactionNotify;
    }

    @Override
    public void execute() {
        if (fromAccount.getBalance() >= amount) {
            String transactionId = "TRX" + (int) (Math.random() * 10000);
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            Transaction transaction = new TransactionBuilder()
                    .setTransactionId(transactionId)
                    .setFromAccount(fromAccount.getAccountId())
                    .setToAccount(toAccount.getAccountId())
                    .setAmount(amount)
                    .setType("TRANSFER")
                    .build();
            currentUser.addTransaction(transaction);
            transactionNotify.notifyObservers("Fund transfer : " + amount);

        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }
}
