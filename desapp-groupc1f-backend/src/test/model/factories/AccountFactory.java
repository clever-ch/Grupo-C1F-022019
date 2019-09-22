package model.factories;

import model.Account;

public class AccountFactory {

    public static Account anyAccount(){
        return new Account();
    }

    public static Account createAccountComplete(String username, String name, String surname, String email, int phone,
                                                String loc, String dir){
        Account newAccount = new Account();
        newAccount.setSurname(surname);
        newAccount.setDirection(dir);
        newAccount.setEmail(email);
        newAccount.setName(name);
        newAccount.setPhone(phone);
        newAccount.setLocation(loc);
        newAccount.setUserName(username);

        return newAccount;
    }


    public static Account createAccountWithUsername(String username){
        Account newAccount = new Account();
        newAccount.setSurname(username);

        return newAccount;
    }
}