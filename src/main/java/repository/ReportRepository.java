package repository;
import config.JDBC_Utils;
import domain.Grades;
import domain.Student;
import exceptions.StudentNotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ReportRepository {
    //TODO Husnu Sen 8 -108
    public void getLessonSuccess(String lessonName) {


        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();


        System.out.println("****************LESSON SUCCESS******************");

        //burada öğrencinin ders başarısı iki farklı tablodan left join ile alınıyor student tablosu ve lesson tablosu kullanılıyor
        // student id ortak değer olarak kabul ediliyor

        try {
            String getLessonQuery = "Select lesson_name,std_name,std_surName,studentNote From t_lessons l LEFT JOIN t_student s " +
                    " ON  l.studentID = s.std_id";

            ResultSet resultSet = JDBC_Utils.getSt().executeQuery(getLessonQuery);


            while (resultSet.next()) {

                String lesson = resultSet.getString("lesson_name");
                String stdName = resultSet.getString("std_name");
                String stdSurName = resultSet.getString("std_surName");
                int studentNote = resultSet.getInt("studentNote");


                System.out.println("Lesson: " + lesson + "  Student Name: " + stdName + "  Student Surname: " + stdSurName + "  Student Grade: " + studentNote );

            }

        }catch (SQLException e) {
             System.err.println("Error : " + e.getMessage());
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }

        }


















































        //Husnu Sen 8 -108
    }





    //TODO Seval Senturk  119 - 219
    public List<Double> getClassSuccess(Grades grades) {
        /*ReportRepository icin
        Burada paramatreden gelen sınıfa gore sorgu yazip o siniftaki ogrencileri bulacaksiniz
        daha sonra o ogrencinin thisYearGradeAvg puanina gore ogrencinin basarisini ekrana yazdiracaksiniz.
        mesela 90-100 arasi olan A, 80-90 arasi B gibi. Burayi siz istediginiz sekilde gruplayin.
*/

        List<Double> thisYearGradeAvgs = new ArrayList<>();
        // JDBC bağlantısını aç

        JDBC_Utils.setConnection();

        String selectedClassName = grades.name();

        String sql = "SELECT thisYearGradeAvg FROM t_student WHERE grade = ?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1, selectedClassName);
            ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();
            if (resultSet.next()) {
                double thisYearGradeAvg = resultSet.getDouble("thisYearGradeAvg");
                thisYearGradeAvgs.add(thisYearGradeAvg);

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
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        return thisYearGradeAvgs;

















































        //Seval Senturk  119 - 219
    }


    //TODO Caner Unal 222 - 322
    public void getStudentSuccess(Student student) {
        //secilen ogrencinin once tum ders basarilari gosterilsin daha sonra genel ortalamaasi gosterilsin

































































































    }
    //TODO Caner Unal 323-423
    public void getStudentRank(Student student) {
        //ogrencinin genel ortalamasina gore siralamasi gozuksun

































































































    }
}
