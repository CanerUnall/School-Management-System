package controller;

import config.Scanner_Utils;
import domain.Admins;
import domain.Student;
import domain.Teacher;

import repository.*;

import repository.AdminRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.AdminMethods;

import service.StudentMethods;
import service.TeacherMethods;

import java.util.Scanner;

public class SchoolManagementSystem {













































































    static {

        //burada db ile alakali create methodlarindan birkaci cagrilsin.
    }

        // Omer Faruk Osmanoglu
        /*
        2 adet thread olusturulacak
        ilk thread icinde db ile alakali create methodlarinin gerisi cagrilsin.
        ikinci thread de ise bizim uygulamamizin starti buradan baslasin
         */
        public  void threads() {
            // Omer Faruk Osmanoglu


            Thread secondThread = new Thread(() -> {
                AdminRepository adminRepository=new AdminRepository();
                adminRepository.createAdminTable();
                AttendanceRepository attendanceRepository=new AttendanceRepository();
                attendanceRepository.createAttendanceTable();
                StudentRepository studentRepository=new StudentRepository();
                studentRepository.createStudentTable();
                TeacherRepository teacherRepository=new TeacherRepository();
                teacherRepository.createTeacherTable();
                LessonsRepository lessonsRepository=new LessonsRepository();
                lessonsRepository.createLessonsTable();
            });
            Thread startToThread = new Thread(() -> {
                homePage();
            });

            secondThread.start();
            startToThread.start();

    }




    //Semra Zengin 123-223
    static void homePage() {
        // kullanicinin ana sayfada gormesi gerekenleri bir dongu ile yazdir.
        /*ogrenci olarak giris yap (ogrenci login  methodu burada cagrilacak)
         * ogretmen olarak giris yap (ogretmen login methodu burada cagrilacak)
         * yonetici olarak giris yap (admin login methodu burada cagrilacak)
         * cikis
         * */
        Scanner scanner=new Scanner(System.in);
        Scanner_Utils.intScanner(scanner);

        StudentRepository studentRepository=new StudentRepository();
        StudentMethods studentMethods=new StudentMethods(scanner, studentRepository);

        TeacherRepository teacherRepository=new TeacherRepository();
        TeacherMethods teacherMethods=new TeacherMethods(teacherRepository, scanner);

        AdminRepository adminRepository=new AdminRepository();
        AdminMethods adminMethods=new AdminMethods(scanner, adminRepository);

        boolean exit = false;

        while (!exit) {
            System.out.println("========= Welcome to School Management System =========");
            System.out.println( "1. Student Operations\n" +
                    "2. Teacher Operations\n" +
                    "3. Admin Operations\n" +
                    "0. Exit\n" +
                    "Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentMethods.login();
                    break;
                case 2:
                    teacherMethods.login();
                    break;
                case 3:
                    adminMethods.login();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Good bye...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }




















































































        //Semra Zengin 123-223
    }

    //Hanife Ocak 225-325
    static void studentPage(Student student){
        /*
        * ogrenci ahmet hosgeldin
        * yapabilecegi islemler bir dongu ile yazdirilacak ve sectirilecek
        * OGRENCI EKRANINDA
        1. KENDI BILGILERINI
        2. DERS PROGRAMINI GOR
        3. DERS SONUCLARINI
        4. DERS SECIMI
        5. YOKLAMA
        6. Ana menuye don
        * */






















































































        //Hanife Ocak 225-325
    }

    //Emrah Kaya 327 -477
    static void teacherPage(Teacher teacher){
        /*
         * ogretmen ahmet hosgeldin
         * yapabilecegi islemler bir dongu ile yazdirilacak ve sectirilecek
         * 1. TUM OGRENCI BILGILERI
         * 2. ogrenci islemleri
         *      1. ogrenci ekleme
         *      2. ogrenci silme
         *      3. ogrenci bilgilerini guncelleme
         *      4. ogrenci bul
         * 3. ders takibi ve secimi
         *      1. ders programini goster
         *      2. ders kredisi belirle
         * 4. ogrenci not takibi
         *      1. tum sinifin notlarini gor
         *      2. ogrenci notunu gir/ duzenle
         * 5. ogretmen islemleri
         *      1. kisisel bilgiler gor
         * 6. raporlama
         *      1. derse gore basari
         *      * Seçilen derse göre öğrenci başarı durumları raporlanır.
         *      2. sinif basarisi
         *      * Belirli bir sınıfın genel başarı durumu raporlanır.
         *      3. ogrenci basarisi
         *      * Belirli bir öğrencinin başarı durumu raporlanır.
         *      4. siralama
         *      * Öğrenci başarısı raporlarına, sıralama (notlara göre sıralama) özelliği ekleyebiliriz.
         *
         * */
























































































































        //Emrah Kaya 327 -477
    }

    //Cihan Guler 479 - 679
    static void adminPage(Admins admins){
        /*
         * yonetici ahmet hosgeldin
         * yapabilecegi islemler bir dongu ile yazdirilacak ve sectirilecek
         * 1. TUM OGRENCI BILGILERI
         * 2. ogrenci islemleri
         *      1. ogrenci ekleme
         *      2. ogrenci silme
         *      3. ogrenci bilgilerini guncelleme
         *      4. ogrenci bul
         * 3. ders takibi ve secimi
         *      1. ders programini goster
         *      2. ders kredisi belirle
         * 4. ogrenci not takibi
         *      1. tum sinifin notlarini gor
         *      2. ogrenci notunu gir/ duzenle
         * 5. ogretmen bilgileri/islemleri
         *      1. kisisel bilgiler gor
         *      2. ogretmen islemleri
         *          1. ogretmen ekle
         *          2. ogretmen sil
         *          3. guncelle
         *          4. ogretmen bul
         * 6. raporlama
         *      1. derse gore basari
         *      * Seçilen derse göre öğrenci başarı durumları raporlanır.
         *      2. sinif basarisi
         *      * Belirli bir sınıfın genel başarı durumu raporlanır.
         *      3. ogrenci basarisi
         *      * Belirli bir öğrencinin başarı durumu raporlanır.
         *      4. siralama
         *      * Öğrenci başarısı raporlarına, sıralama (notlara göre sıralama) özelliği ekleyebiliriz.
         * 7. finans bolumu
         *      1. gelir tablosunu gor
         *      2. gider tablosunu gor
         *      3. odeme takibi(ogrenci id ile yaptigi odemeleri gorebilir)
         * */


































































































































































        //Cihan Guler 479 - 679
    }



}
