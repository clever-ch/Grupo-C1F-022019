package model;

import utilities.Entity;

public class Offer extends Entity {
	private int minAmount;
	private int maxAmount;
	private double offerPrice;
	
	
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
}
