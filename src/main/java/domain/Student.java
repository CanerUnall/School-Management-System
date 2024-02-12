package domain;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int studentRegistrationNumber = 100;
    private int generalRank;
    private int studentID;
    private Grades grade;
    private double lastYearGradeAvg;
    private double thisYearGradeAvg;

    private double payment;

    private double totalPrice;
    private int lessonCredit;
    private List<Lessons> allLessons;

    private Integer percentDiscount = 0;

    public Student() {

    }

    public static int getStudentRegistrationNumber() {
        return studentRegistrationNumber;
    }

    public static void setStudentRegistrationNumber(int studentRegistrationNumber) {
        Student.studentRegistrationNumber = studentRegistrationNumber;
    }

    public Integer getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(Integer discount) {
        this.percentDiscount = discount;
    }

    private List< Attendance> historyAttendance;


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


    public List<Lessons> getAllLessons() {
        return allLessons;
    }

    public void setAllLessons(List<Lessons> allLessons) {
        this.allLessons = allLessons;
    }

    public List<Attendance> getHistoryAttendance() {
        return historyAttendance;
    }

    public void setHistoryAttendance(List<Attendance> historyAttendance) {
        this.historyAttendance = historyAttendance;
    }

    public int getGeneralRank() {
        return generalRank;
    }

    public void setGeneralRank(int generalRank) {
        this.generalRank = generalRank;
    }

    public Student(String name, String surName, String password, String address, String phoneNumber,
                   UserRol role, int studentID, Grades grade, double lastYearGradeAvg, double payment) {
        super(name, surName, password, address, phoneNumber, role);
        this.studentID = studentID;
        this.grade = grade;
        this.lastYearGradeAvg = lastYearGradeAvg;
        this.payment = payment;
        this.allLessons = new ArrayList<>();
        this.historyAttendance = new ArrayList<>();
        this.lessonCredit = 20;
        this.totalPrice = 0;
        this.thisYearGradeAvg = 0;
        this.percentDiscount = 1;
        this.generalRank=0;

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
