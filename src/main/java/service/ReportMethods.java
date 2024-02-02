package service;

import config.JDBC_Utils;
import config.Scanner_Utils;
import repository.ReportRepository;

import java.util.Scanner;

public class ReportMethods {
    private final Scanner scanner;
    private final ReportRepository reportRepository;

    public ReportMethods(Scanner scanner, ReportRepository reportRepository) {
        this.scanner = scanner;
        this.reportRepository = reportRepository;

    }

    public void showLessonSuccess() {
    //Husnu Sen 17 -117
        //derse gore basariyi yazdiracak.
        // mat, fen
    //SuccessDegree enumlarini kullanacaksin

        System.out.println("Hangi dersin notunu gireceksiniz");
        System.out.println("1. MATHS");
        System.out.println("2. ENGLISH");//dersler
        System.out.println("3. HISTORY");
        System.out.println("4.TURKISH");
        System.out.println("5.PHYSICAL");
        System.out.println("6.CHEMICAL");
        System.out.println("7.GEOGRAPHY");
        System.out.println("8.IT");
        System.out.println("9.SPORTS");
        System.out.println("10.BIOLOGY");


        System.out.println("Seçiminiz");

       // while ()

        int secim = Scanner_Utils.intScanner(scanner);



      if(secim>0 && secim<11){
          switch (secim){
              case 1 :
                  reportRepository.getLessonSuccess("MATHS");
                  break;
              case 2:
                  reportRepository.getLessonSuccess("ENGLISH");
                  break;
              case 3:
                  reportRepository.getLessonSuccess("HISTORY");
                  break;
              case 4:
                  reportRepository.getLessonSuccess("TURKISH");
                  break;
              case 5:
                  reportRepository.getLessonSuccess("PHYSICAL");
                  break;
              case 6:
                  reportRepository.getLessonSuccess("CHEMICAL");
                  break;
              case 7:
                  reportRepository.getLessonSuccess("GEOGRAPHY");
                  break;
              case 8:
                  reportRepository.getLessonSuccess("IT");
                  break;
              case 9:
                  reportRepository.getLessonSuccess("SPORTS");
                  break;
              case 10:
                  reportRepository.getLessonSuccess("BIOLOGY");
                  break;

          }

      }else System.out.println("Lütfen geçerli bir ders no giriniz");


































        //Husnu Sen 17 -117
    }

    public void showClassSuccess() {
//Seval Senturk  119 - 219
//SuccessDegree enumlarini kullanacaksin
































































































//Seval Senturk  119 - 219
    }

    public void showStudentSuccess() {
        //Caner unal
        //secilen ogrencinin once tum ders basarilari gosterilsin daha sonra genel ortalamaasi gosterilsin
    }

    public void showStudentRank() {
        //Caner unal
        //ogrencinin genel ortalamasina gore siralamasi gozuksun
    }


}
