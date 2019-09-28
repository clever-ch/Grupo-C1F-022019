package model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Calendar;
import org.junit.Test;
import constants.DeliveryState;
import constants.ScoreState;
import model.factories.MenuFactory;
import model.factories.OrderFactory;
import model.factories.OrderItemFactory;

public class TestOrder {
	
	@Test
	public void testAnyOrderItemHasItem() {
		
		OrderItem aOrderItem = OrderItemFactory.createOrderItemWithOneMenuAndName("Menu_1");
		Order aOrder = OrderFactory.createOrderWithItem(aOrderItem);
		
		assertTrue(aOrder.hasOrderItem(aOrderItem));
	}
	
	@Test
	public void testAnyOrderItemHasNoItem() {

		OrderItem aOrderItem_Two = OrderItemFactory.createOrderItemWithOneMenuAndName("Menu_2");
		OrderItem aOrderItem = OrderItemFactory.createOrderItemWithOneMenuAndName("Menu_1");
		Order aOrder = OrderFactory.createOrderWithItem(aOrderItem);
		
		assertFalse(aOrder.hasOrderItem(aOrderItem_Two));
	}
	
	@Test
	public void testIsValidTomorrowsDayDelivery() {
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setCreationDate(today.getTime());
		
		assertTrue(aOrder.isDateDeliveredValid(tomorrow.getTime()));
	}
	
	@Test
	public void testIsValidSameDayDelivery() {
		Calendar today = Calendar.getInstance();
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setCreationDate(today.getTime());
		
		assertTrue(aOrder.isDateDeliveredValid(today.getTime()));
	}
	
	@Test
	public void testNoIsValidDateYesterdayDelivered() {
		Calendar today = Calendar.getInstance();
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setCreationDate(today.getTime());
		
		assertFalse(aOrder.isDateDeliveredValid(yesterday.getTime()));
	}
	
	@Test
	public void testAnyOrderIsReceived() {
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setDeliveryState(DeliveryState.RECEIVED);
		
		assertTrue(aOrder.orderIsReceived());
	}
	
	@Test
	public void testAnyOrderNotIsReceived() {
		Order aOrder = OrderFactory.anyOrder();
		aOrder.setDeliveryState(DeliveryState.PENDING);
		
		assertFalse(aOrder.orderIsReceived());
	}
	
	@Test
	public void testOrderDatesAreValid() {
		Order aOrder = OrderFactory.anyOrder();
		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		aOrder.setCreationDate(today.getTime());
		aOrder.setDeliveredDate(tomorrow.getTime());
		
		assertTrue(aOrder.orderDatesAreValid());
	}
	
	@Test
	public void testSameDayOrderDateAreValid() {
		Order aOrder = OrderFactory.anyOrder();
		Calendar today = Calendar.getInstance();
		aOrder.setCreationDate(today.getTime());
		aOrder.setDeliveredDate(today.getTime());
		
		assertTrue(aOrder.orderDatesAreValid());
	}
	
	@Test
	public void testOrderHasItemWithPendingScore() {
		MenuScore menuScore = new MenuScore();
		menuScore.setScoreState(ScoreState.Pending);
		
		Menu menu = MenuFactory.anyMenu();
		menu.addMenuScore(menuScore);
		
		OrderItem orderItem = OrderItemFactory.anyOrderItem();
		orderItem.setMenu(menu);
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.addOrderItems(orderItem);
		
		assertTrue(aOrder.hasItemWithPendingScore());
	}
	
	@Test
	public void testOrderHasNoItemWithPendingScore() {
		MenuScore menuScore = new MenuScore();
		menuScore.setScoreState(ScoreState.Punctuated);
		
		Menu menu = MenuFactory.anyMenu();
		menu.addMenuScore(menuScore);
		
		OrderItem orderItem = OrderItemFactory.anyOrderItem();
		orderItem.setMenu(menu);
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.addOrderItems(orderItem);
		
		assertFalse(aOrder.hasItemWithPendingScore());
	}
}
