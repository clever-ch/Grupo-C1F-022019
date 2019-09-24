package java.factories;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import constants.Category;
import model.Menu;
import model.Offer;

public class MenuFactory {
	
	public static Menu anyMenu() {
		return new Menu();
	}
	
	public static Menu createMenuWithId(long id) {
		Menu anyMenu = anyMenu();
		anyMenu.setId(id);
		
		return anyMenu;
	}
	
	public static Menu createWithCompleteData(String name, String description, List<Category> categories, Date validFromDate, Date validToDate, 
			Time avgTime, List<Offer> offers, int maximunSales) {
		
		Menu anyMenu = anyMenu();
		anyMenu.setMenuName(name);
		anyMenu.setDescription(description);
		anyMenu.setCategories(categories);
		anyMenu.setValidFromDate(validFromDate);
		anyMenu.setValidToDate(validToDate);
		anyMenu.setAvgDeliveryTime(avgTime);
		anyMenu.setOffers(offers);
		anyMenu.setMaximunSales(maximunSales);
		
		return anyMenu;
	}
}
