package service;

import config.JDBC_Utils;
import config.Scanner_Utils;

import domain.Attendance;

import domain.Classes;
import domain.Grades;


import domain.Lessons;
import domain.Student;
import repository.LessonsRepository;
import repository.StudentRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LessonMethods {
    private final LessonsRepository lessonsRepository;
    private final Scanner scanner;
    public LessonMethods(LessonsRepository lessonsRepository, Scanner scanner) {
        this.lessonsRepository = lessonsRepository;
        this.scanner = scanner;
    }
    //TODO Mustafa Ubeyde Kayhan 19 -  119
    public void addAllLesson() {
        //Mustafa Ubeyde Kayhan 19 -  119
        //ogretmenleri derslere atamak icin TeacherMethods clasindaki getAllTeacher methodu cagrilacak
        //burada LessonName enumlari kullanilarak tum dersler olusturulacak ve eger list bos ise allLessons listine eklenecek
        //burada kullanilacak dongu icinden LessonRepository clasindaki addAllLessonsRepo methodu cagrilacak

        //daha sonra LessonsRepository clasindaki addRepoLessons methodunu cagiracak ve bu dersleri dbye kayit edecek


























































































//Mustafa Ubeyde Kayhan 19 -  119
    }
    //TODO Omer Faruk Osmanoglu 122 - 222
    public void studentSchedule(Student student) {
        //ogrenci uzerinden tum dersleri cagirip ona gore takvimi olusturabilirsin
        //burada hafta icleri icin birer list olustursun


        List<Lessons> monday = new ArrayList<>();
        List<Lessons> tuesday = new ArrayList<>();
        List<Lessons> wednesday = new ArrayList<>();
        List<Lessons> thursday = new ArrayList<>();
        List<Lessons> friday = new ArrayList<>();

        for (Lessons lesson : student.getAllLessons().values()) {
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

        System.out.println("Lessons of Monday:");
        for (Lessons lesson : monday) {
            System.out.println(lesson.getName().name());
        }
        System.out.println("Lessons of Tuesday:");
        for (Lessons lesson : tuesday) {
            System.out.println(lesson.getName().name());
        }
        System.out.println("Lessons of Wednesday:");
        for (Lessons lesson : wednesday) {
            System.out.println(lesson.getName().name());
        }
        System.out.println("Lessons of Thursday:");
        for (Lessons lesson : thursday) {
            System.out.println(lesson.getName().name());
        }
        System.out.println("Lessons of Friday:");
        for (Lessons lesson : friday) {
            System.out.println(lesson.getName().name());


        }






































        //Omer Faruk Osmanoglu 122 - 222



}
    //TODO Hanife Ocak 224 - 324
    public void resultLesson(Student student) {
        //student objesi uzerinden ders notlarini yazdir.
































































































        //Hanife Ocak 224 - 324
    }

    //TODO Rumeysa Dagtekin 326 526
    public void selectLesson(Student student) {

//burada ogrenci ders secerken LessonsRepository clasindan getAllLessons methodu cagrilacak
// ve tum ders bilgileri bir liste eklenecek daha sonra switch/case ile ders secimi yaptirilacak

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

        System.out.println("Your course selection process has been completed.");




















































































//Rumeysa Dagtekin 326 526}
    }

    //Bu metodu selectLesson metodunun daha clean olmasi icin yazdim.
    private void chooseLesson(int choice, Student student, List<Lessons> lessonsList, StudentRepository studentRepository) {

        student.getAllLessons().put(student.getStudentID(),
                                    lessonsList.get(choice - 1));


        student.setTotalPrice(student.getTotalPrice() +
                (lessonsList.get(choice - 1).getLessonFee() * student.getPercentDiscount() / 100));

        lessonsRepository.addLessonStudent(student, lessonsList.get(choice - 1));

        studentRepository.updateFeeInfo(student, lessonsList.get(choice - 1).getLessonFee() * student.getPercentDiscount() / 100);

    }

    //TODO Semra Zengin 528 - 578
    public void showStudentAttendance(Student student) {
        //ogrenci uzerinden ogrencinin devamsizlik yaptigi gunlerin tarihleri ve ders isimleri yazdirilacak.


        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Student Name: " + student.getName() + " " + student.getSurName());

        System.out.println("Attendance History:");
        System.out.println("-------------------");

        if (student.getHistoryAttendance().values()==null){ //historyAttendance map'indeki value'ler Attendance data type'inda date ve lesson bilgisini tutmakta
            System.out.println("The student attended all the lessons.");//attendance null ise ogrencinin devamsizligi yoktur
        }else{
            for (Attendance attendance: student.getHistoryAttendance().values()){
                System.out.println(attendance);//toString vardi zaten

            }
        }



















    }
    //TODO Rumeysa Dagtekin 580 - 680
    public void allClassesSchedule() {
        //Rumeysa Dagtekin 580 - 680
        //buna dair simdilik bir yol haritasi hazirlayamadim.



        //bu sekilde sinif sinif ders takvimi yazdirilacak

        System.out.println("*** Classes ***");
        System.out.println();


        System.out.println("Please select the class you want to view the schedule for :");



    }
}