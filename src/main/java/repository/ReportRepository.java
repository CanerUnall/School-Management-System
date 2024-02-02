package repository;

import config.JDBC_Utils;
import domain.Grades;
import domain.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportRepository {

    public void getLessonSuccess(String lessonName) {



































































































        //Husnu Sen 8 -108
    }


    //Seval Senturk  119 - 219
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



    public void getStudentSuccess(Student student) {
        //secilen ogrencinin once tum ders basarilari gosterilsin daha sonra genel ortalamaasi gosterilsin
    }

    public void getStudentRank(Student student) {
        //ogrencinin genel ortalamasina gore siralamasi gozuksun
    }
}
