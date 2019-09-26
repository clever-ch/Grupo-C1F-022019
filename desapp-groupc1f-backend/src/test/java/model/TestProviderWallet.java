package model;

import exceptions.CantTakeCreditException;
import junit.framework.TestCase;
import model.ProviderWallet;

import model.factories.ProviderWalletFactory;

import org.junit.Test;

public class    TestProviderWallet extends TestCase {

    @Test
    public void testCreationWalletAmountCero(){

        ProviderWallet aCustomerWallet = ProviderWalletFactory.anyProviderWallet();
        assertEquals(0.0, aCustomerWallet.getAmount());

    }

    @Test
    public void testTakeCreditSuccess() throws CantTakeCreditException {

        ProviderWallet aProviderWallet = ProviderWalletFactory.createProviderWalletWithAmount(200.0);
        aProviderWallet.takeCredit(100.0);
        assertEquals(100.0, aProviderWallet.getAmount());
    }

    @Test(expected = CantTakeCreditException.class)
    public void testTakeCreditNoSuccess() throws CantTakeCreditException {
        ProviderWallet aProviderWallet = ProviderWalletFactory.createProviderWalletWithAmount(200.0);
        aProviderWallet.takeCredit(300.0);
    }
}