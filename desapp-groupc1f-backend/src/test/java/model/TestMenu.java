package model;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import constants.Category;
import constants.ForeignExchange;
import exceptions.OfferRegistrationException;
import model.factories.MenuFactory;
import model.factories.OfferFactory;

public class TestMenu {

	@Test
	public void testMenuWithOneOfferIsValid() {
		Offer offerOne = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(offerOne);
		
		assertTrue(aMenu.offersAreValid());
	}
	
	@Test
	public void testMenuOffersAreValid() {
		Offer offerOne = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		Offer offerTwo = OfferFactory.createCompleteOffer(6, 7, 70, ForeignExchange.ARS);
		Offer offerThree = OfferFactory.createCompleteOffer(13, 15, 60, ForeignExchange.ARS);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(offerOne);
		aMenu.addOffer(offerTwo);
		aMenu.addOffer(offerThree);
		
		assertTrue(aMenu.offersAreValid());
	}
	
	@Test
	public void testItsValidMenu() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(Category.Pizza);
		
		Offer anyOffer = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(anyOffer);
		
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Time avgTime = new Time(1);
		
		Menu aMenu = MenuFactory.createWithCompleteData("Name","Description",categories,today.getTime(),tomorrow.getTime(),avgTime,offers,10);
		
		assertTrue(aMenu.isValidMenu());
	}
	
	@Test
	public void testNamelessFullMenuIsNotValid() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(Category.Pizza);
		
		Offer anyOffer = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(anyOffer);
		
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Time avgTime = new Time(1);
		
		Menu aMenu = MenuFactory.createWithCompleteData("","Description",categories,today.getTime(),tomorrow.getTime(),avgTime,offers,10);
		
		assertFalse(aMenu.isValidMenu());
	}
	
	@Test
	public void testFullMenuWithoutDescriptionIsNotValid() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(Category.Pizza);
		
		Offer anyOffer = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(anyOffer);
		
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Time avgTime = new Time(1);
		
		Menu aMenu = MenuFactory.createWithCompleteData("Name","",categories,today.getTime(),tomorrow.getTime(),avgTime,offers,10);
		
		assertFalse(aMenu.isValidMenu());
	}
	
	@Test
	public void testFullMenuWithoutCategoriesIsNotValid() {
		List<Category> categories = new ArrayList<Category>();
		
		Offer anyOffer = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(anyOffer);
		
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Time avgTime = new Time(1);
		
		Menu aMenu = MenuFactory.createWithCompleteData("Name","Desc",categories,today.getTime(),tomorrow.getTime(),avgTime,offers,10);
		
		assertFalse(aMenu.isValidMenu());
	}
	
	@Test
	public void testFullMenuDatesAreNotValid() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(Category.Pizza);
		
		Offer anyOffer = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(anyOffer);
		
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Time avgTime = new Time(1);
		
		Menu aMenu = MenuFactory.createWithCompleteData("Name","Desc",categories,tomorrow.getTime(),today.getTime(),avgTime,offers,10);
		
		assertFalse(aMenu.isValidMenu());
	}
	
	@Test
	public void testFullMenuAvgTimeIsNotValid() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(Category.Pizza);
		
		Offer anyOffer = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(anyOffer);
		
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Time avgTime = null;
		
		Menu aMenu = MenuFactory.createWithCompleteData("Name","Desc",categories,today.getTime(),tomorrow.getTime(),avgTime,offers,10);
		
		assertFalse(aMenu.isValidMenu());
	}
	
	@Test
	public void testFullMenuMaxSalesIsNotValid() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(Category.Pizza);
		
		Offer anyOffer = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(anyOffer);
		
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Time avgTime = new Time(1);
		
		Menu aMenu = MenuFactory.createWithCompleteData("Name","Desc",categories,today.getTime(),tomorrow.getTime(),avgTime,offers,0);
		
		assertFalse(aMenu.isValidMenu());
	}
	
	@Test
	public void testMenuHasEmptyName() {
		Menu aMenu = MenuFactory.anyMenu();
		
		assertTrue(aMenu.isEmptyName());
	}
	
	@Test
	public void testMenuHasNoEmptyName() {
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.setMenuName("anyName");
		
		assertFalse(aMenu.isEmptyName());
	}
	
	@Test
	public void testMenuHasEmptyDescription() {
		Menu aMenu = MenuFactory.anyMenu();
		
		assertTrue(aMenu.isEmptyDescription());
	}
	
	@Test
	public void testMenuHasNoEmptyDescription() {
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.setDescription("anyDescription");
		
		assertFalse(aMenu.isEmptyDescription());
	}
	
	@Test
	public void testMenuHasMinimunCategories() {		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addCategory(Category.Pizza);
		
		assertTrue(aMenu.hasMinimunCategories());
	}
	
	@Test
	public void testMenuHasNoMinimunCategories() {		
		Menu aMenu = MenuFactory.anyMenu();
		
		assertFalse(aMenu.hasMinimunCategories());
	}
	
	@Test
	public void testMenuDatesDefaultAreValid() {		
		Menu aMenu = MenuFactory.anyMenu();
		
		assertTrue(aMenu.menuDatesAreValid());
	}
	
	@Test
	public void testMenuDatesAreValid() {
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.setValidFromDate(today.getTime());
		aMenu.setValidToDate(tomorrow.getTime());
		
		assertTrue(aMenu.menuDatesAreValid());
	}
	
	@Test
	public void testMenuDatesAreNotValid() {
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.setValidFromDate(tomorrow.getTime());
		aMenu.setValidToDate(today.getTime());
		
		assertFalse(aMenu.menuDatesAreValid());
	}
	
	@Test
	public void testMenuHasAvgDeliveryTime() {
		Time anyTime = new Time(1);
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.setAvgDeliveryTime(anyTime);
		assertTrue(aMenu.hasAvgDeliveryTime());
	}
	
	@Test
	public void testMenuHasNoAvgDeliveryTime() {		
		Menu aMenu = MenuFactory.anyMenu();
		
		assertFalse(aMenu.hasAvgDeliveryTime());
	}
	
	@Test
	public void testMenuHasMinimunOffers() {
		Offer anyOffer = OfferFactory.createCompleteOffer(8, 12, 80, ForeignExchange.ARS);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);

		assertTrue(aMenu.hasMinimunOffers());
	}
	
	@Test
	public void testMenuHasNoMinimunOffers() {
		Menu aMenu = MenuFactory.anyMenu();

		assertFalse(aMenu.hasMinimunOffers());
	}
	
	@Test
	public void testMenuHasMaximunSales() {
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.setMaximunSales(1);

		assertTrue(aMenu.hasMaximunSales());
	}
	
	@Test
	public void testMenuHasNoMaximunSales() {
		Menu aMenu = MenuFactory.anyMenu();

		assertFalse(aMenu.hasMaximunSales());
	}
	
	@Test
	public void testOfferWithSameIdNotIsValidToAdd() {
		final long SAME_ID = 1;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(1, 2, 10, ForeignExchange.ARS);
		anyOffer.setId(SAME_ID);
		
		Offer offerWithSameId = OfferFactory.createCompleteOffer(4, 5, 20, ForeignExchange.ARS);
		offerWithSameId.setId(SAME_ID);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		assertFalse(aMenu.isOfferValidToAdd(offerWithSameId));
	}
	
	@Test
	public void testOfferWithDifferentIdIsValidToAdd() {
		final long ANY_ID = 1;
		final long OTHER_ID = 2;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(1, 2, 10, ForeignExchange.ARS);
		anyOffer.setId(ANY_ID);
		
		Offer offerWithDifferentId = OfferFactory.createCompleteOffer(4, 5, 20, ForeignExchange.ARS);
		offerWithDifferentId.setId(OTHER_ID);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		assertTrue(aMenu.isOfferValidToAdd(offerWithDifferentId));
	}
	
	@Test
	public void testOfferWithSamePriceNotIsValidToAdd() {
		final double SAME_PRICE = 10;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(1, 2, SAME_PRICE, ForeignExchange.ARS);
		anyOffer.setId(1);
		
		Offer offerWithSamePrice = OfferFactory.createCompleteOffer(4, 5, SAME_PRICE, ForeignExchange.ARS);
		offerWithSamePrice.setId(2);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		assertFalse(aMenu.isOfferValidToAdd(offerWithSamePrice));
	}
	
	@Test
	public void testOfferWithDifferentPriceIsValidToAdd() {
		final double ANY_PRICE = 10;
		final double OTHER_PRICE = 20;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(1, 2, ANY_PRICE, ForeignExchange.ARS);
		anyOffer.setId(1);
		
		Offer offerWithDifferentPrice = OfferFactory.createCompleteOffer(4, 5, OTHER_PRICE, ForeignExchange.ARS);
		offerWithDifferentPrice.setId(2);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		assertTrue(aMenu.isOfferValidToAdd(offerWithDifferentPrice));
	}
	
	@Test
	public void testOfferExcludedIsValidToAdd() {
		final int MIN = 5;
		final int MAX = 8;
		final int MIN_NOT_INTERSECT = 9;
		final int MAX_NOT_INTERSECT = 10;
		
		
		Offer anyOffer = OfferFactory.createCompleteOffer(MIN, MAX, 10, ForeignExchange.ARS);
		anyOffer.setId(1);
		
		Offer otherOffer = OfferFactory.createCompleteOffer(MIN_NOT_INTERSECT, MAX_NOT_INTERSECT, 20, ForeignExchange.ARS);
		otherOffer.setId(2);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		assertTrue(aMenu.isOfferValidToAdd(otherOffer));
	}
	
	@Test
	public void testOfferNotExcludedNotValidToAdd() {
		final int MIN = 5;
		final int MAX = 8;
		final int MIN_WITH_INTERSECTION = 6;
		final int MAX_WITH_INTERSECTION = 10;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(MIN, MAX, 10, ForeignExchange.ARS);
		anyOffer.setId(1);
		
		Offer otherOffer = OfferFactory.createCompleteOffer(MIN_WITH_INTERSECTION, MAX_WITH_INTERSECTION, 20, ForeignExchange.ARS);
		otherOffer.setId(2);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		assertFalse(aMenu.isOfferValidToAdd(otherOffer));
	}
	
	@Test(expected = OfferRegistrationException.class)
	public void testRegisterOfferWithSameIdThrowsException() throws OfferRegistrationException {
		final long SAME_ID = 1;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(1, 5, 10, ForeignExchange.ARS);
		anyOffer.setId(SAME_ID);
		
		Offer otherOffer = OfferFactory.createCompleteOffer(6, 8, 20, ForeignExchange.ARS);
		otherOffer.setId(SAME_ID);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		aMenu.registerOffer(otherOffer);
	}
	
	@Test(expected = OfferRegistrationException.class)
	public void testRegisterOfferWithSamePriceThrowsException() throws OfferRegistrationException {
		final double SAME_PRICE = 10;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(1, 5, SAME_PRICE, ForeignExchange.ARS);
		anyOffer.setId(1);
		
		Offer otherOffer = OfferFactory.createCompleteOffer(6, 8, SAME_PRICE, ForeignExchange.ARS);
		otherOffer.setId(2);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		aMenu.registerOffer(otherOffer);
	}
	
	@Test(expected = OfferRegistrationException.class)
	public void testRegisterOfferNotExcludedThrowsException() throws OfferRegistrationException {
		final int MIN = 5;
		final int MAX = 8;
		final int MIN_WITH_INTERSECTION = 6;
		final int MAX_WITH_INTERSECTION = 10;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(MIN, MAX, 10, ForeignExchange.ARS);
		anyOffer.setId(1);
		
		Offer otherOffer = OfferFactory.createCompleteOffer(MIN_WITH_INTERSECTION, MAX_WITH_INTERSECTION, 20, ForeignExchange.ARS);
		otherOffer.setId(2);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		aMenu.registerOffer(otherOffer);
	}
	//
	@Test
	public void testRegisterOfferWithDifferentIdNotThrowException() throws OfferRegistrationException {
		final long SAME_ID = 1;
		final long OTHER_ID = 2;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(1, 5, 10, ForeignExchange.ARS);
		anyOffer.setId(SAME_ID);
		
		Offer otherOffer = OfferFactory.createCompleteOffer(6, 8, 20, ForeignExchange.ARS);
		otherOffer.setId(OTHER_ID);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		aMenu.registerOffer(otherOffer);
		
		assertTrue(aMenu.getOffers().size() == 2);
	}
	
	@Test
	public void testRegisterOfferWithDifferentPriceNotThrowException() throws OfferRegistrationException {
		final double ANY_PRICE = 10;
		final double DIFFERENT_PRICE = 20;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(1, 5, ANY_PRICE, ForeignExchange.ARS);
		anyOffer.setId(1);
		
		Offer otherOffer = OfferFactory.createCompleteOffer(6, 8, DIFFERENT_PRICE, ForeignExchange.ARS);
		otherOffer.setId(2);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		aMenu.registerOffer(otherOffer);
		
		assertTrue(aMenu.getOffers().size() == 2);
	}
	
	@Test
	public void testRegisterOfferExcludedNotThrowException() throws OfferRegistrationException {
		final int MIN = 5;
		final int MAX = 8;
		final int MIN_NOT_INTERSECT = 9;
		final int MAX_NOT_INTERSECT = 10;
		
		Offer anyOffer = OfferFactory.createCompleteOffer(MIN, MAX, 10, ForeignExchange.ARS);
		anyOffer.setId(1);
		
		Offer otherOffer = OfferFactory.createCompleteOffer(MIN_NOT_INTERSECT, MAX_NOT_INTERSECT, 20, ForeignExchange.ARS);
		otherOffer.setId(2);
		
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.addOffer(anyOffer);
		
		aMenu.registerOffer(otherOffer);
		
		assertTrue(aMenu.getOffers().size() == 2);
	}
}
