package org.example;

import org.example.pattern.facade.BankingSystemFacade;
import org.example.pattern.singletonDatabase.User;

import java.util.Scanner;

public class Main {
    private static final BankingSystemFacade facade = new BankingSystemFacade();
    private static User currentUser = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n=== Banking System ===");

        while (true) {
            try {
                System.out.println("\n1. Authorization (Sign in or register)");
                System.out.println("2. Create a bank account");
                System.out.println("3. Perform a transaction");
                System.out.println("4. View account details");
                System.out.println("5. Transaction history");
                System.out.println("6. Exit");
                System.out.print("Choose an action: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        authenticateUser();
                        break;
                    case 2:
                        if (currentUser != null) {
                            createAccount();
                        } else {
                            System.out.println("Please Sign in first!");
                        }
                        break;
                    case 3:
                        if (currentUser != null) {
                            executeTransaction();
                        } else {
                            System.out.println("Please Sign in first!");
                        }
                        break;
                    case 4:
                        if (currentUser != null) {
                            viewAccountDetails();
                        } else {
                            System.out.println("Please Sign in first!");
                        }
                        break;
                    case 5:
                        if (currentUser != null) {
                            facade.viewTransactionHistory(currentUser);
                        } else {
                            System.out.println("Please Sign in first!");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting the system. Thank you for using it!");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }catch (Exception e) {
                System.out.println("Error.");
                scanner.nextLine();
            }
        }
    }

    private static void authenticateUser() {
        System.out.println("\n1. Sign in");
        System.out.println("2. Register");
        System.out.print("Choose an action: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        try {

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    currentUser = facade.loginUser(name, password);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    currentUser = facade.registerUser(newName, newPassword);
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }catch (Exception e){
            System.out.println("Error.");
        }
    }

    private static void createAccount() {

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();
        try {
        facade.createAccount(currentUser, initialBalance);
        }catch (Exception e){
            System.out.println("Error.");
        }
    }

    private static void executeTransaction() {
        System.out.println("\n1. Replenish");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.print("Choose a transaction type: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter account ID to replenish into: ");
                    String depositAccountId = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    facade.deposit(currentUser, depositAccountId, depositAmount);
                    break;
                case 2:
                    System.out.print("Enter account ID to withdraw from: ");
                    String withdrawAccountId = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    facade.withdraw(currentUser, withdrawAccountId, withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter source account ID: ");
                    String fromAccountId = scanner.nextLine();
                    System.out.print("Enter target account ID: ");
                    String toAccountId = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();
                    facade.transfer(currentUser, fromAccountId, toAccountId, transferAmount);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }catch (Exception e){
            System.out.println("Error.");
        }
    }

    private static void viewAccountDetails() {
        System.out.println("\nYour accounts:");
        facade.viewAccountDetails(currentUser);
    }
}
