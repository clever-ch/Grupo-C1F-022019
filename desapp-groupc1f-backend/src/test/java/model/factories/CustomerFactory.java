package model.factories;

import root.model.Customer;

public class CustomerFactory {
	
	public static Customer anyCustomer() {
		return new Customer();
	}
}
