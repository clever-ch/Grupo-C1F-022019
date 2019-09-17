package model;

public class ProviderWallet extends Wallet {

    @Override
    public void loadCredit(double n) {

    }

    @Override
    public void takeCredit(double n) {
        this.amount = this.amount - n;
    }

    @Override
    public double checkCredit() {
        return this.amount;
    }
}
