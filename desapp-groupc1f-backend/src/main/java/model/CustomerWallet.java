package model;

import exceptions.OptionNotAvailableException;

public class CustomerWallet extends Wallet {

    @Override
    public void loadCredit(double n) {
        this.amount = this.amount + n;
    }

    @Override
    public void takeCredit(double n) throws OptionNotAvailableException{
        throw new OptionNotAvailableException("Opcion no disponible para este perfil");
    }

    @Override
    public double checkCredit() {
        return this.amount;
    }
}
