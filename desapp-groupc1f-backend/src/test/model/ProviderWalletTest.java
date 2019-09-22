package model;

import junit.framework.TestCase;
import model.factories.ProviderWalletFactory;
import org.junit.Test;

public class ProviderWalletTest extends TestCase {

    @Test
    public void testCreationWalletAmountCero(){

        ProviderWallet aCustomerWallet = ProviderWalletFactory.anyProviderWallet();
        assertEquals(0.0, aCustomerWallet.getAmount());

    }

    @Test
    public void testTakeCreditSuccess(){

        ProviderWallet aProviderWallet = ProviderWalletFactory.createProviderWalletWithAmount(200.0);
        aProviderWallet.takeCredit(100.0);
        assertEquals(100.0, aProviderWallet.getAmount());
    }

    @Test(expected = ArithmeticException.class)
    public void testTakeCreditNoSuccess(){
        ProviderWallet aProviderWallet = ProviderWalletFactory.createProviderWalletWithAmount(200.0);
        aProviderWallet.takeCredit(300.0);
        assertEquals(200.0, aProviderWallet.getAmount());
    }
}
