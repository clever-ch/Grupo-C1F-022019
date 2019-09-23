package model;

public class CustomerWallet extends Wallet {

    @Override
    public void loadCredit(double n) {
        this.amount = this.amount + n;
    }

    @Override
    public void takeCredit(double n) {
        System. out. println("you cannot use this option");
    }

    @Override
    public double checkCredit() {
        return this.amount;
    }
}
