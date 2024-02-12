package repository;


import domain.LessonNames;
import domain.Lessons;
import domain.Teacher;

import java.sql.SQLException;
import java.util.List;

import config.JDBC_Utils;
import domain.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

import static config.JDBC_Utils.setConnection;
import static config.JDBC_Utils.setStatement;


public class LessonsRepository {

    TeacherRepository tRepo = new TeacherRepository();

    public void createLessonsTable() {

        setConnection();
        setStatement();

        String createLessonsTable = "CREATE TABLE IF NOT EXISTS t_lessons (" +
                "lessonID SERIAL PRIMARY KEY," +
                "lesson_name varchar(25)," +
                "teacherID INT REFERENCES t_teacher(teacherid)," +
                "lessonCredit integer," +
                "lessonFee real," +
                "studentNote integer," +
                "lesson_day varchar(25)," +
                "std_id INT REFERENCES t_student(std_id)," +
                "lessonSuccessDegree varchar(25)" +
                ")";

        String createLessonsList = "CREATE TABLE IF NOT EXISTS t_lessonsList (" +
                "lessonID SERIAL PRIMARY KEY," +
                "lesson_name varchar(25)," +
                "teacherID INT REFERENCES t_teacher(teacherid)," +
                "lessonCredit integer," +
                "lessonFee real," +
                "lesson_day varchar(25)" +
                ")";

        try {
            JDBC_Utils.getSt().executeUpdate(createLessonsTable);
            JDBC_Utils.getSt().executeUpdate(createLessonsList);
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

    }

    public void addRepoLessons(Lessons lessons) {

        JDBC_Utils.setConnection();

        String sql = "INSERT INTO t_lessonsList (lesson_name, teacherID, lessonCredit, lessonFee, lesson_day) " +
                "VALUES (?, ?, ?, ?, ?)";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1, String.valueOf(lessons.getName()));
            JDBC_Utils.getPrst().setInt(2, lessons.getTeacher().getTeacherID());
            JDBC_Utils.getPrst().setInt(3, lessons.getLessonCredit());
            JDBC_Utils.getPrst().setDouble(4, lessons.getLessonFee());
            JDBC_Utils.getPrst().setString(5, lessons.getDay());

            JDBC_Utils.getPrst().executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }


    public List<Lessons> getAllLessons() {


        setConnection();
        setStatement();

        String getAllLessons = "SELECT lesson_name, lessonCredit, lessonFee, lesson_day, teacherID FROM t_lessonsList";


        try {

            ResultSet result = JDBC_Utils.getSt().executeQuery(getAllLessons);
            List<Lessons> lessonsList = new ArrayList<>();
            while (result.next()) {

                String lessonName = result.getString("lesson_name");
                int lessonCredit = result.getInt("lessonCredit");
                double lessonFee = result.getDouble("lessonFee");
                String lessonDay = result.getString("lesson_day");
                int TeacherId = result.getInt("teacherID");

                Teacher teacher = tRepo.find(TeacherId);
                LessonNames lName = LessonNames.valueOf(lessonName); //String`i LessonNames data tipine cevirdik


                Lessons lesson = new Lessons(lName, teacher, lessonCredit, lessonFee, lessonDay); //database`den alinan veriler ile obje olusturduk
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

    public void addLessonStudent(Student student, Lessons lesson) {

        setConnection();
        String sql = "INSERT INTO t_lessons (lesson_name, teacherID,lessonCredit,lessonFee,studentNote,lesson_day,std_id) VALUES (?,?,?,?,?,?,?)";
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