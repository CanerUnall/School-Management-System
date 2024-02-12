package service;

import config.Scanner_Utils;
import controller.SchoolManagementSystem;
import domain.*;
import domain.Lessons;
import domain.Student;
import domain.SuccessDegree;
import exceptions.StudentNotFoundException;

import repository.ReportRepository;
import repository.StudentRepository;

import javax.swing.*;
import java.util.List;

import java.util.Scanner;

public class StudentMethods implements Login<Student>, SameOperations {

    private final Scanner scanner;
    private final StudentRepository studentRepository;
    private final LessonMethods lessonMethods;

    public StudentMethods(Scanner scanner, StudentRepository studentRepository, LessonMethods lessonMethods) {
        this.scanner = scanner;
        this.studentRepository = studentRepository;
        this.lessonMethods = lessonMethods;
    }


    @Override
    public Student find(int id) {
        try {
            Student foundStudent = studentRepository.find(id);
            if (foundStudent != null) {

                return foundStudent;
            } else {
                throw new StudentNotFoundException("Student not found by id : " + id);
            }
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    @Override
    public void login() {
        boolean girisBasarili = false;
        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem();
        do {
            System.out.println("Please enter student Id!");
            int studentId = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();

            Student foundedStudent = find(studentId);

            if (foundedStudent != null) {

                System.out.println("Enter the password of the student...");
                String inputPassword = scanner.nextLine();

                if (foundedStudent.getPassword().equals(inputPassword)) {
                    girisBasarili = true;
                    System.out.println("Login successful!");
                    schoolManagementSystem.studentPage(foundedStudent);
                } else {
                    System.out.println("Wrong password!...");
                    System.out.println("Enter 't' to try again, 'c' to exit: ");
                    char secim = scanner.next().charAt(0);
                    scanner.nextLine();

                    if (secim == 'c' || secim == 'C') {
                        girisBasarili = true;
                        System.out.println("Signing out....");
                    }
                }

            }
        } while (!girisBasarili);
    }


    @Override
    public void addSomeoneInfo() {

        System.out.println("Please enter the name of the student you want to add ");
        String name = scanner.nextLine().trim();
        System.out.println("Please enter the surname of the student you want to add ");
        String surName = scanner.nextLine().trim();
        System.out.println("Please enter the password of the student you want to add : ");
        String password = scanner.nextLine().trim();
        System.out.println("Please enter the address of the student you want to add : ");
        String address = scanner.nextLine().trim();
        System.out.println("Please enter the phone number of the student you want to add :  ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please enter the total payment of student");
        double payment = Scanner_Utils.doubleScanner(scanner);
        scanner.nextLine();
        boolean sinifBelirleme = false;
        Grades stdgrades = null;
        do {
            System.out.println("Which grade would you like to enroll in");
            int sinif = Scanner_Utils.intScanner(scanner);//
            scanner.nextLine();

            if (sinif > 0 && sinif < 6) {


                switch (sinif) {
                    case 1:
                        stdgrades = Grades.GRADE1;
                        sinifBelirleme = true;
                        break;
                    case 2:
                        stdgrades = Grades.GRADE2;
                        sinifBelirleme = true;
                        break;
                    case 3:
                        stdgrades = Grades.GRADE3;
                        sinifBelirleme = true;
                        break;
                    case 4:
                        stdgrades = Grades.GRADE4;
                        sinifBelirleme = true;
                        break;
                    case 5:
                        stdgrades = Grades.GRADE5;
                        sinifBelirleme = true;
                        break;
                    default:
                        stdgrades = null;
                        break;
                }

            } else {
                System.out.println("Please enter valid class info");
            }

        } while (!sinifBelirleme);

        System.out.println("Please enter the last year average of the student you want to add: ");
        double lastYearGradeAvg = Scanner_Utils.doubleScanner(scanner);
        scanner.nextLine();
        int studentID;
        if (getAllStudents() != null) {
            studentID = Student.getStudentRegistrationNumber() + getAllStudents().size();
        } else {
            studentID = Student.getStudentRegistrationNumber();
        }

        System.out.println("Student Id : " + studentID);

        Student student = new Student(name, surName, password, address,
                phoneNumber, UserRol.STUDENT, studentID, stdgrades, lastYearGradeAvg, payment);

        setStudentPercentDiscount(student, lastYearGradeAvg);
        // burada obje oluşturuldu ve alttaki method yardımıyla öğrenci eklendi
        studentRepository.addRepoSomeoneInfo(student);

    }


    @Override
    public void removeSomeoneInfo() {

        System.out.println("Please enter the ID of the student you want to delete.");
        int id = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();
        if (find(id) != null) {
            studentRepository.removeRepoSomeoneInfo(find(id));
            System.out.println("The deletion process was completed successfully.");
        } else {
            System.out.println("Student not found !");
        }

    }


    @Override
    public void updateSomeoneInfo() {

        System.out.println("Öğrencinin id'sini giriniz...");
        int studentId = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();
        Student studentToUpdate = find(studentId);

        if (studentToUpdate != null) {

            System.out.println("Güncellenecek bilgiyi seçiniz : ");
            boolean update = false;
            do {
                System.out.print("1. Address\n2. Class\n3. Payment\n4. Note\nYour Choice : ");

                int choice = Scanner_Utils.intScanner(scanner);
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Please Enter New Adress : ");
                        String newAddress = scanner.nextLine();
                        studentToUpdate.setAddress(newAddress);
                        studentRepository.updateAdressInfo(studentToUpdate, newAddress);
                        update = true;
                        break;
                    case 2:
                        System.out.println("Please Enter New Grade :");
                        for (Grades grades : Grades.values()) {
                            System.out.println(grades.name());
                        }
                        int gradeChoice = Scanner_Utils.intScanner(scanner);
                        scanner.nextLine();
                        Grades newGrade = Grades.values()[gradeChoice - 1];
                        studentToUpdate.setGrade(newGrade);
                        studentRepository.updateClassInfo(studentToUpdate, newGrade);
                        update = true;
                        break;
                    case 3:
                        System.out.println("Please Enter New Payment: ");
                        double newFee = Scanner_Utils.doubleScanner(scanner);
                        scanner.nextLine();
                        studentToUpdate.setPayment(newFee);
                        studentRepository.updateFeeInfo(studentToUpdate, newFee);
                        update = true;
                        break;
                    case 4:
                        updateStudentNote(studentToUpdate);
                        update = true;
                        break;
                    default:
                        System.out.println("Invalid Selection!");
                }
            } while (!update);
            System.out.println("Student update successful");
        } else {
            System.out.println("The Student you were looking for with " + studentId + " could not be found");
        }

    }

    @Override
    public void getSomeoneInfo(int id) {

        studentRepository.getRepoSomeoneInfo(id);

    }


    public void updateStudentNote(Student studentToUpdate) {

        System.out.println("Which lesson's Note do you want to update?");

        int i = 1;      //Secim yapilacak ders listesini donguye sokup  dersleri alt alta yazdirdim.
        for (Lessons each : studentToUpdate.getAllLessons()) {
            System.out.println(i + ". " + each.getName());   //  1.( ders ismi ) seklinde console`a yazdirdim
            i++;
        }
        int selected = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();
        Lessons lessonChoice = studentToUpdate.getAllLessons().get(selected - 1);

        if (studentToUpdate.getAllLessons().contains(lessonChoice)) {

            System.out.println("Please Enter New Note: ");
            int newNote = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();
            for (Lessons lessons : studentToUpdate.getAllLessons()) {
                if (lessons.getName().name().equals(lessonChoice.getName().name())) {
                    lessons.setStudentNote(newNote);
                    setStudentThisYearAvg(studentToUpdate);
                    studentRepository.updateLessonNoteInfo(studentToUpdate, lessonChoice, newNote);
                    lessons.setLessonSuccessDegree(setAndReturnSuccessDegree(studentToUpdate, lessons, newNote));
                }

            }
            System.out.println("Student Note Information Updated !");
        } else {
            System.out.println("Student does not have this lesson");
        }

    }


    public SuccessDegree setAndReturnSuccessDegree(Student student, Lessons lessons, int not) {
        //Bu method yukarıdaki methoda yardımcı olarak oluşturuldu.

        if (not >= 80 && not < 101) {
            studentRepository.updateSuccessDegreeInfo(student, lessons, SuccessDegree.A);
            return SuccessDegree.A;
        } else if (not >= 60 && not < 80) {
            studentRepository.updateSuccessDegreeInfo(student, lessons, SuccessDegree.B);
            return SuccessDegree.B;
        } else if (not >= 40 && not < 60) {
            studentRepository.updateSuccessDegreeInfo(student, lessons, SuccessDegree.C);
            return SuccessDegree.C;

        } else if (not >= 20 && not < 40) {
            studentRepository.updateSuccessDegreeInfo(student, lessons, SuccessDegree.D);
            return SuccessDegree.D;
        } else if (not >= 0 && not < 20) {
            studentRepository.updateSuccessDegreeInfo(student, lessons, SuccessDegree.F);
            return SuccessDegree.F;
        }

        return null;

    }


    public void setStudentPercentDiscount(Student student, double lastYearGradeAvg) {

        if (lastYearGradeAvg > 90) {
            student.setPercentDiscount(20);

        } else if (lastYearGradeAvg > 80) {
            student.setPercentDiscount(10);
        } else if (lastYearGradeAvg > 70) {
            student.setPercentDiscount(5);
        }
    }

    public List<Student> getAllStudents() {

        return studentRepository.getAllStudents();

    }

    public void setStudentThisYearAvg(Student student) {

        int totalLessonNote = 0;
        for (Lessons lessons : student.getAllLessons()) {
            totalLessonNote += lessons.getStudentNote();
        }
        int thisYear = totalLessonNote / student.getAllLessons().size();

        student.setThisYearGradeAvg(thisYear);
        studentRepository.updateRepoThisYearGradeAvg(student, student.getThisYearGradeAvg());

    }

}
