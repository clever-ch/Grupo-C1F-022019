package root.model;

import root.exceptions.OptionNotAvailableException;

@javax.persistence.Entity
public class CustomerWallet extends Wallet {
	
    @Override
    public void loadCredit(double n) {
    	Double actualAmount = this.getAmount();
        this.setAmount(actualAmount + n);
    }

    @Override
    public void takeCredit(double n) throws OptionNotAvailableException{
        throw new OptionNotAvailableException("Opcion no disponible para este perfil");
    }

    @Override
    public double checkCredit() {
        return this.getAmount();
    }
}
