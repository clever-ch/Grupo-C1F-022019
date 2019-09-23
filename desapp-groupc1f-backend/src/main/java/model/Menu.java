package model;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import constants.Category;
import constants.MenuState;
import utilities.Entity;

public class Menu extends Entity {
	private String menuName;
	private String description;
	private List<Category> categories;
	private double deliveryPrice;
	private Date validFromDate;
	private Date validToDate;
	private DeliveryInfo deliveryInfo;
	private Time avgDeliveryTime;
	private double price;
	private List<Offer> offers;
	private int maximunSales;
	private MenuState menuState;
	private List<MenuScore> menuScore;
	
	
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

	public void addCategories(Category category) {
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

	public void addOffers(Offer offer) {
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
