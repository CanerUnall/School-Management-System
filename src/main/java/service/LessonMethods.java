package service;

import config.Scanner_Utils;
import controller.SchoolManagementSystem;
import domain.*;
import repository.LessonsRepository;
import repository.StudentRepository;
import repository.TeacherRepository;

import java.util.*;

public class LessonMethods {
    static List<Lessons> allLessons = new ArrayList<>();
    private final LessonsRepository lessonsRepository;
    private final Scanner scanner;

    public LessonMethods(LessonsRepository lessonsRepository, Scanner scanner) {
        this.lessonsRepository = lessonsRepository;
        this.scanner = scanner;

    }

    public void addAllLesson() {

        if (lessonsRepository.getAllLessons().size() < 10) {
            allLessons.add(new Lessons(LessonNames.IT, setLessonTeacher(LessonNames.IT.name()), 2, 50, "Monday"));
            allLessons.add(new Lessons(LessonNames.TURKISH, setLessonTeacher(LessonNames.TURKISH.name()), 4, 60, "Tuesday"));
            allLessons.add(new Lessons(LessonNames.BIOLOGY, setLessonTeacher(LessonNames.BIOLOGY.name()), 4, 60, "Wednesday"));
            allLessons.add(new Lessons(LessonNames.ENGLISH, setLessonTeacher(LessonNames.ENGLISH.name()), 4, 55, "Thursday"));
            allLessons.add(new Lessons(LessonNames.CHEMICAL, setLessonTeacher(LessonNames.CHEMICAL.name()), 4, 55, "Friday"));
            allLessons.add(new Lessons(LessonNames.GEOGRAPHY, setLessonTeacher(LessonNames.GEOGRAPHY.name()), 3, 40, "Wednesday"));
            allLessons.add(new Lessons(LessonNames.HISTORY, setLessonTeacher(LessonNames.HISTORY.name()), 3, 35, "Thursday"));
            allLessons.add(new Lessons(LessonNames.MATHS, setLessonTeacher(LessonNames.MATHS.name()), 4, 55, "Monday"));
            allLessons.add(new Lessons(LessonNames.PHYSICAL, setLessonTeacher(LessonNames.PHYSICAL.name()), 4, 50, "Tuesday"));
            allLessons.add(new Lessons(LessonNames.SPORTS, setLessonTeacher(LessonNames.SPORTS.name()), 2, 30, "Monday"));


            for (Lessons lesson : allLessons) {
                lessonsRepository.addRepoLessons(lesson);
            }
        }

    }

    private Teacher setLessonTeacher(String lessonName) {
        TeacherRepository teacherRepository = new TeacherRepository();
        TeacherMethods teacherMethods = new TeacherMethods(teacherRepository, scanner);
        List<Teacher> allTeacher = teacherMethods.getAllTeacher();
        for (Teacher teacher : allTeacher) {
            if (teacher.getBranch().equalsIgnoreCase(lessonName)) {
                return teacher;
            }
        }

        return null;
    }


    public void studentSchedule(Student student) {

        List<Lessons> monday = new ArrayList<>();
        List<Lessons> tuesday = new ArrayList<>();
        List<Lessons> wednesday = new ArrayList<>();
        List<Lessons> thursday = new ArrayList<>();
        List<Lessons> friday = new ArrayList<>();

        for (Lessons lesson : student.getAllLessons()) {
            switch (lesson.getDay()) {
                case "Monday":
                    monday.add(lesson);
                    break;
                case "Tuesday":
                    tuesday.add(lesson);
                    break;
                case "Wednesday":
                    wednesday.add(lesson);
                    break;
                case "Thursday":
                    thursday.add(lesson);
                    break;
                case "Friday":
                    friday.add(lesson);
                    break;
                default:
                    System.out.println("non-valid day");
                    break;
            }
        }

        System.out.print("\nLessons of Monday: ");
        for (Lessons lesson : monday) {
            System.out.print(lesson.getName().name() + " ");
        }
        System.out.print("\nLessons of Tuesday: ");
        for (Lessons lesson : tuesday) {
            System.out.print(lesson.getName().name() + " ");
        }
        System.out.print("\nLessons of Wednesday: ");
        for (Lessons lesson : wednesday) {
            System.out.print(lesson.getName().name() + " ");
        }
        System.out.print("\nLessons of Thursday: ");
        for (Lessons lesson : thursday) {
            System.out.print(lesson.getName().name() + " ");
        }
        System.out.print("\nLessons of Friday: ");
        for (Lessons lesson : friday) {
            System.out.print(lesson.getName().name() + " ");

        }
    }

    public void resultLesson(Student student) {

        for (Lessons lessons : student.getAllLessons()) {
            System.out.println(lessons.getName() + " " + lessons.getStudentNote() + " " + lessons.getLessonSuccessDegree());
        }

    }

    public void selectLesson(Student student) {

        if (student.getLessonCredit() > 2) {
            List<Lessons> lessonsList = lessonsRepository.getAllLessons();
            StudentRepository studentRepository = new StudentRepository();

            System.out.println("*** LESSONS ***");
            System.out.println();

            int i = 1;      //Secim yapilacak ders listesini donguye sokup  dersleri alt alta yazdirdim.

            for (Lessons each : lessonsList) {
                System.out.println(i + ". " + each.getName());   //  1.( ders ismi ) seklinde console`a yazdirdim
                i++;
            }

            System.out.println();


            boolean a = true;
            while (a) {
                System.out.println("Please make your lesson/lessons selection");
                int chosen = Scanner_Utils.intScanner(scanner);
                scanner.nextLine();
                switch (chosen) {
                    //OGRENCININ TOTAL PRICE'I UPDATE EDEN METOD CAGIRILACAK
                    case 1:
                        chooseLesson(1, student, lessonsList, studentRepository);
                        break;
                    case 2:
                        chooseLesson(2, student, lessonsList, studentRepository);
                        break;
                    case 3:
                        chooseLesson(3, student, lessonsList, studentRepository);
                        break;
                    case 4:
                        chooseLesson(4, student, lessonsList, studentRepository);
                        break;
                    case 5:
                        chooseLesson(5, student, lessonsList, studentRepository);
                        break;
                    case 6:
                        chooseLesson(6, student, lessonsList, studentRepository);
                        break;
                    case 7:
                        chooseLesson(7, student, lessonsList, studentRepository);
                        break;
                    case 8:
                        chooseLesson(8, student, lessonsList, studentRepository);
                        break;
                    case 9:
                        chooseLesson(9, student, lessonsList, studentRepository);
                        break;
                    case 10:
                        chooseLesson(10, student, lessonsList, studentRepository);
                        break;
                    default:
                        System.out.println("You made an invalid keystroke");
                        break;

                }
                if (student.getLessonCredit() > 2) {
                    boolean b = true;
                    while (b) {
                        System.out.println("Would you like to continue choosing? \n" +
                                "Select Y or N ");

                        String chosen2 = scanner.next();
                        if (chosen2.equalsIgnoreCase("Y")) {
                            b = false;
                            a = true;
                        } else if (chosen2.equalsIgnoreCase("N")) {
                            b = false;
                            a = false;
                        } else {
                            System.out.println("Please make a valid keystroke");
                            scanner.nextLine();
                        }
                    }
                }

            }

            System.out.println("Your course selection process has been completed.");

        } else {
            System.out.println("You dont have enough lesson credit");
        }
    }

    private void chooseLesson(int choice, Student student, List<Lessons> lessonsList, StudentRepository studentRepository) {
        boolean twice = false;
        for (Lessons lessons : student.getAllLessons()) {
            if (lessons.getName().name().equals(lessonsList.get(choice - 1).getName().name())) {
                twice = true;
            }
        }
        if (twice==false) {
            student.setLessonCredit(student.getLessonCredit() - lessonsList.get(choice - 1).getLessonCredit());
            student.getAllLessons().add(lessonsList.get(choice - 1));
            student.setTotalPrice(student.getTotalPrice() + (lessonsList.get(choice - 1).getLessonFee() * (100 - student.getPercentDiscount()) / 100));
            lessonsRepository.addLessonStudent(student, lessonsList.get(choice - 1));
            studentRepository.updateTotalPriceInfo(student, lessonsList.get(choice - 1).getLessonFee() * (100 - student.getPercentDiscount()) / 100);
            studentRepository.updateStudentLessonCredit(student, student.getLessonCredit());
        }else {
            System.out.println("You can not choice the same lesson twice");
        }
    }

    public void showStudentAttendance(Student student) {


        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Student Name: " + student.getName() + " " + student.getSurName());

        System.out.println("Attendance History:");
        System.out.println("-------------------");

        if (student.getHistoryAttendance() == null) { //historyAttendance map'indeki value'ler Attendance data type'inda date ve lesson bilgisini tutmakta
            System.out.println("The student attended all the lessons.");//attendance null ise ogrencinin devamsizligi yoktur
        } else {
            for (Attendance attendance : student.getHistoryAttendance()) {
                System.out.println(attendance);//toString vardi zaten

            }
        }

    }

    public List<Lessons> getAllLessonsList() {
        return lessonsRepository.getAllLessons();
    }
}