package model;

import java.util.ArrayList;
import java.util.List;
import exceptions.DuplicateFoodServiceException;

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
	
	public boolean containsFoodService(FoodService foodService) {
		boolean contains = false;
		
		for (FoodService fService : this.foodService)
			contains = contains | fService.isTheSameFoodService(foodService);
		
		return contains;
	}
	
	public void registerFoodService(FoodService foodService) throws DuplicateFoodServiceException {
		if (containsFoodService(foodService))
			throw new DuplicateFoodServiceException("El servicio ya se encuentra registrado");
		else
			addFoodService(foodService);
	}
}
