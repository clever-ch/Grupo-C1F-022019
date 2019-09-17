package model;

public abstract class Wallet {
    public double amount;

    public Wallet() {
        this.amount = 0;
    }

    public abstract void loadCredit(double n);

    public abstract void takeCredit(double n);

    public abstract double checkCredit();

}
