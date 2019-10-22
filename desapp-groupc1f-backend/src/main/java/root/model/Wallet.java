package root.model;

import javax.persistence.MappedSuperclass;
import root.exceptions.CantTakeCreditException;
import root.exceptions.OptionNotAvailableException;
import root.utilities.Entity;

@MappedSuperclass
public abstract class Wallet extends Entity {
    private double amount = 0;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract void loadCredit(double n) throws OptionNotAvailableException;

    public abstract void takeCredit(double n) throws CantTakeCreditException, OptionNotAvailableException;

    public abstract double checkCredit();


}