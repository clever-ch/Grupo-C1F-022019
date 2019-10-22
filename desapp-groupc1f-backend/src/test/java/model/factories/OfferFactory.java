package model.factories;

import root.constants.ForeignExchange;
import root.model.Offer;

public class OfferFactory {
	
	public static Offer anyOffer() {
		return new Offer();
	}
	
	public static Offer createOfferWithId(long id) {
		Offer anyOffer = anyOffer();
		anyOffer.setId(id);
		
		return anyOffer;
	}
	
	public static Offer createCompleteOffer(int minM, int maxM, double price, ForeignExchange exchange) {
		return new Offer(minM, maxM, price, exchange);
	}
}
