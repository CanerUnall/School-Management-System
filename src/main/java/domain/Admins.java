package domain;

public class Admins extends Teacher {
    private final static int adminRegistrationNumber = 10000;
    private int adminID;

    public static int getAdminRegistrationNumber() {
        return adminRegistrationNumber;
    }


    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public Admins(String name, String surName, String password, String address, String phoneNumber,
                  UserRol role, double salary, String branch, int teacherID, int adminID) {
        super(name, surName, password, address, phoneNumber, role, salary, branch, teacherID);
        this.adminID = adminID;
    }

    public Admins() {

    }

    @Override
    public String toString() {
        return "Admins{" +
                "adminID=" + adminID +
                '}';
    }
}
