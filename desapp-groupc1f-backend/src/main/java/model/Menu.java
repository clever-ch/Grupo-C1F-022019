package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import constants.Category;
import constants.MenuState;
import utilities.Entity;

public class Menu extends Entity {
	private String menuName;
	private String description;
	private List<Category> categories = new ArrayList<Category>();
	private double deliveryPrice;
	private Date validFromDate = Calendar.getInstance().getTime();
	private Date validToDate = Calendar.getInstance().getTime();
	private DeliveryInfo deliveryInfo;
	private Time avgDeliveryTime;
	private double price = 0;
	private List<Offer> offers = new ArrayList<Offer>();
	private int maximunSales;
	private MenuState menuState;
	private List<MenuScore> menuScore = new ArrayList<MenuScore>();
	
	public boolean isValidMenu() {
		return !isEmptyName() 
				& !isEmptyDescription()
				& hasMinimunCategories()
				& menuDatesAreValid()
				& hasAvgDeliveryTime()
				& hasMinimunOffers()
				& offersAreValid()
				& hasMaximunSales();
	}
	
	public boolean hasMaximunSales() {
		return this.maximunSales > 0;
	}
	
	public boolean hasMinimunOffers() {
		return this.offers.size() >= getModelConstants().minOffersMenu();
	}
	
	public boolean hasAvgDeliveryTime() {
		return this.avgDeliveryTime != null;
	}
	
	public boolean hasMinimunCategories() {
		return this.categories.size() >= getModelConstants().minCategoriesMenu();
	}
	
	public boolean isEmptyDescription() {
		return this.description == "" | this.description == null;
	}
	
	public boolean isEmptyName() {
		return this.menuName == "" | this.menuName == null;
	}
	
	public boolean offersAreValid() {
		Offer[] arrayOffers = (Offer[]) this.offers.stream().toArray(Offer[]::new);
		Offer fstOfert = arrayOffers[0];
		
		boolean result = true;
		
		for (int i = 1; i < arrayOffers.length; i++) {
			result = result & (fstOfert.offerIsExcluded(arrayOffers[i]));
		}
		
		return result;
	}
	
	public boolean menuDatesAreValid() {
		return this.validFromDate.before(validToDate) | this.validFromDate.equals(validToDate);
	}

	public String getMenuName() {
		return menuName;
	}
	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
	}

	public double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public Date getValidFromDate() {
		return validFromDate;
	}

	public void setValidFromDate(Date validFromDate) {
		this.validFromDate = validFromDate;
	}

	public Date getValidToDate() {
		return validToDate;
	}

	public void setValidToDate(Date validToDate) {
		this.validToDate = validToDate;
	}

	public DeliveryInfo getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public Time getAvgDeliveryTime() {
		return avgDeliveryTime;
	}

	public void setAvgDeliveryTime(Time avgDeliveryTime) {
		this.avgDeliveryTime = avgDeliveryTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Offer> getOffers() {
		return offers;
	}
	
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public void addOffer(Offer offer) {
		this.offers.add(offer);
	}

	public int getMaximunSales() {
		return maximunSales;
	}

	public void setMaximunSales(int maximunSales) {
		this.maximunSales = maximunSales;
	}

	public MenuState getMenuState() {
		return menuState;
	}

	public void setMenuState(MenuState menuState) {
		this.menuState = menuState;
	}

	public List<MenuScore> getMenuScore() {
		return menuScore;
	}

	public void addMenuScore(MenuScore menuScore) {
		this.menuScore.add(menuScore);
	}
}
