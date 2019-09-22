package model;

public class ProviderWallet extends Wallet {

    @Override
    public void loadCredit(double n) {
        System. out. println("you cannot use this option");
    }

    @Override
    public void takeCredit(double n) throws ArithmeticException {

        try{
            if ((this.amount - n) >= 0){
                this.amount = this.amount -n;
            }
        } catch (ArithmeticException error){
            System.out.println("The amount you want to withdraw is greater than what is available in your wallet");
        }

    }

    @Override
    public double checkCredit() {
        return this.amount;
    }
}
