package domain;

import java.util.HashMap;

public class Student extends Person {


    private int studentID;
    private Grades grade;
    private double lastYearGradeAvg;
    private double thisYearGradeAvg;

    private double payment;

    private double totalPrice;
    private int lessonCredit;
    private HashMap<Integer, Lessons> allLessons;

    private Integer percentDiscount = 1;

    public Student() {

    }

    public Integer getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(Integer discount) {
        this.percentDiscount = discount;
    }

    private HashMap<Integer, Attendance> historyAttendance;


    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Grades getGrade() {
        return grade;
    }

    public double getThisYearGradeAvg() {
        return thisYearGradeAvg;
    }

    public void setThisYearGradeAvg(double thisYearGradeAvg) {
        this.thisYearGradeAvg = thisYearGradeAvg;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }

    public double getLastYearGradeAvg() {
        return lastYearGradeAvg;
    }

    public void setLastYearGradeAvg(double lastYearGradeAvg) {
        this.lastYearGradeAvg = lastYearGradeAvg;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getLessonCredit() {
        return lessonCredit;
    }

    public void setLessonCredit(int lessonCredit) {
        this.lessonCredit = lessonCredit;
    }


    public HashMap<Integer, Lessons> getAllLessons() {
        return allLessons;
    }

    public void setAllLessons(HashMap<Integer, Lessons> allLessons) {
        this.allLessons = allLessons;
    }

    public HashMap<Integer, Attendance> getHistoryAttendance() {
        return historyAttendance;
    }

    public void setHistoryAttendance(HashMap<Integer, Attendance> historyAttendance) {
        this.historyAttendance = historyAttendance;
    }

    public Student(String name, String surName, String password, String address, String phoneNumber,
                   UserRol role, int studentID, Grades grade, double lastYearGradeAvg, double payment) {
        super(name, surName, password, address, phoneNumber, role);
        this.studentID = studentID;
        this.grade = grade;
        this.lastYearGradeAvg = lastYearGradeAvg;
        this.payment = payment;
        this.allLessons = new HashMap<>();
        this.historyAttendance = new HashMap<>();
        this.lessonCredit = 20;
        this.totalPrice = 0;
        this.thisYearGradeAvg = 0;
        this.percentDiscount = 1;

    }


    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", grade=" + grade +
                ", lastYearGradeAvg=" + lastYearGradeAvg +
                ", thisYearGradeAvg=" + thisYearGradeAvg +
                ", payment=" + payment +
                ", totalPrice=" + totalPrice +
                ", lessonCredit=" + lessonCredit +
                ", allLessons=" + allLessons +
                ", historyAttendance=" + historyAttendance +
                '}';


    }


}
