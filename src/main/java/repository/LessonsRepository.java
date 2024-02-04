package repository;

import domain.LessonNames;
import domain.Lessons;
import domain.Teacher;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static config.JDBC_Utils.setConnection;

public class LessonsRepository {
    PreparedStatement prst;

    public void createLessonsTable(){
//Omer Faruk Osmanoglu 9 - 109
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

    public void  addRepoLessons(Lessons lessons){
        //Mustafa Ubeyde Kayhan 111 -  211
        // ilgili dersi if not exist ile dbye kayit edecek

        //tablo adi = t_lessons
        //
        //      lessonID primary key
        //
        //      lesson_name
        //      teacherID foreign key olarak eklenecek
        //      lessonCredit
        //      lessonFee real
        //      studentNote
        //      lesson_day
        //      studentID foreign key olarak eklenecek
        setConnection();

        String sql = "INSERT INTO t_lessons" +
                "(lessonID, lesson_name, teacherID, lessonCredit, lessonFee, studentNote, lesson_day, studentID)" +
                " VALUES (?,?,?,?,?,?,?,?)";

        Lessons lessons1=new Lessons(LessonNames.TURKISH,new Teacher(),4,23.0,"Monday");
        try {

        //    prst.setString(1, lessons1.getName());
            prst.setString(2, lessons1.getTeacher().getName());
            prst.setInt(3, lessons1.getLessonCredit());
            prst.setDouble(4, lessons1.getLessonFee());
            prst.setString(5, lessons1.getDay());

            prst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


































































































        //Mustafa Ubeyde Kayhan 111 - 211
    }

    public List<Lessons> getAllLessons(){
        //Caner Unal
        //dbdeki tum dersleri getirecek ve br liste ekleyecek daha sonra o listi return edecek
        return null;
    }




}
