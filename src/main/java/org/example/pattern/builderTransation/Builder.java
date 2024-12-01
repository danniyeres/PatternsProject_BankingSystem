package org.example.pattern.builderTransation;


public interface Builder {
    Builder setTransactionId(String transactionId);
    Builder setFromAccount(String fromAccount);
    Builder setToAccount(String toAccount);
    Builder setAmount(double amount);
    Builder setType(String type);
    Transaction build();
}
