package repository;

import config.JDBC_Utils;
import domain.Grades;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportRepository {

    public void getLessonSuccess(String lessonName) {

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        System.out.println("****************LESSON SUCCESS******************");

        //burada öğrencinin ders başarısı iki farklı tablodan left join ile alınıyor student tablosu ve lesson tablosu kullanılıyor
        // student id ortak değer olarak kabul ediliyor

        try {
            String getLessonQuery = "Select lesson_name,std_name,std_surName,studentNote From t_lessons l LEFT JOIN t_student s " +
                    " ON  l.std_id = s.std_id where l.lesson_name='" + lessonName+"'";

            ResultSet resultSet = JDBC_Utils.getSt().executeQuery(getLessonQuery);


            while (resultSet.next()) {

                String lesson = resultSet.getString("lesson_name");
                String stdName = resultSet.getString("std_name");
                String stdSurName = resultSet.getString("std_surName");
                int studentNote = resultSet.getInt("studentNote");

                System.out.println("Lesson: " + lesson + "  Student Name: " + stdName + "  Student Surname: " + stdSurName + "  Student Grade: " + studentNote);
            }

        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }

        }

    }

    public void getClassSuccess(Grades grades) {

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();
        String selectedClassName = grades.name();
        String sql = "SELECT lesson_name, std_name, std_surName, studentNote FROM t_lessons l " +
                "LEFT JOIN t_student s ON l.std_id = s.std_id WHERE l.lesson_name='" + selectedClassName + "'";

        try {

            ResultSet resultSet = JDBC_Utils.getSt().executeQuery(sql);

            while (resultSet.next()) {

                System.out.println("Student ID : " + resultSet.getInt("std_id") +
                        "Student Name : " + resultSet.getString("std_name") +
                        "Student Surname : " + resultSet.getString("std_surName"));
                double thisYearGradeAvg = resultSet.getDouble("thisYearGradeAvg");

                System.out.print("This Year Grade Avg: " + thisYearGradeAvg + " - ");
                if (thisYearGradeAvg >= 90) {
                    System.out.println("Excellent");
                } else if (thisYearGradeAvg >= 80) {
                    System.out.println("Good");
                } else if (thisYearGradeAvg >= 60) {
                    System.out.println("Average");
                } else if (thisYearGradeAvg >= 40) {
                    System.out.println("Below Average");
                } else {
                    System.out.println("Fail");
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

    }


}
