package root.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import root.constants.RegisterType;
import root.constants.UserType;
import root.utilities.Entity;

@MappedSuperclass
public abstract class User extends Entity {
	private RegisterType typeRegister;
	
	@OneToOne
	private Account acount;
	private UserType userType;
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

	public String getTokenTPA() {
		return tokenTPA;
	}

	public void setTokenTPA(String tokenTPA) {
		this.tokenTPA = tokenTPA;
	}
}
