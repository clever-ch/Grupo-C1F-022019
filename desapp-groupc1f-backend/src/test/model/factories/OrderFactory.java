package java.factories;

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
}
