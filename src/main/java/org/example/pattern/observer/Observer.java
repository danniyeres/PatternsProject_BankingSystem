package org.example.pattern.observer;

/*
    Observer
        Classes:
            TransactionNotify, UserObserver
        Purpose:
            To notify subscribed users about transaction events (e.g., successful withdrawal, deposit).
        Implementation:
            The TransactionNotify class maintains a list of observers and notifies them by calling their update method.
        Code Example:
            transactionNotify.addObserver(new UserObserver("John"));
            transactionNotify.notifyObservers("Deposit of $500 successful.");
        Why Used:
            Provides a scalable way to handle notifications,
            ensuring users are informed of relevant events.
 */

public interface Observer {
    void update(String message);

}
