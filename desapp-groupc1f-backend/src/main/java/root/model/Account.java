package root.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Service;

import root.utilities.Entity;

@javax.persistence.Entity
public class Account extends Entity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
    private String userName;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
    private String name;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
    private String surname;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
    private String email;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
    private String phone = "0";
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
    private String location;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
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
		return this.phone.equals("");
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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