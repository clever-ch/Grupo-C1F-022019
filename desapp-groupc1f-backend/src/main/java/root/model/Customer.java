package root.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import root.exceptions.DuplicateOrderException;
import root.exceptions.DuplicateOrderHistoryException;

@javax.persistence.Entity
public class Customer extends User {
	
	@OneToOne
	private CustomerWallet customerWallet;
	
	@OneToMany
    private List<Order> orders = new ArrayList<Order>();

	@OneToMany
	@Column(nullable = true)
    private List<OrderHistory> orderHistory = new ArrayList<OrderHistory>();
    
	public List<Order> getOrders() {
		return orders;
	}
	
	public boolean haveOrder(Order order) {
		for (Order o : this.orders) {
			if (o.getId() == order.getId())
				return true;
		}
		return false;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	public void registerOrderIfApply(Order order) throws DuplicateOrderException {
		if (haveOrder(order))
			throw new DuplicateOrderException("La orden ya se encuentra registrada");
		else
			addOrder(order);
	}
	
	public List<OrderHistory> getOrderHistory() {
		return orderHistory;
	}
	
	public void addOrderHistory(OrderHistory orderHistory) {
		this.orderHistory.add(orderHistory);
	}
	
	public boolean haveOrderHistory(OrderHistory oHistory) {
		for (OrderHistory history : orderHistory) {
			if (history.getId() == oHistory.getId())
				return true;
		}
		return false;
	}
	
	public void registerOrderHistoryIfApply(OrderHistory oHistory) throws DuplicateOrderHistoryException {
		if (haveOrderHistory(oHistory))
			throw new DuplicateOrderHistoryException("El historial ya se encuentra registrado");
		else
			addOrderHistory(oHistory);
	}
	
	public boolean hasPendingScore() {
		boolean result = false;
		
		for (Order order : orders)
			result = result | order.hasItemWithPendingScore();
		
		return result;
	}
	
	public CustomerWallet getaWallet() {
		return customerWallet;
	}

	public void setCustomerWallet(CustomerWallet aCustomerWallet) {
		this.customerWallet = aCustomerWallet;
	}
}
