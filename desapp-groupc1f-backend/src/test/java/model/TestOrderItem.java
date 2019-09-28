package model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import model.factories.MenuFactory;
import model.factories.OrderItemFactory;

public class TestOrderItem {

	@Test
	public void testOrderItemCanAddMenu() {
		Menu anyMenu = MenuFactory.anyMenu();
		
		OrderItem orderItem = OrderItemFactory.anyOrderItem();
		orderItem.setMenu(anyMenu);
		
		assertTrue(orderItem.getMenu().equals(anyMenu));
	}

	@Test
	public void testOrderItemHasNoNumberOfMenus() {
		OrderItem orderItem = OrderItemFactory.anyOrderItem();
		
		assertFalse(orderItem.getNumberMenus() > 0);
	}
	
	@Test
	public void testOrderItemNumberOfMenusIsNotvalid() {
		OrderItem orderItem = OrderItemFactory.anyOrderItem();
		
		assertFalse(orderItem.isNumberOfMenusValid(0));
	}
	
	@Test
	public void testOrderItemNumberOfMenusIsvalid() {
		OrderItem orderItem = OrderItemFactory.anyOrderItem();
		
		assertTrue(orderItem.isNumberOfMenusValid(1));
	}
}
