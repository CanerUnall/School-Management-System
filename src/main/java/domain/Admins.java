package domain;

public class Admins extends Teacher{
    private int adminID;

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
}
