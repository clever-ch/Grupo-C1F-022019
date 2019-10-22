package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import root.constants.RegisterType;
import root.constants.UserType;
import root.model.FoodService;
import root.model.Provider;
import root.model.OrderHistory;
import model.factories.AccountFactory;
import model.factories.FoodServiceFactory;
import model.factories.OrderHistoryFactory;
import model.factories.ProviderFactory;
import model.factories.ProviderWalletFactory;

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
		
		Provider aProv = ProviderFactory.aProvider();
		aProv.setTypeRegister(RegisterType.TPA);
		aProv.setAcount(AccountFactory.anyAccount());
		aProv.setUserType(UserType.PROVIDER);
		aProv.setaProviderWallet(ProviderWalletFactory.anyProviderWallet());
		
		assertEquals(aProv.getTypeRegister(), RegisterType.TPA);
		assertEquals(aProv.getUserType(), UserType.PROVIDER);
		assertNotNull(aProv.getAcount());
		assertNotNull(aProv.getaWallet());
	}
}
