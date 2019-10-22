package root.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import root.constants.ForeignExchange;
import root.utilities.Entity;

@javax.persistence.Entity
public class Offer extends Entity {
	private int minAmount;
	private int maxAmount;
	private double offerPrice;
	
	@Enumerated(EnumType.STRING)
	private ForeignExchange exchange;
	
	
	public Offer() { }
	
	public Offer(int minM, int maxM, double price, ForeignExchange exchange) {
		this.minAmount = minM;
		this.maxAmount = maxM;
		this.offerPrice = price;
		this.exchange = exchange;
	}
	
	public boolean offerIsExcluded(Offer otherOf) {
		return this.minAmount > otherOf.maxAmount 
				| this.maxAmount < otherOf.minAmount;
	}

	public int getMinAmount() {
		return minAmount;
	}
	
	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public int getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	public double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public ForeignExchange getExchange() {
		return exchange;
	}

	public void setExchange(ForeignExchange exchange) {
		this.exchange = exchange;
	}
	
	public boolean offerHasSameId(Offer offer) {
		return this.getId() == offer.getId();
	}
	
	public boolean offerHasSamePrice(Offer offer) {
		return this.offerPrice == offer.getOfferPrice();
	}
}
