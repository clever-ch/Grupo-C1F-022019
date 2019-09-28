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
        newAccount.setUserName(username);

        return newAccount;
    }

	public static Account createAccountWithName(String name) {
		Account newAccount = new Account();
		newAccount.setName(name);
		
		return newAccount;
	}

	public static Account createAccountWithSurname(String surname) {
		Account newAccount = new Account();
		newAccount.setSurname(surname);
		
		return newAccount;
	}

	public static Account createAccountWithLocation(String location) {
		Account newAccount = new Account();
		newAccount.setLocation(location);
		
		return newAccount;
	}

	public static Account createAccountWithPhone(int i) {
		Account newAccount = new Account();
		newAccount.setPhone(i);
		
		return newAccount;
	}

	public static Account createAccountWithEmailValid(String email) {
		Account newAccount = new Account();
		newAccount.setEmail(email);
		
		return newAccount;
	}

	public static Account createAccountWithDirection(String dir) {
		Account newAccount = new Account();
		newAccount.setDirection(dir);
		
		return newAccount;
	}

}