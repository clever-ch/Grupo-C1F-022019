package model;

import java.util.ArrayList;
import java.util.Date;

import constants.DeliveryState;
import utilities.Entity;
import java.time.LocalTime;


public class Order extends Entity {
	private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();	
	private boolean hasDelivery;
	private Date creationDate;
	private Date deliveredDate;
	private LocalTime deliveryTime;
	private DeliveryState deliveryState;
	
	
	public boolean areValidDatesOfOrder() {
		return this.creationDate.before(deliveredDate) | this.creationDate.equals(deliveredDate);
	}
	
	public boolean orderIsReceived() {
		return this.deliveryState == DeliveryState.RECEIVED;
	}
	
	public boolean isDateDeliveredValid(Date aDate) {
		return this.creationDate.before(aDate) | this.creationDate.equals(aDate);
	}
	
	public boolean hasOrderItem(OrderItem orderItem) {
		return this.orderItems.contains(orderItem);
	}
	
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void addOrderItems(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}

	public boolean isHasDelivery() {
		return hasDelivery;
	}

	public void setHasDelivery(boolean hasDelivery) {
		this.hasDelivery = hasDelivery;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public LocalTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public DeliveryState getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(DeliveryState deliveryState) {
		this.deliveryState = deliveryState;
	}
}
