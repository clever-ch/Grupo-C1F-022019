package root.model;

import root.utilities.Entity;

@javax.persistence.Entity
public class Account extends Entity {

    private String userName;
    private String name;
    private String surname;
    private String email;
    private int phone = 0;
    private String location;
    private String direction;
    
    public boolean isValidAccount() {
    	return !isEmptyUserName()
    			& !isEmptyName()
    			& !isEmptySurname()
    			& hasAEmailValid()
    			& !isEmptyPhone()
    			& hasValidLocation()
    			& hasValidDirection();
    }

    public boolean hasValidDirection() {
    	return this.direction != "" | this.direction != null;
	}

	public boolean hasValidLocation() {
		return this.location != "" | this.location != null;
	}

	public boolean isEmptyPhone() {
		return this.phone == 0;
	}

	public boolean hasAEmailValid() {
		return this.email != "" | this.email != null;
	}

	public boolean isEmptySurname() {
		return this.surname == "" | this.surname == null;
	}

	public boolean isEmptyName() {
		return this.name == "" | this.name == null;
	}

	public boolean isEmptyUserName() {
		return this.userName == "" | this.userName == null;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}