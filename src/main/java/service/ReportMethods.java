package service;

import config.Scanner_Utils;
import domain.Grades;
import repository.ReportRepository;
import java.util.Scanner;

public class ReportMethods {
    private final Scanner scanner;
    private final ReportRepository reportRepository;

    public ReportMethods(Scanner scanner, ReportRepository reportRepository) {
        this.scanner = scanner;
        this.reportRepository = reportRepository;

    }
    //Husnu Sen 17 -117
    public void showLessonSuccess() {
        //derse gore basariyi yazdiracak.
        // mat, fen
    //SuccessDegree enumlarini kullanacaksin






























































































        //Husnu Sen 17 -117
    }

    //Seval Senturk  119 - 219
    public void showClassSuccess() {
    /*
        burada once kullanıcıya hangı sınıfın basarısını gormek ıstedıgını soracaksınız
        daha sonra aldıgınız cevaba ıstınaden ReportReposıtory classındaki getClassSuccess methodunu
        parametreli olarak cagiracaksiniz
        */

        System.out.println("Hangi sınıfın başarısını görmek istiyorsunuz..");
        String selectedClass=scanner.nextLine();

        try {
            // Kullanıcının girdiği sınıf ismini Grades enum değerine dönüştürüyoruz
            Grades selectedGrade = Grades.valueOf(selectedClass);

            reportRepository.getClassSuccess(selectedGrade);

        } catch (IllegalArgumentException e) {
            System.err.println("Geçersiz sınıf ismi. Lütfen geçerli bir sınıf ismi giriniz.");
        } finally {
            scanner.close();
        }













































































//Seval Senturk  119 - 219
    }

    //Caner unal
    public void showStudentSuccess() {
        //secilen ogrencinin once tum ders basarilari gosterilsin daha sonra genel ortalamaasi gosterilsin
    }

    //Caner unal
    public void showStudentRank() {

        //ogrencinin genel ortalamasina gore siralamasi gozuksun
    }


}
