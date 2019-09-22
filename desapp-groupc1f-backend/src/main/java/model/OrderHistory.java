package model;

import utilities.Entity;

public class OrderHistory extends Entity {
	private User user;
	private Order order;
	
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
