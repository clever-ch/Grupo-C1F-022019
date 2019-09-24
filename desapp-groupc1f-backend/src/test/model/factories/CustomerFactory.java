package model.factories;

import model.Customer;

public class CustomerFactory {
	
	public static Customer anyCustomer() {
		return new Customer();
	}
}
