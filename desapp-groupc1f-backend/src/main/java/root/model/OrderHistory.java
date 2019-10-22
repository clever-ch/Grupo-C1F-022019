package root.model;

import javax.persistence.OneToOne;

import root.constants.UserType;
import root.utilities.Entity;

@javax.persistence.Entity
public class OrderHistory extends Entity{
	
	@OneToOne
	private Provider provider;
	
	@OneToOne
	private Customer customer;
	
	private UserType userType;
	
	@OneToOne
	private Order order;
	
	public User getUser() {
		if (this.userType.equals(UserType.CUSTOMER))
			return this.customer;
		else
			return this.provider;
	}
	
	public void setUser(User user, UserType userType) {
		if (this.userType.equals(UserType.CUSTOMER))
			this.customer = (Customer) user;
		else
			this.provider = (Provider) user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
