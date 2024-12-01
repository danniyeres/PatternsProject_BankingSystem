package org.example.pattern.command;



import org.example.pattern.decoratorAccount.Account;
import org.example.pattern.builderTransation.Transaction;
import org.example.pattern.builderTransation.TransactionBuilder;
import org.example.pattern.singletonDatabase.User;
import org.example.pattern.observer.TransactionNotify;



public class WithdrawCommand implements Command {
    private final User currentUser;
    private final Account account;
    private final double amount;
    private final TransactionNotify transactionNotify;

    public WithdrawCommand(User currentUser, Account account, double amount, TransactionNotify transactionNotify) {
        this.currentUser = currentUser;
        this.account = account;
        this.amount = amount;
        this.transactionNotify = transactionNotify;
    }

    @Override
    public void execute() {
        if (account.getBalance() >= amount) {
            String transactionId = "TRX" + (int) (Math.random() * 10000);
            account.withdraw(amount);
            Transaction transaction = new TransactionBuilder()
                    .setTransactionId(transactionId)
                    .setFromAccount(account.getAccountId())
                    .setAmount(amount)
                    .setType("WITHDRAW")
                    .build();
            transactionNotify.notifyObservers("Withdraw: "+amount+"\nBalance: "+account.getBalance());
            currentUser.addTransaction(transaction);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}
