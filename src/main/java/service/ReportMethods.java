package service;

import config.Scanner_Utils;
import domain.Grades;
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

    //TODO Husnu Sen 17 -117
    public void showLessonSuccess() {
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
         boolean lessonChoose = false;
        do {


            int secim = Scanner_Utils.intScanner(scanner);


            if (secim > 0 && secim < 11) {
                switch (secim) {
                    case 1:
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

            } else System.out.println("Lütfen geçerli bir ders no giriniz");


        }while (!lessonChoose);//??

































        //Husnu Sen 17 -117
    }

    //TODO Seval Senturk  119 - 219
    public void showClassSuccess() {

        //SuccessDegree enumlarini kullanacaksin
        //tüm öğrencileri sınıf sınıf çağıracağız
        SuccessDegree successDegree = null; // ihtiyacımızı gidermiyor burası tekrar gözden geçecek!!!

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
    /*
        burada once kullanıcıya hangı sınıfın basarısını gormek ıstedıgını soracaksınız
        daha sonra aldıgınız cevaba ıstınaden ReportReposıtory classındaki getClassSuccess methodunu
        parametreli olarak cagiracaksiniz
        */



            System.out.println("Hangi sınıfın başarısını görmek istiyorsunuz..");
            String selectedClass = scanner.nextLine();

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

    //TODO Caner Unal 221-321
    public void showStudentSuccess() {
            //secilen ogrencinin once tum ders basarilari gosterilsin daha sonra genel ortalamaasi gosterilsin

































































































        }
    //TODO Caner Unal 323-423
     public void showStudentRank() {

            //ogrencinin genel ortalamasina gore siralamasi gozuksun
































































































        }


}


