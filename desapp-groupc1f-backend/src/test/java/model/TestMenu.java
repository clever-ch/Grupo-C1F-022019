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
	public void testNamelessMenuIsNotValid() {
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
	
	//TODO: a partir de aca testear cada metodo por condicion por separado
	@Test
	public void testMenuWithoutDescriptionIsNotValid() {
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
	public void testMenuWithoutCategoriesIsNotValid() {
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
	public void testMenuDatesAreNotValid() {
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
	public void testMenuAvgTimeIsNotValid() {
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
	public void testMenuMaxSalesIsNotValid() {
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

}
