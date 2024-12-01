package org.example.pattern.builderTransation;

import java.time.LocalDateTime;

public class TransactionBuilder implements Builder {
    String transactionId;
    String fromAccount;
    String toAccount;
    double amount;
    LocalDateTime timestamp;
    String type;

    public TransactionBuilder() {
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public Builder setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    @Override
    public Builder setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
        return this;
    }

    @Override
    public Builder setToAccount(String toAccount) {
        this.toAccount = toAccount;
        return this;
    }

    @Override
    public Builder setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public Builder setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public Transaction build() {
        return new Transaction(this); 
    }
}
