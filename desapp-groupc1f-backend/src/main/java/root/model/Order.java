package root.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import root.constants.DeliveryState;
import root.utilities.Entity;
import java.time.LocalTime;

@javax.persistence.Entity
public class Order extends Entity {
	
	@OneToMany
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();	
	private boolean hasDelivery;
	private Date creationDate;
	private Date deliveredDate;
	private LocalTime deliveryTime;
	
	@Enumerated(EnumType.STRING)
	private DeliveryState deliveryState;
	
	public boolean orderDatesAreValid() {
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
	
	public List<OrderItem> getOrderItems() {
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
	
	public boolean hasItemWithPendingScore() {
		boolean result = false;
		
		for (OrderItem orderItem : orderItems)
			result = result | orderItem.getMenu().hasMenuScorePending();
		
		return result;
	}
}
