package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import constants.MenuState;
import model.factories.FoodServiceFactory;
import model.factories.MenuFactory;
import model.factories.ServiceHoursFactory;

public class TestFoodService {
	
	@Test
	public void testIsValidFoodService() {
		
		FoodService aFoodSer = FoodServiceFactory.aFoodServiceComplete("Empanadas", "Mitre", "mitre", "0.0", 
				"local de comidas", "emp.com","alvaro@gmail.com", "234", "Mitre", 4);
		
		assertTrue(aFoodSer.isValidFoodService());
		
	}
	
	@Test
	public void testIsEmptyServiceName() {
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		
		assertTrue(aFoodSer.isEmptyServiceName());
	}	
	
	@Test
	public void testHasEmail() {
		
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		aFoodSer.setEmail("alvaro@gmail.com");
		assertTrue(aFoodSer.hasEmail());
		
	}
	
	@Test
	public void testHasDeliveryLocation() {
		
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		aFoodSer.setDeliveryLocations("Mitre");
		assertTrue(aFoodSer.hasDeliveryLocation());
	}
	
	@Test
	public void testIsEmptyLocationPointM() {
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		
		assertTrue(aFoodSer.isEmptyLocationPointM());
	}
	
	@Test
	public void testHasMaxNumberMenuesValid() {
		
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		aFoodSer.setMaxNumberMenus(6);
		assertTrue(aFoodSer.hasMaxNumberMenuesValid());	
	}
	
	@Test
	public void testHasPhoneValid() {
		FoodService aFoodSer = FoodServiceFactory.aFoodService();

		aFoodSer.setPhone("234");
		assertTrue(aFoodSer.hasPhoneValid());
	}

	@Test
	public void testIsEmptyServiceAddress() {
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		
		assertTrue(aFoodSer.isEmptyServiceAddress());
	}
	
	@Test
	public void testHashasDescription() {
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		
		aFoodSer.setServiceDescription("local de comidas");
		assertTrue(aFoodSer.hasDescription());
	}
	
	@Test
	public void testIsEmptyServiceLocation() {
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		assertTrue(aFoodSer.isEmptyServiceLocation());
	}

	@Test
	public void testHasWebSiteValid() {
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		aFoodSer.setWebSite("emp.com");
		assertTrue(aFoodSer.hasWebSiteValid());
	}
	
	@Test
	public void testHasAListOfServiceHours() {
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		aFoodSer.addServiceHours(ServiceHoursFactory.anyServiceHours());
		
		assertTrue(aFoodSer.hasAListOfServiceHours());
	}
	
	@Test
	public void testHasMenues() {
		FoodService aFoodSer = FoodServiceFactory.aFoodService();
		aFoodSer.addServiceMenu(MenuFactory.anyMenu());
		assertTrue(aFoodSer.hasMenues());
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
