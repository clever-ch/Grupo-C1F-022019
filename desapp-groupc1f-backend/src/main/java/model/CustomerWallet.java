package model;

public class CustomerWallet extends Wallet {

    public CustomerWallet(){
        super();
    }

    @Override
    public void loadCredit(double n) {
        this.amount = this.amount + n;
    }

    @Override
    public void takeCredit(double n) {

    }

    @Override
    public double checkCredit() {
        return this.amount;
    }
}
