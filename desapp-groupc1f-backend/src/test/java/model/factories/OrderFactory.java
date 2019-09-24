package model.factories;

import model.Order;
import model.OrderItem;

public class OrderFactory {
	
	public static Order anyOrder() {
		return new Order();
	}
	
	public static Order createOrderWithItem(OrderItem item) {
		Order aOrder = anyOrder();
		aOrder.addOrderItems(item);
		
		return aOrder;
	}
	
	public static Order createOrderWithId(long id) {
		Order aOrder = anyOrder();
		aOrder.setId(id);
		
		return aOrder;
	}
}
