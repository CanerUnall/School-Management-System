package repository;

import config.JDBC_Utils;
import domain.LessonNames;
import domain.Lessons;
import domain.Student;
import domain.Teacher;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import java.sql.Statement;

import java.util.List;

import static config.JDBC_Utils.*;

public class LessonsRepository {


    TeacherRepository tRepo=new TeacherRepository();


    //Omer Faruk Osmanoglu 9 - 109

    public void createLessonsTable(){
      /*
      burada tum dersler kaydedilecek

      bu methodun query si yazilirken if not exist kullanilacak

      tablo adi = t_lessons

      lessonID primary key

      lesson_name
      teacherID foreign key olarak eklenecek
      lessonCredit
      lessonFee real
      studentNote
      lesson_day
      studentID foreign key olarak eklenecek
*/












































































        //Omer Faruk Osmanoglu 9 - 109
    }

    //Mustafa Ubeyde Kayhan 111 -  211
    public void  addRepoLessons(Lessons lessons){
        // ilgili dersi if not exist ile dbye kayit edecek
































































































        //Mustafa Ubeyde Kayhan 111 - 211
    }


    //Caner Unal //RUMEYSA
    public List<Lessons> getAllLessons(){

        //dbdeki tum dersleri getirecek ve br liste ekleyecek daha sonra o listi return edecek

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        String getAllLessons = "SELECT (lesson_name,lessonCredit,lessonFee,lesson_day,teacherID) FROM t_lessons";
        ResultSet result = null;

        try {

            result = JDBC_Utils.getSt().executeQuery(getAllLessons);
            List<Lessons> lessonsList = null;
            while (result.next()) {

                String lessonName = result.getString("lesson_name");
                Integer lessonCredit = result.getInt("lessonCredit");
                Double lessonFee = result.getDouble("lessonFee");
                String lessonDay = result.getString("lesson_day");
                Integer TeacherId = result.getInt("teacherID");

                Teacher teacher = tRepo.find(TeacherId);
                LessonNames lName = LessonNames.valueOf(lessonName); //String`i LessonNames data tipine cevirdik


                Lessons lesson = new Lessons(lName, teacher, lessonCredit, lessonFee, lessonDay); //database`den alinan veriler ile obje olusturduk

                lessonsList = new ArrayList<>();
                lessonsList.add(lesson); //list`in icerisine lesson objesini ekledik


            }

               return lessonsList;  // olusan list`i return ediyoruz.
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }



        return null;
    }
  
  
  
  

  
    
    //RUMEYSA
    public void addLessonStudent(Student student,Lessons lesson) {

        JDBC_Utils.setConnection();
        String sql = "INSERT INTO t_lessons (lesson_name, teacherID,lessonCredit,lessonFee,studentNote,lesson_day,studentID) VALUES (?,?,?,?,?,?,?)";
          JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setString(1, lesson.getName().name());
            JDBC_Utils.getPrst().setInt(2, lesson.getTeacher().getTeacherID());
            JDBC_Utils.getPrst().setInt(3, lesson.getLessonCredit());
            JDBC_Utils.getPrst().setDouble(4, lesson.getLessonFee());
            JDBC_Utils.getPrst().setInt(5, lesson.getStudentNote());
            JDBC_Utils.getPrst().setString(6, lesson.getDay());
            JDBC_Utils.getPrst().setInt(7, student.getStudentID());

            JDBC_Utils.getPrst().executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }











    }



}


