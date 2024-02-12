package service;

import config.Scanner_Utils;
import domain.Grades;
import domain.Lessons;
import domain.Student;

import repository.ReportRepository;
import repository.StudentRepository;


import java.util.Scanner;

public class ReportMethods {
    private final Scanner scanner;
    private final ReportRepository reportRepository;
    private final StudentRepository studentRepository;
    private final StudentMethods studentMethods;

    public ReportMethods(Scanner scanner, ReportRepository reportRepository, StudentRepository studentRepository, StudentMethods studentMethods) {
        this.scanner = scanner;
        this.reportRepository = reportRepository;
        this.studentRepository = studentRepository;
        this.studentMethods = studentMethods;
    }


    public void showLessonSuccess() {

        System.out.println("Which course grade will you enter");
        System.out.println("1. MATHS");
        System.out.println("2. ENGLISH");
        System.out.println("3. HISTORY");
        System.out.println("4.TURKISH");
        System.out.println("5.PHYSICAL");
        System.out.println("6.CHEMICAL");
        System.out.println("7.GEOGRAPHY");
        System.out.println("8.IT");
        System.out.println("9.SPORTS");
        System.out.println("10.BIOLOGY");

        // burada 1 den 10 a kadar seçim yaptırılıp girmek istenen ders başarısı gösterilecek
        System.out.print("Choose : ");
        boolean lessonChoose = false;
        do {

            int secim = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();

            if (secim > 0 && secim < 11) {
                switch (secim) {
                    case 1:
                        reportRepository.getLessonSuccess("MATHS");
                        lessonChoose = true;
                        break;
                    case 2:
                        reportRepository.getLessonSuccess("ENGLISH");
                        lessonChoose = true;
                        break;
                    case 3:
                        reportRepository.getLessonSuccess("HISTORY");
                        lessonChoose = true;
                        break;
                    case 4:
                        reportRepository.getLessonSuccess("TURKISH");
                        lessonChoose = true;
                        break;
                    case 5:
                        reportRepository.getLessonSuccess("PHYSICAL");
                        lessonChoose = true;
                        break;
                    case 6:
                        reportRepository.getLessonSuccess("CHEMICAL");
                        lessonChoose = true;
                        break;
                    case 7:
                        reportRepository.getLessonSuccess("GEOGRAPHY");
                        lessonChoose = true;
                        break;
                    case 8:
                        reportRepository.getLessonSuccess("IT");
                        lessonChoose = true;
                        break;
                    case 9:
                        reportRepository.getLessonSuccess("SPORTS");
                        lessonChoose = true;
                        break;
                    case 10:
                        reportRepository.getLessonSuccess("BIOLOGY");
                        lessonChoose = true;
                        break;
                    default:
                        System.out.println("Please enter valid lesson number");
                        break;
                }

            } else System.out.println("Please enter valid lesson number");


        } while (!lessonChoose);//??

    }


    public void showClassSuccess() {

        System.out.println("Which class do you want to see success?");
        int x = 1;
        for (Grades grades : Grades.values()) {
            System.out.println(x + " " + grades.name());
            x++;
        }
        int gradeChoice = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();


        try {
            // Kullanıcının girdiği sınıf ismini Grades enum değerine dönüştürüyoruz
            Grades selectedGrade = Grades.values()[gradeChoice - 1];

            reportRepository.getClassSuccess(selectedGrade);

        } catch (IllegalArgumentException e) {
            System.err.println("Invalid grade name. Please enter a valid grade name.");
        }

    }


    public void showStudentSuccess() {

        System.out.println("Enter the ID of the student whose success you want to see.");
        int id = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();
        Student student = studentMethods.find(id);
        if (student != null) {
            System.out.println(student.getName() + " " + student.getSurName() + " all courses and grades of the named student are as follows:");
            for (Lessons eachLesson : student.getAllLessons()) {
                System.out.println(eachLesson.getName().name() + " " + eachLesson.getStudentNote() + " " + eachLesson.getLessonSuccessDegree().name());
            }
        }

    }


    public void showStudentRank() {

        studentRepository.getStudentThisYearGradeAvg();

    }


}


