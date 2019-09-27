package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.factories.FoodServiceFactory;

public class TestFoodService {
	
	@Test
	public void testCreateFoodServiceOK() {
		
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		aFoodSer.setServiceName("Empanadas");
		assertEquals("Empanadas", aFoodSer.getServiceName());
		aFoodSer.setEmail("alvaro@gmail.com");
		assertEquals("alvaro@gmail.com", aFoodSer.getEmail());
		aFoodSer.setDeliveryLocations("Mitre");
		assertEquals("Mitre", aFoodSer.getDeliveryLocations());
		aFoodSer.setLocationPointMap(".");
		assertEquals(".", aFoodSer.getLocationPointMap());
		aFoodSer.setMaxNumberMenus(6);
		assertEquals(6, aFoodSer.getMaxNumberMenus());
		aFoodSer.setPhone("234");
		assertEquals("234", aFoodSer.getPhone());
		aFoodSer.setServiceAddress("mitre");
		assertEquals("mitre", aFoodSer.getServiceAddress());
		aFoodSer.setServiceDescription("local de comidas");
		assertEquals("local de comidas", aFoodSer.getServiceDescription());
		aFoodSer.setServiceLocation("Quilmes");
		assertEquals("Quilmes", aFoodSer.getServiceLocation());
		aFoodSer.setWebSite("emp.com");
		assertEquals("emp.com", aFoodSer.getWebSite());
		
	}

}
