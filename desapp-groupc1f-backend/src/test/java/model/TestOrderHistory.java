package model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import model.factories.CustomerFactory;
import model.factories.OrderFactory;
import model.factories.OrderHistoryFactory;
import root.constants.UserType;
import root.model.Customer;
import root.model.Order;
import root.model.OrderHistory;

public class TestOrderHistory {
	
	@Test
	public void testCreationOrderHistoryOk() {
		
		OrderHistory aOrderHis = OrderHistoryFactory.anyOrderHistory();
		aOrderHis.setUserType(UserType.CUSTOMER);
		
		Customer aCustomer = CustomerFactory.anyCustomer();
		UserType userType = UserType.CUSTOMER;
		Order aOrder = OrderFactory.anyOrder();
		
		aOrderHis.setUser(aCustomer, userType);
		aOrderHis.setOrder(aOrder);
		
		assertEquals(aCustomer, aOrderHis.getUser());
		assertEquals(aOrder, aOrderHis.getOrder());
	}

}
