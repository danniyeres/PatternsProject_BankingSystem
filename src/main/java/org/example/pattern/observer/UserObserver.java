package org.example.pattern.observer;

public class UserObserver implements Observer {
    private final String userName;

    public UserObserver(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to the user " + userName + ": " + message);
    }
}
