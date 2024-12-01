package org.example.pattern.command;

/*
    Command
        Classes:
            DepositCommand, WithdrawCommand, TransferCommand
        Purpose:
            To encapsulate requests for different types of transactions into separate classes, decoupling the request sender and receiver.
        Implementation:
            Each command class implements the Command interface and defines the execute method for specific transaction logic.
        Code Example:
            Command deposit = new DepositCommand(user, account, 500, transactionNotify);
            deposit.execute();
        Why Used:
            Makes it easier to add or modify transaction types without changing the client code.
 */

public interface Command {
    void execute();

}
