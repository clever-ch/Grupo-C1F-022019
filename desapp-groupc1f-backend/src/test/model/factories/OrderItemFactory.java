package java.factories;

import model.Menu;
import model.OrderItem;

public class OrderItemFactory {
	
	public static OrderItem anyOrderItem() {
		return new OrderItem();
	}
	
	public static OrderItem createOrderItemWithOneMenuAndName(String menuName) {
		Menu aMenu = MenuFactory.anyMenu();
		aMenu.setMenuName(menuName);
		
		return new OrderItem(aMenu, 1);
	}
}
