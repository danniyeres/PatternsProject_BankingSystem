package org.example.pattern.decoratorAccount;
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
