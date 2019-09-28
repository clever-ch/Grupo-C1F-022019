package model;

import exceptions.CantTakeCreditException;
import exceptions.OptionNotAvailableException;

public class ProviderWallet extends Wallet {

    @Override
    public void loadCredit(double n) throws OptionNotAvailableException{
        throw new OptionNotAvailableException("Opcion no disponible para este perfil");
    }

    @Override
    public void takeCredit(double n) throws CantTakeCreditException {
    		
    	Double actualAmount = this.getAmount();
        
    	if ((actualAmount - n) >= 0){
                this.setAmount(actualAmount - n);
            } else {
                throw new CantTakeCreditException("El monto que desea quitar excede lo disponible en su billetera");
            }

    }

    @Override
    public double checkCredit() {
        return this.getAmount();
    }
}
