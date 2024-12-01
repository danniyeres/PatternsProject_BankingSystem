package org.example.pattern.decoratorAccount;



public class CommissionDecorator extends AccountDecorator {
    private final double commissionRate;

    public CommissionDecorator(Account decoratedAccount, double commissionRate) {
        super(decoratedAccount);
        this.commissionRate = commissionRate;
    }


    @Override
    public void withdraw(double amount) {
        double commission = amount * (commissionRate / 100);
        double totalAmount = amount + commission;
        System.out.println("Withdrawal fee charged: " + commission);
        super.withdraw(totalAmount);
    }
}
