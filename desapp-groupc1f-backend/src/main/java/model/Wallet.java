package model;

import utilities.Entity;

public abstract class Wallet extends Entity {
    public double amount = 0;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract void loadCredit(double n);

    public abstract void takeCredit(double n);

    public abstract double checkCredit();


}
