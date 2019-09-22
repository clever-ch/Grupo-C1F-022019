package modelFactories;

import model.CustomerWallet;

public class CustomerWalletFactory {

    public static CustomerWallet anyCustomerWallet() {
        return new CustomerWallet();
    }
}
