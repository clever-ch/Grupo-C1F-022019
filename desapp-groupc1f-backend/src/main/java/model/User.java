package model;

import constants.RegisterType;
import constants.UserType;
import utilities.Entity;

public abstract class User extends Entity {
	private RegisterType typeRegister;
	private Account acount;
	private UserType userType;
	private Wallet aWallet = new ProviderWallet();
	private String tokenTPA;	//(identificador logueo Google)
	
	
	public RegisterType getTypeRegister() {
		return typeRegister;
	}
	
	public void setTypeRegister(RegisterType typeRegister) {
		this.typeRegister = typeRegister;
	}

	public Account getAcount() {
		return acount;
	}

	public void setAcount(Account acount) {
		this.acount = acount;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Wallet getaWallet() {
		return aWallet;
	}

	public void setaWallet(Wallet aWallet) {
		this.aWallet = aWallet;
	}

	public String getTokenTPA() {
		return tokenTPA;
	}

	public void setTokenTPA(String tokenTPA) {
		this.tokenTPA = tokenTPA;
	}
}
