package service;


import config.Scanner_Utils;
import domain.Grades;

import domain.Lessons;
import repository.ClassesRepository;

import java.util.Scanner;

public class ClassesMethods {

    private final ClassesRepository classesRepository;
    private final Scanner scanner;
    private final LessonMethods lessonMethods;

    public ClassesMethods(ClassesRepository classesRepository, Scanner scanner, LessonMethods lessonMethods) {

        this.classesRepository = classesRepository;
        this.scanner = scanner;
        this.lessonMethods = lessonMethods;
    }

    public void showAllClassNotes() {

        System.out.println("Please enter which class's grade you would like to see.");
        int x= 1;
        for (Grades grades : Grades.values()) {
            System.out.println(x+" "+grades.name());
            x++;
        }
        int gradeChoice = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();
        Grades grade = Grades.values()[gradeChoice - 1];
        System.out.println("Select which lesson grade you want to see.");
        int i = 1;      //Secim yapilacak ders listesini donguye sokup  dersleri alt alta yazdirdim.
        for (Lessons each : lessonMethods.getAllLessonsList()) {
            System.out.println(i + ". " + each.getName());   //  1.( ders ismi ) seklinde console`a yazdirdim
            i++;
        }
        int selected = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();
        Lessons lessonChoice = lessonMethods.getAllLessonsList().get(selected-1);

        String lessonName = lessonChoice.getName().name();
        classesRepository.getAllClassNotes(grade, lessonName);

    }

    public void showAllStudentInfo() {

        System.out.println("Please Enter Grade :");
        int x = 1;
        for (Grades grades : Grades.values()) {
            System.out.println(x+" "+grades.name());
            x++;
        }
        int gradeChoice = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();
        Grades grades = Grades.values()[gradeChoice - 1];

        classesRepository.getAllClassInfo(grades);

    }

}
