package domain;

public class Person {
    private String name;
    private String surName;
    private String password;
    private String address;
    private String phoneNumber;
    UserRol role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRol getRole() {
        return role;
    }

    public void setRole(UserRol role) {
        this.role = role;
    }

    public Person(String name, String surName, String password, String address, String phoneNumber, UserRol role) {
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Person() {
    }
}
