package root.model;

import javax.persistence.OneToOne;

import root.exceptions.CantTakeCreditException;
import root.exceptions.OptionNotAvailableException;

@javax.persistence.Entity
public class ProviderWallet extends Wallet {
	
	@OneToOne
	private Provider provider;
	
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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
}
