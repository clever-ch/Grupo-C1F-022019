package model.factories;

import model.CustomerWallet;

public class CustomerWalletFactory {

    public static CustomerWallet anyCustomerWallet() {
        return new CustomerWallet();
    }
}

