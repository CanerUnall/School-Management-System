package domain;

public class Teacher extends Person{
    private double salary;
    private String branch;

    private  int teacherID;

    private Lessons lesson;

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

    public Lessons getLesson() {
        return lesson;
    }

    public void setLesson(Lessons lesson) {
        this.lesson = lesson;
    }

    public Teacher(String name, String surName, String password, String address, String phoneNumber,
                   UserRol role, double salary, String branch, int teacherID) {
        super(name, surName, password, address, phoneNumber, role);
        this.salary = salary;
        this.branch = branch;
        this.teacherID = teacherID;
    }

    public Teacher() {
    }
}
