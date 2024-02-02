package repository;

import domain.Grades;
import config.JDBC_Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassesRepository {

    // Hanife Ocak 6-106
    public void getAllClassNotes(Grades grades) {
        //tum ogrenciler arasindan grade=1 veya 2 olani suzecek
        //sout ile ekrana yazdir

        //burada olusturulan classlari dbye kayit etmek icin gerekli sorgular yapilacak.
        //parametreden gelen classesleri bir donguye sok ve ogrencileri getir
        //daha sonra ogrencilerin idlerini ve gradelerini alip dbdeki t_classes tablosuna ekle.


























































































// Hanife Ocak 6-106
    }

    //Seval Senturk 109 - 209
    public void getAllClassInfo(Grades grades) {

        // JDBC bağlantısını aç

        JDBC_Utils.setConnection();

        String selectedClassName= grades.name();

        String sql = "SELECT * FROM t_student WHERE grade = ?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1,selectedClassName);
            ResultSet resultSet=JDBC_Utils.getPrst().executeQuery();


            if (resultSet.next()) {
                System.out.print(" Student ID : "+ resultSet.getInt("studentID"));
                System.out.print(" Name : "+resultSet.getString("firstName"));
                System.out.print(" Last Name : "+ resultSet.getString("lastName"));
                System.out.print(" Address : "+resultSet.getString("address"));
                System.out.print(" Phone Number : "+ resultSet.getString("phoneNumber"));
                System.out.print(" Student AVG : "+ resultSet.getDouble("thisYearGradeAvg"));

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






























































































//Seval Senturk 109 - 209


}