package repository;

import domain.Grades;
import config.JDBC_Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassesRepository {

    public void getAllClassNotes(Grades grades, String lesName) {

        JDBC_Utils.setConnection();

        String selectedClassName = grades.name();

        String sql = "SELECT std_name,std_surname,lesson_name,studentNote FROM t_student LEFT JOIN t_lessons ON t_lessons.std_id=t_student.std_id WHERE grade = ?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1, selectedClassName);
            ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();


            while (resultSet.next()) {
                if (lesName.equals(resultSet.getString("lesson_name"))) {
                    System.out.print(" Student ID : " + resultSet.getInt("std_id"));
                    System.out.print(" Name : " + resultSet.getString("std_name"));
                    System.out.print(" Last Name : " + resultSet.getString("std_surname"));
                    System.out.print("Student note : " + resultSet.getInt("studentNote"));

                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }
        }

    }

    public void getAllClassInfo(Grades grades) {

        JDBC_Utils.setConnection();

        String selectedClassName = grades.name();

        String sql = "SELECT * FROM t_student WHERE grade = ?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1, selectedClassName);
            ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();
            while (resultSet.next()) {
                System.out.print("Student ID : " + resultSet.getInt("std_id"));
                System.out.print(" Name : " + resultSet.getString("std_name"));
                System.out.print(" Last Name : " + resultSet.getString("std_surName"));
                System.out.print(" Address : " + resultSet.getString("address"));
                System.out.print(" Phone Number : " + resultSet.getString("phoneNumber"));
                System.out.print(" Student AVG : " + resultSet.getDouble("thisYearGradeAvg"));

                System.out.println();

            }
        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }
        }

    }

}