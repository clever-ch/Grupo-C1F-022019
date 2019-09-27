package model;

import java.util.ArrayList;
import java.util.List;

public class Provider extends User {
	private List<FoodService> foodService = new ArrayList<FoodService>();
	private List<OrderHistory> orderHistory = new ArrayList<OrderHistory>();
	
	
	public List<FoodService> getFoodService() {
		return foodService;
	}
	
	public void addFoodService(FoodService foodService) {
		this.foodService.add(foodService);
	}

	public List<OrderHistory> getOrderHistory() {
		return orderHistory;
	}

	public void addOrderHistory(OrderHistory orderHistory) {
		this.orderHistory.add(orderHistory);
	}
}
