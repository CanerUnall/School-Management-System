package repository;
import domain.Grades;
import config.JDBC_Utils;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ClassesRepository {
    //TODO Hanife Ocak 6-106
    public void getAllClassNotes(Grades grades) {
        //tum ogrenciler arasindan grade=1 veya 2 olani suzecek
        //sout ile ekrana yazdir

        //burada olusturulan classlari dbye kayit etmek icin gerekli sorgular yapilacak.
        //parametreden gelen classesleri bir donguye sok ve ogrencileri getir
        //daha sonra ogrencilerin idlerini ve gradelerini alip dbdeki t_classes tablosuna ekle.


/*

import java.util.List;

public class SinifIslemleri {

    // Varsayalım ki Grades sınıfı, öğrencilerin notlarıyla ilgili bilgileri içeriyor ve notlarına göre öğrencileri getiren bir metodu var.
    public List<Ogrenci> getirNotuBelirliSinifOgrencileri(int not) {
        // Veri kaynandan notu belirli öğrencileri getirme
        // Örneğin, bir veritabanı sorgusu
        // Belirli bir not ile öğrencilerin listesini döndürelim
        // Örnek: return ogrenciRepository.getByGrade(not);
        return null;
    }

    public void tumSinifNotlariniAl(Grades notlar) {
        // 1 veya 2 notuna sahip öğrencileri getir
        List<Ogrenci> notuBirVeIkiOlanOgrenciler = getirNotuBelirliSinifOgrencileri(1);
        notuBirVeIkiOlanOgrenciler.addAll(getirNotuBelirliSinifOgrencileri(2));

        // Öğrenciler üzerinde döngü yapın ve gerekli işlemleri gerçekleştirin
        for (Ogrenci ogrenci : notuBirVeIkiOlanOgrenciler) {
            // Öğrenci bilgilerini yazdırın
            System.out.println("Öğrenci ID: " + ogrenci.getId() + ", Not: " + ogrenci.getNot());

            // t_classes tablosuna kaydetmek için veritabanı işlemlerini gerçekleştirin
            // Örnek: tClassesTablosunaKaydet(ogrenci.getId(), ogrenci.getNot());
        }
    }

    // t_classes tablosuna kaydetmek için metodunuzu implement edin
    private void tClassesTablosunaKaydet(int ogrenciId, int not) {
        // Öğrenci bilgilerini t_classes tablosuna kaydetme mantığını uygulayın
        // Örnek: tClassesRepository.save(new TClasses(ogrenciId, not));
    }

    // Örnek Ogrenci ve TClasses sınıfları aşağıdaki gibi olabilir
    private static class Ogrenci {
        private int id;
        private int not;

        public Ogrenci(int id, int not) {
            this.id = id;
            this.not = not;
        }

        public int getId() {
            return id;
        }

        public int getNot() {
            return not;
        }
    }

    // Örnek TClasses sınıfı
    private static class TClasses {
        private int ogrenciId;
        private int not;

        public TClasses(int ogrenciId, int not) {
            this.ogrenciId = ogrenciId;
            this.not = not;
        }
    }
}

///////////////////////////


 */

















// Hanife Ocak 6-106
    }

    //TODO Seval Senturk 109 - 209
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


}