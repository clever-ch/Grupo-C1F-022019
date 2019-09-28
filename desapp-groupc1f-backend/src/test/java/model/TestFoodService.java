package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import constants.MenuState;
import model.factories.FoodServiceFactory;
import model.factories.MenuFactory;

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
	
	@Test
	public void testFoodServiceHasMenuEnabled() {
		Menu menuEnabled = MenuFactory.anyMenu();
		menuEnabled.setMenuState(MenuState.Enabled);
		
		FoodService aFoodService = FoodServiceFactory.aFoodService();
		aFoodService.addServiceMenu(menuEnabled);
		
		assertTrue(aFoodService.numberMenusEnabled() == 1);
	}
	
	@Test
	public void testFoodServiceHasNoMenuEnabled() {
		FoodService aFoodService = FoodServiceFactory.aFoodService();
		
		assertTrue(aFoodService.numberMenusEnabled() == 0);
	}
	
	@Test
	public void testFoodServiceMeetsMaxNumberMenusEnabled() {
		final int NUMBER_MENUS_ENABLED = 10;
		List<Menu> menusEnabled = MenuFactory.createMenusWithState(NUMBER_MENUS_ENABLED, MenuState.Enabled);
		
		FoodService aFoodService = FoodServiceFactory.aFoodService();
		aFoodService.setSetServiceMenues(menusEnabled);
		
		assertTrue(aFoodService.meetsMaxNumberMenusEnabled());		
	}
	
	@Test
	public void testFoodServiceNotMeetsMaxNumberMenusEnabled() {
		final int NUMBER_MENUS_ENABLED = 21;
		List<Menu> menusEnabled = MenuFactory.createMenusWithState(NUMBER_MENUS_ENABLED, MenuState.Enabled);
		
		FoodService aFoodService = FoodServiceFactory.aFoodService();
		aFoodService.setSetServiceMenues(menusEnabled);
		
		assertFalse(aFoodService.meetsMaxNumberMenusEnabled());		
	}
}
