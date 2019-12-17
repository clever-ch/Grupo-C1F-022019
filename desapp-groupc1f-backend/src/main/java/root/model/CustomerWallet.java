package root.model;

import javax.persistence.OneToOne;

import root.exceptions.CantTakeCreditException;

@javax.persistence.Entity
public class CustomerWallet extends Wallet {
	
	@OneToOne
	private Customer customer;
	
    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
    public void loadCredit(double n) {
    	Double actualAmount = this.getAmount();
        this.setAmount(actualAmount + n);
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
