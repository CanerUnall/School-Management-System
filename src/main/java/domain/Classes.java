package domain;

import java.util.ArrayList;
import java.util.List;

public class Classes {

    private static List<Classes> allClasses = new ArrayList<>();

    private List<Teacher> allTeachers = new ArrayList<>();
    private List<Student> allStudents = new ArrayList<>();

    private Grades grade;

    private final int capacity;

    public Classes(List<Teacher> allTeachers, List<Student> allStudents, Grades grade) {
        this.allTeachers = allTeachers;
        this.allStudents = allStudents;
        this.grade = grade;
        this.capacity=20;
    }

    public List<Teacher> getAllTeachers() {
        return allTeachers;
    }

    public void setAllTeachers(List<Teacher> allTeachers) {
        this.allTeachers = allTeachers;
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(List<Student> allStudents) {
        this.allStudents = allStudents;
    }

    public static List<Classes> getAllClasses() {
        return allClasses;
    }

    public static void setAllClasses(List<Classes> allClasses) {
        Classes.allClasses = allClasses;
    }

    public Grades getGrade() {
        return grade;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "allTeachers=" + allTeachers +
                ", allStudents=" + allStudents +
                ", grade=" + grade +
                ", capacity=" + capacity +
                '}';
    }
}
