package model;

import exceptions.CantTakeCreditException;
import exceptions.OptionNotAvailableException;
import utilities.Entity;

public abstract class Wallet extends Entity {
    private double amount = 0;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract void loadCredit(double n) throws OptionNotAvailableException;

    public abstract void takeCredit(double n) throws CantTakeCreditException, OptionNotAvailableException;

    public abstract double checkCredit();


}