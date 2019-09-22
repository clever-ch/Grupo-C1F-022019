package model;

import java.util.Calendar;

import constants.DeliveryState;
import junit.framework.TestCase;
import modelFactories.*;

public class TestOrder extends TestCase {
	
	public void testHasOrderItem_hasItem() {
		
		OrderItem aOrderItem = OrderItemFactory.createOrderItemWithOneMenuAndName("Menu_1");
		Order aOrder = OrderFactory.createOrderWithItem(aOrderItem);
		
		assertTrue(aOrder.hasOrderItem(aOrderItem));
	}
	
	public void testHasOrderItem_hasNoItem() {

		OrderItem aOrderItem_Two = OrderItemFactory.createOrderItemWithOneMenuAndName("Menu_2");
		OrderItem aOrderItem = OrderItemFactory.createOrderItemWithOneMenuAndName("Menu_1");
		Order aOrder = OrderFactory.createOrderWithItem(aOrderItem);
		
		assertFalse(aOrder.hasOrderItem(aOrderItem_Two));
	}
	
	public void testIsDateDeliveredValid_isValid() {
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setCreationDate(today.getTime());
		
		assertTrue(aOrder.isDateDeliveredValid(tomorrow.getTime()));
	}
	
	public void testIsDateDeliveredValid_EqualsDateIsValid() {
		Calendar today = Calendar.getInstance();
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setCreationDate(today.getTime());
		
		assertTrue(aOrder.isDateDeliveredValid(today.getTime()));
	}
	
	public void testIsDateDeliveredValid_NotIsValid() {
		Calendar today = Calendar.getInstance();
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setCreationDate(today.getTime());
		
		assertFalse(aOrder.isDateDeliveredValid(yesterday.getTime()));
	}
	
	public void testOrderIsReceived_IsReceived() {
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setDeliveryState(DeliveryState.RECEIVED);
		
		assertTrue(aOrder.orderIsReceived());
	}
	
	public void testOrderIsReceived_NotIsReceived() {
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setDeliveryState(DeliveryState.PENDING);
		
		assertFalse(aOrder.orderIsReceived());
	}
	
	public void testareValidDatesOfOrder_DatesAreValid() {
		Order aOrder = OrderFactory.anyOrder();
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		aOrder.setCreationDate(today.getTime());
		aOrder.setDeliveredDate(tomorrow.getTime());
		
		assertTrue(aOrder.areValidDatesOfOrder());
	}
	
	public void testareValidDatesOfOrder_EqualsDatesAreValid() {
		Order aOrder = OrderFactory.anyOrder();
		Calendar today = Calendar.getInstance();
		aOrder.setCreationDate(today.getTime());
		aOrder.setDeliveredDate(today.getTime());
		
		assertTrue(aOrder.areValidDatesOfOrder());
	}
}
