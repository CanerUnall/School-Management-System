package service;

import domain.SuccessDegree;
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
    public void showClassSuccess(SuccessDegree successDegree) {
    //SuccessDegree enumlarini kullanacaksin
        //tüm öğrencileri sınıf sınıf çağıracağız

        switch (successDegree) {
            case A:
                System.out.println("Sınıf başarısı: Mükemmel");
                break;
            case B:
                System.out.println("Sınıf başarısı: İyi");
                break;
            case C:
                System.out.println("Sınıf başarısı: Orta");
                break;
            case D:
                System.out.println("Sınıf başarısı: Geçer");
                break;
            case F:
                System.out.println("Sınıf başarısı: Başarısız");
                break;
            default:
                System.out.println("Geçersiz değer");
                break;
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
