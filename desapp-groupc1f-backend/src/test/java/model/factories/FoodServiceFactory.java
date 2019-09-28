package model.factories;

import model.FoodService;

public class FoodServiceFactory {
	
	public static FoodService aFoodService() {
		return new FoodService();
	}
}
