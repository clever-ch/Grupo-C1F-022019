package model.factories;

import root.model.ProviderWallet;

public class ProviderWalletFactory {

    public static ProviderWallet anyProviderWallet(){
        return new ProviderWallet();
    }

    public static ProviderWallet createProviderWalletWithAmount(Double mont){
        ProviderWallet aProvider = new ProviderWallet();
        aProvider.setAmount(mont);
        return aProvider;
    }
}
