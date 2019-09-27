package model;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import constants.Category;
import constants.ForeignExchange;
import model.factories.MenuFactory;
import model.factories.OfferFactory;

public class TestMenu {

	//TODO: Testear que un precio u oferta no se repita en la lista de ofertas
	
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
	public void testMenuDatesAreValid() {		
		Menu aMenu = MenuFactory.anyMenu();
		
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
}
