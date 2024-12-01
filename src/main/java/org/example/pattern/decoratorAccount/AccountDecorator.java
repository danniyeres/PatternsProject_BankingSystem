package org.example.pattern.decoratorAccount;


/*
    Decorator
        Class:
            CommissionDecorator
        Purpose:
            To dynamically add functionality (e.g., applying commission fees) to the Account class without altering its structure.
        Implementation:
            The CommissionDecorator extends AccountDecorator and overrides the withdraw method to add a commission fee.
        Code Example:
            Account account = new CommissionDecorator(existingAccount, 2.0); // Adds a 2% commission
            account.withdraw(100);
        Why Used:
            Adds flexibility to enhance existing functionality (e.g., applying withdrawal fees)
            without modifying the original Account class.
 */



public abstract class AccountDecorator extends Account {
    protected final Account decoratedAccount;

    public AccountDecorator(Account decoratedAccount) {
        super(decoratedAccount.getAccountId(), decoratedAccount.getBalance());
        this.decoratedAccount = decoratedAccount;
    }

    @Override
    public void deposit(double amount) {
        decoratedAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        decoratedAccount.withdraw(amount);
    }

    @Override
    public void displayAccountInfo() {
        decoratedAccount.displayAccountInfo();
    }
}
