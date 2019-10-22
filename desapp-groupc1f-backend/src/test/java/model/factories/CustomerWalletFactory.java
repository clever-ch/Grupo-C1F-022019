package model.factories;

import root.model.CustomerWallet;

public class CustomerWalletFactory {

    public static CustomerWallet anyCustomerWallet() {
        return new CustomerWallet();
    }
}

