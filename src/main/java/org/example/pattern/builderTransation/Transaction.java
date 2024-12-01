package org.example.pattern.builderTransation;

import java.time.LocalDateTime;
import java.util.Stack;

public class Transaction {
    private final String transactionId;
    private final String fromAccount;
    private final String toAccount;
    private final double amount;
    private final LocalDateTime timestamp;
    private final String type;

    public Transaction(TransactionBuilder builder) {
        this.transactionId = builder.transactionId;
        this.fromAccount = builder.fromAccount;
        this.toAccount = builder.toAccount;
        this.amount = builder.amount;
        this.timestamp = builder.timestamp;
        this.type = builder.type;
    }

    public Stack<String> getTransactionDetails() {
        Stack<String> transactionStack = new Stack<>();
        transactionStack.push("Transaction ID: " + getTransactionId());
        transactionStack.push("Type: " + getType());
        if (getFromAccount() != null) {
            transactionStack.push("From account: " + getFromAccount());
        }
        if (getToAccount() != null) {
            transactionStack.push("To account: " + getToAccount());
        }
        transactionStack.push("Amount: " + getAmount());
        transactionStack.push("Date: " + getTimestamp());
        transactionStack.push("------------");
        return transactionStack;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }
}

