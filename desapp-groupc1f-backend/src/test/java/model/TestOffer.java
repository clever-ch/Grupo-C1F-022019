package model;

import static org.junit.Assert.*;

import org.junit.Test;

import constants.ForeignExchange;
import model.factories.OfferFactory;

public class TestOffer {

	@Test
	public void testOfferIsExcluded() {
		Offer anOffer = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		Offer offerExcluded = OfferFactory.createCompleteOffer(6, 7, 70, ForeignExchange.ARS);
		
		assertTrue(anOffer.offerIsExcluded(offerExcluded));
	}

	@Test
	public void testMinorOfferIsIntersected() {
		Offer anOffer = OfferFactory.createCompleteOffer(3, 6, 80, ForeignExchange.ARS);
		Offer offerNotExcluded = OfferFactory.createCompleteOffer(2, 4, 70, ForeignExchange.ARS);
		
		assertFalse(anOffer.offerIsExcluded(offerNotExcluded));
	}
	
	@Test
	public void testMajorOfferIsIntersected() {
		Offer anOffer = OfferFactory.createCompleteOffer(3, 6, 80, ForeignExchange.ARS);
		Offer offerNotExcluded = OfferFactory.createCompleteOffer(4, 8, 70, ForeignExchange.ARS);
		
		assertFalse(anOffer.offerIsExcluded(offerNotExcluded));
	}
	
	@Test
	public void testOfferContainsAnotherOffer() {
		Offer anOffer = OfferFactory.createCompleteOffer(3, 6, 80, ForeignExchange.ARS);
		Offer offerNotExcluded = OfferFactory.createCompleteOffer(4, 5, 70, ForeignExchange.ARS);
		
		assertFalse(anOffer.offerIsExcluded(offerNotExcluded));
	}
	
	@Test
	public void testOfferHasSameId() {
		Offer anyOffer = OfferFactory.createOfferWithId(1);
		Offer otherOffer = OfferFactory.createOfferWithId(1);
		
		assertTrue(anyOffer.offerHasSameId(otherOffer));
	}
	
	@Test
	public void testOfferNotHasSameId() {
		Offer anyOffer = OfferFactory.createOfferWithId(1);
		Offer otherOffer = OfferFactory.createOfferWithId(2);
		
		assertFalse(anyOffer.offerHasSameId(otherOffer));
	}
	
	@Test
	public void testOfferHasSamePrice() {
		Offer anyOffer = OfferFactory.anyOffer();
		anyOffer.setOfferPrice(10);
		
		Offer otherOffer = OfferFactory.anyOffer();
		otherOffer.setOfferPrice(10);
		
		assertTrue(anyOffer.offerHasSamePrice(otherOffer));
	}
	
	@Test
	public void testOfferNotHasSamePrice() {
		Offer anyOffer = OfferFactory.anyOffer();
		anyOffer.setOfferPrice(10);
		
		Offer otherOffer = OfferFactory.anyOffer();
		otherOffer.setOfferPrice(11);
		
		assertFalse(anyOffer.offerHasSamePrice(otherOffer));
	}
}
