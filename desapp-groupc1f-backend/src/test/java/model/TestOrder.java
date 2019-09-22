package model;

import java.util.Calendar;

import constants.DeliveryState;
import junit.framework.TestCase;
import model.factories.OrderFactory;
import model.factories.OrderItemFactory;

public class TestOrder extends TestCase {
	
	public void testAnyOrderItemHasItem() {
		
		OrderItem aOrderItem = OrderItemFactory.createOrderItemWithOneMenuAndName("Menu_1");
		Order aOrder = OrderFactory.createOrderWithItem(aOrderItem);
		
		assertTrue(aOrder.hasOrderItem(aOrderItem));
	}
	
	public void testAnyOrderItemHasNoItem() {

		OrderItem aOrderItem_Two = OrderItemFactory.createOrderItemWithOneMenuAndName("Menu_2");
		OrderItem aOrderItem = OrderItemFactory.createOrderItemWithOneMenuAndName("Menu_1");
		Order aOrder = OrderFactory.createOrderWithItem(aOrderItem);
		
		assertFalse(aOrder.hasOrderItem(aOrderItem_Two));
	}
	
	public void testIsValidTomorrowsDayDelivery() {
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setCreationDate(today.getTime());
		
		assertTrue(aOrder.isDateDeliveredValid(tomorrow.getTime()));
	}
	
	public void testIsValidSameDayDelivery() {
		Calendar today = Calendar.getInstance();
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setCreationDate(today.getTime());
		
		assertTrue(aOrder.isDateDeliveredValid(today.getTime()));
	}
	
	public void testNoIsValidDateYesterdayDelivered() {
		Calendar today = Calendar.getInstance();
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setCreationDate(today.getTime());
		
		assertFalse(aOrder.isDateDeliveredValid(yesterday.getTime()));
	}
	
	public void testAnyOrderIsReceived() {
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setDeliveryState(DeliveryState.RECEIVED);
		
		assertTrue(aOrder.orderIsReceived());
	}
	
	public void testAnyOrderNotIsReceived() {
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setDeliveryState(DeliveryState.PENDING);
		
		assertFalse(aOrder.orderIsReceived());
	}
	
	public void testOrderDatesAreValid() {
		Order aOrder = OrderFactory.anyOrder();
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		aOrder.setCreationDate(today.getTime());
		aOrder.setDeliveredDate(tomorrow.getTime());
		
		assertTrue(aOrder.areValidDatesOfOrder());
	}
	
	public void testSameDayOrderDateAreValid() {
		Order aOrder = OrderFactory.anyOrder();
		Calendar today = Calendar.getInstance();
		aOrder.setCreationDate(today.getTime());
		aOrder.setDeliveredDate(today.getTime());
		
		assertTrue(aOrder.areValidDatesOfOrder());
	}
}
