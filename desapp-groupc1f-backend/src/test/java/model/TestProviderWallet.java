package model;

import exceptions.CantTakeCreditException;
import model.ProviderWallet;

import model.factories.ProviderWalletFactory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestProviderWallet {

    @Test
    public void testCreationWalletAmountCero(){

        ProviderWallet aCustomerWallet = ProviderWalletFactory.anyProviderWallet();
        assertEquals(0.0, aCustomerWallet.getAmount(), 0.0);

    }

    @Test
    public void testTakeCreditSuccess() throws CantTakeCreditException {

        ProviderWallet aProviderWallet = ProviderWalletFactory.createProviderWalletWithAmount(200.0);
        aProviderWallet.takeCredit(100.0);
        assertEquals(100.0, aProviderWallet.checkCredit(), 0.0);
    }

    @Test(expected = CantTakeCreditException.class)
    public void testTakeCreditNoSuccess() throws CantTakeCreditException {
        ProviderWallet aProviderWallet = ProviderWalletFactory.createProviderWalletWithAmount(200.0);
        aProviderWallet.takeCredit(300.0);
    }
}