package model;

import constants.*;

public abstract class User {
	RegisterType typeRegister;
	Account acount;
	UserType userType;
	Wallet aWallet;
	String tokenTPA; //(identificador logueo Google)
}
