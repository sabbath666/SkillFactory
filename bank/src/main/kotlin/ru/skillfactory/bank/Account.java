package ru.skillfactory.bank;

public class Account {
    private int balance;

    public void takeMoney(int sum) {
        balance = balance - sum;
    }

    public void addMoney(int sum) {
        balance = balance + sum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(int balance) {
        this.balance = balance;
    }
}
