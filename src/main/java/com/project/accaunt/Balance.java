package com.project.accaunt;

public class Balance {
    private double balance;

    private int percent;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double takeMoneyToTrade() {
        return balance/percent;
    }
}
