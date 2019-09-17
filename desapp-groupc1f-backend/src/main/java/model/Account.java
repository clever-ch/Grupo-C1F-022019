package model;

public class Account {

    public String userName;
    private String name;
    private String surname;
    private String email;
    private char phone;
    private char location;
    private String direction;

    public Account(String userName, String name, String surname, String email, char phone, char location, String direction) {
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.direction = direction;
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

    public char getPhone() {
        return phone;
    }

    public void setPhone(char phone) {
        this.phone = phone;
    }

    public char getLocation() {
        return location;
    }

    public void setLocation(char location) {
        this.location = location;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
