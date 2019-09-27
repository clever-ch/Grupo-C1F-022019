package model;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import model.FoodService;
import model.Provider;
import model.OrderHistory;
import model.factories.FoodServiceFactory;
import model.factories.OrderHistoryFactory;
import model.factories.ProviderFactory;

public class TestProvider  {
	
	@Test
	public void testAddFoodServicesSucess() {
		
		FoodService aFoodServi = FoodServiceFactory.aFoodService();
		Provider aProvider = ProviderFactory.aProvider();
	
		aProvider.addFoodService(aFoodServi);
		
		assertTrue(aProvider.getFoodService().contains(aFoodServi));
	}
	
	@Test
	public void testAddOrderHistorySuccess() {
		
		OrderHistory aOrderHis = OrderHistoryFactory.anyOrderHistory();
		Provider aProvider = ProviderFactory.aProvider();
		
		aProvider.addOrderHistory(aOrderHis);
		
		assertSame(aOrderHis, aProvider.getOrderHistory().get(0));
	}
	
	@Test
	public void testProviderAsUserRegisterOK() {
		//TODO
	}
}
