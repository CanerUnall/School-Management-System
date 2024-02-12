package controller;

import config.Scanner_Utils;
import domain.Admins;
import domain.Student;
import domain.Teacher;
import repository.*;
import service.*;

import java.util.Scanner;

import repository.AdminRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.AdminMethods;
import service.StudentMethods;
import service.TeacherMethods;

public class SchoolManagementSystem {
    private final Scanner scanner = new Scanner(System.in);
    private final ClassesRepository classesRepository = new ClassesRepository();
    private final StudentRepository studentRepository = new StudentRepository();
    private final LessonsRepository lessonsRepository = new LessonsRepository();
    private final TeacherRepository teacherRepository = new TeacherRepository();
    private final ReportRepository reportRepository = new ReportRepository();
    private final AdminRepository adminRepository = new AdminRepository();
    private final AttendanceRepository attendanceRepository = new AttendanceRepository();
    private final FinanceRepository financeRepository = new FinanceRepository(teacherRepository);
    private final FinanceMethods financeMethods = new FinanceMethods(financeRepository);
    private final LessonMethods lessonMethods = new LessonMethods(lessonsRepository, scanner);
    private final StudentMethods studentMethods = new StudentMethods(scanner, studentRepository, lessonMethods);
    private final ClassesMethods classesMethods = new ClassesMethods(classesRepository, scanner, lessonMethods);
    private final TeacherMethods teacherMethods = new TeacherMethods(teacherRepository, scanner);
    private final ReportMethods reportMethods = new ReportMethods(scanner, reportRepository, studentRepository, studentMethods);
    private final AdminMethods adminMethods = new AdminMethods(scanner, adminRepository, teacherMethods);

    public void threads() {

        Thread secondThread = new Thread(() -> {
            studentRepository.createStudentTable();
            teacherRepository.createTeacherTable();
            adminRepository.createAdminTable();
            lessonsRepository.createLessonsTable();
            attendanceRepository.createAttendanceTable();
            adminMethods.addAllAdmin();
            lessonMethods.addAllLesson();
        });

        Thread startToThread = new Thread(this::homePage);

        secondThread.start();
        startToThread.start();

    }

    public void homePage() {

        boolean exit = false;

        while (!exit) {
            System.out.println("========= Welcome to School Management System =========");
            System.out.print("1. Student Operations \n" +
                    "2. Teacher Operations\n" +
                    "3. Admin Operations\n" +
                    "0. Exit\n" +
                    "Enter your choice : ");

            int choice = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentMethods.login();
                    break;
                case 2:
                    teacherMethods.login();
                    break;
                case 3:
                    adminMethods.login();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Good bye...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }

    }

    public void studentPage(Student student) {

        System.out.println("Welcome" + student.getName());
        boolean exit = false;
        int choice;
        while (!exit) {
            System.out.println("\n\n========= Welcome to School Management System =========");
            System.out.println("1. See your own information\n" +
                    "2. See the course schedule\n" +
                    "3. See your course notes\n" +
                    "4. Choose a course\n" +
                    "5. See attendance history\n" +
                    "0. Exit" +
                    "Enter your choice : ");
            choice = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentMethods.getSomeoneInfo(student.getStudentID());
                    break;
                case 2:
                    lessonMethods.studentSchedule(student);
                    break;
                case 3:
                    lessonMethods.resultLesson(student);
                    break;
                case 4:
                    lessonMethods.selectLesson(student);
                    break;
                case 5:
                    lessonMethods.showStudentAttendance(student);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Good bye...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }

    }

    public void teacherPage(Teacher teacher) {

        System.out.println("\n\nWelcome to our system..." + teacher.getName());
        boolean running = true;

        while (running) {
            System.out.println("========= School Management System =========");
            System.out.println("===Select the part you want to transact wit===");
            System.out.println("1. All student information...");
            System.out.println("2. Student Transactions");
            System.out.println("3. Student Grade Tracking");
            System.out.println("4. Teacher Information and Transactions");
            System.out.println("5. Reporting");
            System.out.println("0. Exit");
            System.out.print("Please select an action: ");

            int choice = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();
            switch (choice) {
                case 1:
                    classesMethods.showAllStudentInfo();
                    break;
                case 2:
                    studentMethods();
                    break;
                case 3:
                    //      1. tum sinifin notlarini gor
                    //      2. ogrenci notunu gir/ duzenle
                    System.out.println("Press 1 to see the lesson notes of the class.");
                    System.out.println("Press 2 to enter the student note and edit it.");
                    System.out.println("Press : ");
                    int choice3 = Scanner_Utils.intScanner(scanner);
                    scanner.nextLine();
                    if (choice3 == 1) {
                        classesMethods.showAllClassNotes();
                    } else if (choice3 == 2) {
                        System.out.println("Öğrencinin id'sini giriniz...");
                        int studentId = Scanner_Utils.intScanner(scanner);
                        scanner.nextLine();
                        Student studentToUpdate = studentMethods.find(studentId);
                        studentMethods.updateStudentNote(studentToUpdate);
                    } else {
                        System.out.println("Make a valid keystroke");
                    }
                    break;
                case 4:
                    System.out.println(teacher);
                    break;
                case 5:
                    reportMethods();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }

    public void adminPage(Admins admins) {

        System.out.println("\n\nWelcome to our system..." + admins.getName());
        boolean running = true;

        while (running) {
            System.out.println("========= School Management System =========");
            System.out.println("===Select the part you want to transact wit===");
            System.out.println("1. All student information...");
            System.out.println("2. Student Transactions");
            System.out.println("3. Student Grade Tracking");
            System.out.println("4. Teacher Information and Transactions");
            System.out.println("5. Reporting");
            System.out.println("6. Department of Finance");
            System.out.println("0. Exit");
            System.out.print("Please select an action: ");

            int choice = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();

            switch (choice) {
                case 1:
                    classesMethods.showAllStudentInfo();
                    break;
                case 2:
                    studentMethods();
                    break;
                case 3:
                    System.out.println("Press 1 to see the lesson notes of the class.");
                    System.out.println("Press 2 to enter the student note and edit it.");
                    System.out.println("Press : ");
                    int choice3 = Scanner_Utils.intScanner(scanner);
                    scanner.nextLine();
                    if (choice3 == 1) {
                        classesMethods.showAllClassNotes();
                    } else if (choice3 == 2) {
                        System.out.println("Öğrencinin id'sini giriniz...");
                        int studentId = Scanner_Utils.intScanner(scanner);
                        scanner.nextLine();
                        Student studentToUpdate = studentMethods.find(studentId);
                        studentMethods.updateStudentNote(studentToUpdate);
                    } else {
                        System.out.println("Make a valid keystroke");
                    }
                    break;
                case 4:
                    teacherMethods();
                    break;
                case 5:
                    reportMethods();
                    break;
                case 6:
                    financeMethods();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }

    }

    private void studentMethods() {
        System.out.println("Student Operation Menu");
        boolean exit = false;
        while (!exit) {
            System.out.println("===Student Operations===");
            System.out.println("1. Add a new student");
            System.out.println("2. Delete Student By ID");
            System.out.println("3. Update Student By ID");
            System.out.println("4. Find Student");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentMethods.addSomeoneInfo();
                    break;
                case 2:
                    studentMethods.removeSomeoneInfo();
                    break;
                case 3:
                    studentMethods.updateSomeoneInfo();
                    break;
                case 4:
                    System.out.println("Enter student ID to find : ");
                    int studentid = Scanner_Utils.intScanner(scanner);
                    scanner.nextLine();
                    studentMethods.getSomeoneInfo(studentid);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
                    break;
            }
        }
    }

    private void teacherMethods() {
        System.out.println("Teacher Operation Menu");
        boolean exit = false;
        while (!exit) {
            System.out.println("===Teacher Operations/Informations===");
            System.out.println("1. Add a new Teacher");
            System.out.println("2. Delete Teacher By ID");
            System.out.println("3. Update Teacher By ID");
            System.out.println("4. Find Teacher");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();

            switch (choice) {

                case 1:
                    teacherMethods.addSomeoneInfo();
                    break;
                case 2:
                    teacherMethods.removeSomeoneInfo();
                    break;
                case 3:
                    teacherMethods.updateSomeoneInfo();
                    break;
                case 4:
                    System.out.println("Enter teacher ID to find : ");
                    int teacherId = Scanner_Utils.intScanner(scanner);
                    scanner.nextLine();
                    teacherMethods.getSomeoneInfo(teacherId);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
                    break;
            }
        }
    }

    private void reportMethods() {
        System.out.println("Report Operation Menu");
        boolean exit = false;
        while (!exit) {

            System.out.println("===Report Operations===");
            System.out.println("1. show success according to course");
            System.out.println("2. show class success");
            System.out.println("3. show student success");
            System.out.println("4. Show students according to their success");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reportMethods.showLessonSuccess();
                    break;
                case 2:
                    reportMethods.showClassSuccess();
                    break;
                case 3:
                    reportMethods.showStudentSuccess();
                    break;
                case 4:
                    reportMethods.showStudentRank();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
                    break;
            }
        }
    }

    private void financeMethods() {
        System.out.println("Finance Operation Menu");
        boolean exit = false;
        while (!exit) {

            System.out.println("===Finance Operations===");
            System.out.println("1. Show Income Table");
            System.out.println("2. Show Expense Table");
            System.out.println("3. Show Payment Tracking Table");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();

            switch (choice) {
                case 1:
                    financeMethods.showIncomeTable();
                    break;
                case 2:
                    financeMethods.showExpenseTable();
                    break;
                case 3:
                    financeMethods.showPaymentTrackingTable();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
                    break;
            }
        }
    }

}