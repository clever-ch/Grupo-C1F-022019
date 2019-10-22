package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import root.constants.ScoreState;
import root.exceptions.DuplicateOrderException;
import root.exceptions.DuplicateOrderHistoryException;
import root.model.Customer;
import root.model.Menu;
import root.model.MenuScore;
import root.model.Order;
import root.model.OrderHistory;
import root.model.OrderItem;
import model.factories.CustomerFactory;
import model.factories.MenuFactory;
import model.factories.OrderFactory;
import model.factories.OrderHistoryFactory;
import model.factories.OrderItemFactory;

public class TestCustomer {

	@Test(expected = DuplicateOrderException.class)
	public void testAddDuplicateOrderThrowException() throws DuplicateOrderException {
		
		Order anyOrder = OrderFactory.createOrderWithId(1);
		Order sameOrder = OrderFactory.createOrderWithId(1);
		
		Customer anyCustomer = CustomerFactory.anyCustomer();
		anyCustomer.addOrder(anyOrder);
		
		anyCustomer.registerOrderIfApply(sameOrder);
	}
	
	@Test
	public void testCanAddOrder() throws DuplicateOrderException {
		
		Order anyOrder = OrderFactory.createOrderWithId(1);
		
		Customer anyCustomer = CustomerFactory.anyCustomer();
		anyCustomer.registerOrderIfApply(anyOrder);
		
		assertTrue(anyCustomer.haveOrder(anyOrder));
	}
	
	@Test
	public void testCustomerHaveOrder() {
		Order anyOrder = OrderFactory.createOrderWithId(1);
		
		Customer anyCustomer = CustomerFactory.anyCustomer();
		anyCustomer.addOrder(anyOrder);
		
		assertTrue(anyCustomer.haveOrder(anyOrder));
	}
	
	@Test
	public void testCustomerNotHaveOrder() {
		Order anyOrder = OrderFactory.createOrderWithId(1);
		Customer anyCustomer = CustomerFactory.anyCustomer();
		
		assertFalse(anyCustomer.haveOrder(anyOrder));
	}
	
	@Test
	public void testCustomerHaveOrderHistory() {
		OrderHistory anyOrderHistory = OrderHistoryFactory.createOrderHistoryWithId(1);
		Customer anyCustomer = CustomerFactory.anyCustomer();
		anyCustomer.addOrderHistory(anyOrderHistory);
		
		assertTrue(anyCustomer.haveOrderHistory(anyOrderHistory));
	}
	
	@Test
	public void testCustomerNotHaveOrderHistory() {
		OrderHistory anyOrderHistory = OrderHistoryFactory.createOrderHistoryWithId(1);
		Customer anyCustomer = CustomerFactory.anyCustomer();
		anyCustomer.addOrderHistory(anyOrderHistory);
		
		OrderHistory otherOrderHistory = OrderHistoryFactory.createOrderHistoryWithId(2);
		assertFalse(anyCustomer.haveOrderHistory(otherOrderHistory));
	}
	
	@Test
	public void testHistoryCanBeRecorded() throws DuplicateOrderHistoryException {
		OrderHistory anyOrderHistory = OrderHistoryFactory.createOrderHistoryWithId(1);
		Customer anyCustomer = CustomerFactory.anyCustomer();
		
		anyCustomer.registerOrderHistoryIfApply(anyOrderHistory);
		assertTrue(anyCustomer.haveOrderHistory(anyOrderHistory));
	}
	
	@Test(expected = DuplicateOrderHistoryException.class)
	public void testHistoryCantBeRecorded() throws DuplicateOrderHistoryException {
		OrderHistory anyOrderHistory = OrderHistoryFactory.createOrderHistoryWithId(1);
		Customer anyCustomer = CustomerFactory.anyCustomer();
		anyCustomer.addOrderHistory(anyOrderHistory);
		
		OrderHistory sameOrderHistory = OrderHistoryFactory.createOrderHistoryWithId(1);
		
		anyCustomer.registerOrderHistoryIfApply(sameOrderHistory);
	}
	
	@Test
	public void testCustomerHasPendingScore() {
		MenuScore menuScore = new MenuScore();
		menuScore.setScoreState(ScoreState.Pending);
		
		Menu menu = MenuFactory.anyMenu();
		menu.addMenuScore(menuScore);
		
		OrderItem orderItem = OrderItemFactory.anyOrderItem();
		orderItem.setMenu(menu);
		
		Order aOrder = OrderFactory.anyOrder();
		aOrder.addOrderItems(orderItem);
		
		Customer anyCustomer = CustomerFactory.anyCustomer();
		anyCustomer.addOrder(aOrder);
		
		assertTrue(anyCustomer.hasPendingScore());
	}
	
	@Test
	public void testCustomerHasNoPendingScore() {
		Order aOrder = OrderFactory.anyOrder();
		
		Customer anyCustomer = CustomerFactory.anyCustomer();
		anyCustomer.addOrder(aOrder);
		
		assertFalse(anyCustomer.hasPendingScore());
	}
}
