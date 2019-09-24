package model.factories;

import constants.ForeignExchange;
import model.Offer;

public class OfferFactory {
	
	public static Offer anyOffer() {
		return new Offer();
	}
	
	public static Offer createCompleteOffer(int minM, int maxM, double price, ForeignExchange exchange) {
		return new Offer(minM, maxM, price, exchange);
	}
}
