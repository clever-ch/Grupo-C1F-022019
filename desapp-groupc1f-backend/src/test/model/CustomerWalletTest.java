package model;

import junit.framework.TestCase;
import modelFactories.CustomerWalletFactory;
import org.junit.Test;

public class CustomerWalletTest extends TestCase {

    @Test
    public void testCreationWalletAmountCero(){

        CustomerWallet aCustomerWallet = CustomerWalletFactory.anyCustomerWallet();
        assertEquals(0.0, aCustomerWallet.getAmount());

    }

    @Test
    public void testLoadCreditLoadSuccessAndCheckCredit() {
        CustomerWallet aCustomerWallet = CustomerWalletFactory.anyCustomerWallet();
        aCustomerWallet.loadCredit(100.0);

        assertEquals(100.0, aCustomerWallet.getAmount());

        assertEquals(100.0, aCustomerWallet.checkCredit());
    }

}
