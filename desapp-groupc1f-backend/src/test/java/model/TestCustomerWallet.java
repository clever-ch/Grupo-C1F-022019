package model;

import root.model.CustomerWallet;
import model.factories.CustomerWalletFactory;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCustomerWallet {

    @Test
    public void testCreationWalletAmountCero(){

        CustomerWallet aCustomerWallet = CustomerWalletFactory.anyCustomerWallet();
        assertEquals(0.0, aCustomerWallet.getAmount(), 0.0);

    }

    @Test
    public void testLoadCreditLoadSuccessAndCheckCredit() {
        CustomerWallet aCustomerWallet = CustomerWalletFactory.anyCustomerWallet();
        aCustomerWallet.loadCredit(100.0);

        assertEquals(100.0, aCustomerWallet.getAmount(), 0.0);

        assertEquals(100.0, aCustomerWallet.checkCredit(), 0.0);
    }

}

