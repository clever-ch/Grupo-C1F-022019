package java;

import junit.framework.TestCase;
import model.CustomerWallet;
import java.factories.CustomerWalletFactory;
import org.junit.Test;

public class TestCustomerWallet extends TestCase {

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