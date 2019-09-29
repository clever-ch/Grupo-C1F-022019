package model.factories;


import model.FoodService;

public class FoodServiceFactory {
	
	public static FoodService aFoodService() {
		return new FoodService();
	}
	
	public static FoodService aFoodServiceComplete(String serviceName, String serviceLocation, String serviceAddress, String locationPointMap,
			String serviceDescription, String webSite, String email, String phone, String deliveryLocations, int maxNumberMenus) {
		
		FoodService newFoodService = new FoodService();
		newFoodService.setServiceName(serviceName);
		newFoodService.setServiceLocation(serviceLocation);
		newFoodService.setServiceAddress(serviceAddress);
		newFoodService.setLocationPointMap(locationPointMap);
		newFoodService.setServiceDescription(serviceDescription);
		newFoodService.setWebSite(webSite);
		newFoodService.setEmail(email);
		newFoodService.setPhone(phone);
		newFoodService.addServiceHours(ServiceHoursFactory.anyServiceHours());
		newFoodService.setDeliveryLocations(deliveryLocations);
		newFoodService.addServiceMenu(MenuFactory.anyMenu());
		newFoodService.setMaxNumberMenus(maxNumberMenus);
		
		return newFoodService;
		
	}
}
