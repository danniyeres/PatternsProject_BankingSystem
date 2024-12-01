package org.example.pattern.builderTransation;

/*
    Builder
        Class:
            TransactionBuilder

        Purpose:
            To build Transaction objects with multiple optional parameters in a readable and flexible way.

        Implementation:
            he TransactionBuilder allows the step-by-step creation
            of a Transaction object by setting properties such as
            transactionId, fromAccount, toAccount, and amount.

        Code Example:
            Transaction transaction = new TransactionBuilder()
                .setTransactionId("TRX12345")
                .setFromAccount("ACC123")
                .setToAccount("ACC456")
                .setAmount(500)
                .setType("TRANSFER")
                .build();

        Why Used:
            Simplifies the construction of complex Transaction objects with optional fields,
            improving code readability and maintainability.
 */

public interface Builder {
    Builder setTransactionId(String transactionId);
    Builder setFromAccount(String fromAccount);
    Builder setToAccount(String toAccount);
    Builder setAmount(double amount);
    Builder setType(String type);
    Transaction build();
}
