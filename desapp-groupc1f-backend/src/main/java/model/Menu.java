package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Table;

import constants.Category;
import constants.MenuState;
import constants.ScoreState;
import exceptions.OfferRegistrationException;
import utilities.Entity;

@javax.persistence.Entity
public class Menu extends Entity {
	
	private String menuName;
	
	//@Column(name = "Description", nullable = true)
	private String description;
	
	//@Column(name = "IdCategory", nullable = false)
	private List<Category> categories = new ArrayList<Category>();
	
	//@Column(name = "DeliveryPrice", nullable = false)
	private double deliveryPrice;
	
	//@Column(name = "ValidFromDate", nullable = false)
	private Date validFromDate = Calendar.getInstance().getTime();
	
	//@Column(name = "ValidToDate", nullable = false)
	private Date validToDate = Calendar.getInstance().getTime();
	
	//@Column(name = "IdDeliveryInfo", nullable = false)
	private DeliveryInfo deliveryInfo;
	
	//@Column(name = "AvgDeliveryTime", nullable = false)
	private Time avgDeliveryTime;
	
	//@Column(name = "Price", nullable = false)
	private double price = 0;
	
	//@Column(name = "IdOffer", nullable = false)
	private List<Offer> offers = new ArrayList<Offer>();
	
	//@Column(name = "MaximunSales", nullable = false)
	private int maximunSales;
	
	//@Column(name = "MenuState", nullable = false)
	private MenuState menuState;
	
	//@Column(name = "IdMenuScore", nullable = false)
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

	public boolean isOfferValidToAdd(Offer offer) {
		boolean isValid = true;
		
		for (Offer anOffer : offers) {
			isValid = isValid
					& !anOffer.offerHasSameId(offer)
						& !anOffer.offerHasSamePrice(offer) 
							& anOffer.offerIsExcluded(offer);
		}
		return isValid;
	}
	
	public void registerOffer(Offer offer) throws OfferRegistrationException {
		if(isOfferValidToAdd(offer))
			this.offers.add(offer);
		else
			throw new OfferRegistrationException("Ya existe una oferta similar."); 
	}
	
	public boolean isEnabled() {
		return this.menuState.equals(MenuState.Enabled);
	}
	
	public boolean hasMenuScorePending() {
		boolean hasScorePending = false;
		
		for (MenuScore score : menuScore)
			hasScorePending = hasScorePending | score.getScoreState().equals(ScoreState.Pending);
		
		return hasScorePending;
	}
	
	public boolean isTheSameMenu(Menu menu) {
		return this.menuName.equals(menu.getMenuName()) 
				| this.getId() == menu.getId();
	}
}
