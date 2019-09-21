package model;

import java.util.List;

public class Customer extends User {
    private List<Order> order;
    private List<OrderHistory> orderHistory;
    
	public List<Order> getOrder() {
		return order;
	}
	
	public void setOrder(List<Order> orders) {
		this.order = orders;
	}
	
	public void addOrder(Order order) {
		this.order.add(order);
	}
	
	public List<OrderHistory> getOrderHistory() {
		return orderHistory;
	}
	
	public void setOrderHistory(List<OrderHistory> orderHistories) {
		this.orderHistory = orderHistories;
	}
	
	public void addOrderHistory(OrderHistory orderHistory) {
		this.orderHistory.add(orderHistory);
	}
}
