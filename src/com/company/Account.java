package com.company;

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() { return balance; }

    public boolean deposit(double amt){
        if (amt <= 0){ return false; }
        balance = balance+amt;
        return true;
    }

    public boolean withdraw(double amt){
        if (amt <= 0 || amt > balance){ return false; }
        balance = balance-amt;
        return true;
    }
}
