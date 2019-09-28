package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.factories.CustomerFactory;
import model.factories.OrderFactory;
import model.factories.OrderHistoryFactory;

public class TestOrderHistory {
	
	@Test
	public void testCreationOrderHistoryOk() {
		
		OrderHistory aOrderHis = OrderHistoryFactory.anyOrderHistory();
		Customer aCustomer = CustomerFactory.anyCustomer();
		Order aOrder = OrderFactory.anyOrder();
		
		aOrderHis.setUser(aCustomer);
		aOrderHis.setOrder(aOrder);
		
		assertEquals(aCustomer, aOrderHis.getUser());
		assertEquals(aOrder, aOrderHis.getOrder());
	}

}
