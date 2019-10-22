package model.factories;

import root.model.OrderHistory;

public class OrderHistoryFactory {
	
	public static OrderHistory anyOrderHistory() {
		return new OrderHistory();
	}
	
	public static OrderHistory createOrderHistoryWithId(long id) {
		OrderHistory anyOrderHistory = anyOrderHistory();
		anyOrderHistory.setId(id);
		
		return anyOrderHistory;
	}
}
