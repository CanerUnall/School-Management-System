package domain;

public class Teacher extends Person{
    private static int teacherRegistrationNumber = 1000;
    private double salary;
    private String branch;

    private  int teacherID;

    public static int getTeacherRegistrationNumber() {
        return teacherRegistrationNumber;
    }

    public static void setTeacherRegistrationNumber(int teacherRegistrationNumber) {
        Teacher.teacherRegistrationNumber = teacherRegistrationNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }



    public Teacher(String name, String surName, String password, String address, String phoneNumber,
                   UserRol role, double salary, String branch, int teacherID) {
        super(name, surName, password, address, phoneNumber, role);
        this.salary = salary;
        this.branch = branch;
        this.teacherID = teacherID;
    }

    public Teacher() {}

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + salary +
                ", branch='" + branch + '\'' +
                ", teacherID=" + teacherID +
                '}';
    }
}