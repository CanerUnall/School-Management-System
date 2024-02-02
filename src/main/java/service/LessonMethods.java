package service;

import config.JDBC_Utils;
import domain.Attendance;
import domain.Classes;
import domain.Lessons;
import domain.Student;
import repository.LessonsRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LessonMethods {
    private final LessonsRepository lessonsRepository;
    private final Scanner scanner;

    public LessonMethods(LessonsRepository lessonsRepository, Scanner scanner) {
        this.lessonsRepository = lessonsRepository;
        this.scanner = scanner;
    }

    public void addAllLesson(){
        //Mustafa Ubeyde Kayhan 19 -  119
      //ogretmenleri derslere atamak icin TeacherMethods clasindaki getAllTeacher methodu cagrilacak
        //burada LessonName enumlari kullanilarak tum dersler olusturulacak ve eger list bos ise allLessons listine eklenecek
        //burada kullanilacak dongu icinden LessonRepository clasindaki addAllLessonsRepo methodu cagrilacak

        //daha sonra LessonsRepository clasindaki addRepoLessons methodunu cagiracak ve bu dersleri dbye kayit edecek




























































































//Mustafa Ubeyde Kayhan 19 -  119
    }


    //Omer Faruk Osmanoglu 122 - 222
    public void studentSchedule(Student student) {
        //ogrenci uzerinden tum dersleri cagirip ona gore takvimi olusturabilirsin
        //burada hafta icleri icin birer list olustursun































































































        //Omer Faruk Osmanoglu 122 - 222
    }

    //Hanife Ocak 224 - 324
    public void resultLesson(Student student){
     //student objesi uzerinden ders notlarini yazdir.
































































































        //Hanife Ocak 224 - 324
    }

    //Rumeysa Dagtekin 326 526
    public void selectLesson(Student student){
//burada ogrenci ders secerken LessonsRepository clasindan getAllLessons methodu cagrilacak
// ve tum ders bilgileri bir liste eklenecek daha sonra switch/case ile ders secimi yaptirilacak



































































































































































































//Rumeysa Dagtekin 326 526
    }

    //Semra Zengin 528 - 578
    public void showStudentAttendance(Student student){
        //ogrenci uzerinden ogrencinin devamsizlik yaptigi gunlerin tarihleri ve ders isimleri yazdirilacak.


        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();
        String query="SELECT * FROM t_attendance WHERE studentID="+student.getStudentID();
        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Student Name: " + student.getName() + " " + student.getSurName());

        System.out.println("Attendance History:");
        System.out.println("-------------------");
         try {
             ResultSet resultSet = JDBC_Utils.getSt().executeQuery(query);
             while (resultSet.next()){
                 System.out.println("Lesson : "+resultSet.getString("lesson_name"));
                 System.out.println("Date : "+resultSet.getString("date"));
             }

         } catch (SQLException e) {
             System.err.println(e.getMessage());
         }finally {
             try {
                 JDBC_Utils.getSt().close();
                 JDBC_Utils.getCon().close();

             } catch (SQLException e) {
                 System.err.println(e.getMessage());
             }
         }


























































//Semra Zengin 528 - 578
    }

    //Rumeysa Dagtekin 580 - 680
    public void allClassesSchedule(Classes classes){

        //buna dair simdilik bir yol haritasi hazirlayamadim.
    //TODO lutfen herkes bunu nasil yapacagimizi dusunsun
        /*for (Student each:classes.getAllStudents()){

            for (Lessons each1 :each.getAllLessons().values()){

            }

        }*/

        //bu sekilde sinif sinif ders takvimi yazdirilacak
    }

}
