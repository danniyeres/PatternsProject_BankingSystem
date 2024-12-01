package org.example.pattern.singletonDatabase;


import org.example.pattern.decoratorAccount.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Database instance;
    private final Map<String, User> users = new HashMap<>();



    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }




    public void addUser(String userId, User user) {
        user.setUserId(userId);
        users.put(userId, user);
    }
    public User getUserById(String userId) {
        return users.get(userId);
    }
    public User getUserByUserName(String userName) {
        for (User user : users.values()) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkUser(String userName, String password) {
        User user = getUserByUserName(userName);
        if (user != null && user.getPassword().equals(password)){
            return true;
        }else {
            return false;
        }
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public void addAccountToUser(String userId, Account account) {
        User user = getUserById(userId);
        if (user != null) {
            user.addAccount(account);
            System.out.println("Account added to user: " + user.getName() + ", "+user.getUserId());
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    public List<Account> getAccountsByUserId(String userId) {
        User user = getUserById(userId);
        return user != null ? user.getAccounts() : new ArrayList<>();
    }

    public Account findAccountById(String userId, String accountId) {
        User user = getUserById(userId);
        if (user != null) {
            for (Account account : user.getAccounts()) {
                if (account.getAccountId().equals(accountId)) {
                    return account;
                }
            }
        }
        return null;
    }
}