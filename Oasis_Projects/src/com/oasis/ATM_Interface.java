package com.oasis;

import java.util.Scanner;

class ATM {
    private int balance, index = 0;
    private final int [] transaction_history = new int[20];

    ATM(int balance) {
        this.balance = balance;
    }

    public void addToTransactionHistory(int amount) {
        transaction_history[index] = amount;
        index++;
        if (index == 20) {
            index = 0;
        }
    }

    public void showTransactionHistory() {
        if (transaction_history[0] != 0) {
            System.out.println("Transaction history:");
            for (int n : transaction_history) {
                if (n == 0) {
                    break;
                }
                System.out.println(n);
            }
        }
        else {
            System.out.println("No transactions!");
        }
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            addToTransactionHistory((-1 * amount));
            System.out.println("Withdrawn amount " + amount);
        }
        else {
            System.out.println("Cannot Withdraw!");
        }
    }

    public void deposit(int amount) {
        balance += amount;
        addToTransactionHistory(amount);
        System.out.println("Deposited amount " + amount);
    }

    public void transfer(int amount) {
        if (balance >= amount) {
            balance -= amount;
            addToTransactionHistory((-1 * amount));
            System.out.println("Transferred amount " + amount);
        }
        else {
            System.out.println("Cannot Transfer!");
        }
    }

}

public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Initial Balance:");
        ATM atm = new ATM(sc.nextInt());
        System.out.println("-----Welcome to ATM-----");
        int choice = 0;
        do {
            System.out.println("1. Transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> atm.showTransactionHistory();
                case 2 -> {
                    System.out.println("Enter amount to be withdrawn:");
                    atm.withdraw(sc.nextInt());
                }
                case 3 -> {
                    System.out.println("Enter amount to be deposited:");
                    atm.deposit(sc.nextInt());
                }
                case 4 -> {
                    System.out.println("Enter amount to be transferred:");
                    atm.transfer(sc.nextInt());
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid! Enter again");
            }
            System.out.println("---------------------------------");
        } while (choice != 5);
    }
}
