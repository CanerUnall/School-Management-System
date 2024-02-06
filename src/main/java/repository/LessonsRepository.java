package repository;
import config.JDBC_Utils;
import domain.LessonNames;
import domain.Lessons;
import domain.Student;
import domain.Teacher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static config.JDBC_Utils.setConnection;
import static config.JDBC_Utils.setStatement;


public class LessonsRepository {
    TeacherRepository tRepo=new TeacherRepository();

    //TODO Omer Faruk Osmanoglu 15- 115
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

        setConnection();
        setStatement();

        String createLessonsTable = "CREATE TABLE IF NOT EXISTS t_lessons (lessonID integer PRIMARY KEY AUTO_INCREMENT," +
                "lesson_name varchar(25)" +
                "teacherID integer foreign key" +
                "lessonCredit integer" +
                "lessonFee real" +
                "studentNote integer" +
                "lesson_day varchar(25)" +
                "studentID  integer foreign key)";



        try {
            JDBC_Utils.getSt().executeUpdate(createLessonsTable);
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















































        //Omer Faruk Osmanoglu 9 - 109
    }

    //TODO Mustafa Ubeyde Kayhan 111 -  211
    public void  addRepoLessons(Lessons lessons){
        // ilgili dersi if not exist ile dbye kayit edecek



























































































        //Mustafa Ubeyde Kayhan 111 - 211
    }


    //TODO RUMEYSA
    public List<Lessons> getAllLessons(){

        //dbdeki tum dersleri getirecek ve br liste ekleyecek daha sonra o listi return edecek

        setConnection();
        setStatement();

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
  
  
  
  

  
    
    //TODO RUMEYSA
    public void addLessonStudent(Student student,Lessons lesson) {

        setConnection();
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






