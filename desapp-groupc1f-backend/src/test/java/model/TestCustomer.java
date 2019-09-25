package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import exceptions.DuplicateOrderException;
import exceptions.DuplicateOrderHistoryException;
import model.factories.CustomerFactory;
import model.factories.OrderFactory;
import model.factories.OrderHistoryFactory;

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
}
