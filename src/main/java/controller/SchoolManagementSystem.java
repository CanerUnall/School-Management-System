package controller;

import config.Scanner_Utils;
import domain.Admins;

import domain.Student;
import domain.Teacher;
import repository.*;
import service.*;

import java.util.Scanner;

import repository.AdminRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.AdminMethods;
import service.StudentMethods;
import service.TeacherMethods;

public class SchoolManagementSystem {


    private Scanner scanner = new Scanner(System.in);
    private ClassesRepository classesRepository = new ClassesRepository();
    private ClassesMethods classesMethods = new ClassesMethods(classesRepository, scanner);


    private StudentRepository studentRepository = new StudentRepository();

    private StudentMethods studentMethods = new StudentMethods(scanner, studentRepository);

    private LessonsRepository lessonsRepository = new LessonsRepository();
    private LessonMethods lessonMethods = new LessonMethods(lessonsRepository, scanner);

    private TeacherRepository teacherRepository = new TeacherRepository();
    private TeacherMethods teacherMethods = new TeacherMethods(teacherRepository, scanner);

    private ReportRepository reportRepository = new ReportRepository();
    private ReportMethods reportMethods = new ReportMethods(scanner, reportRepository);

    private FinanceRepository financeRepository = new FinanceRepository();
    private FinanceMethods financeMethods = new FinanceMethods(financeRepository);


    static {

        //burada db ile alakali create methodlarindan birkaci cagrilsin.
    }

    // Omer Faruk Osmanoglu
        /*
        2 adet thread olusturulacak
        ilk thread icinde db ile alakali create methodlarinin gerisi cagrilsin.
        ikinci thread de ise bizim uygulamamizin starti buradan baslasin
         */
    public void threads() {
        // Omer Faruk Osmanoglu


        Thread secondThread = new Thread(() -> {
            AdminRepository adminRepository = new AdminRepository();
            adminRepository.createAdminTable();
            AttendanceRepository attendanceRepository = new AttendanceRepository();
            attendanceRepository.createAttendanceTable();
            StudentRepository studentRepository = new StudentRepository();
            studentRepository.createStudentTable();
            TeacherRepository teacherRepository = new TeacherRepository();
            teacherRepository.createTeacherTable();
            LessonsRepository lessonsRepository = new LessonsRepository();
            lessonsRepository.createLessonsTable();
        });
        Thread startToThread = new Thread(() -> {
            homePage();
        });

        secondThread.start();
        startToThread.start();

    }


    //Semra Zengin 123-223
    void homePage() {
        // kullanicinin ana sayfada gormesi gerekenleri bir dongu ile yazdir.
        /*ogrenci olarak giris yap (ogrenci login  methodu burada cagrilacak)
         * ogretmen olarak giris yap (ogretmen login methodu burada cagrilacak)
         * yonetici olarak giris yap (admin login methodu burada cagrilacak)
         * cikis
         * */
        Scanner scanner = new Scanner(System.in);
        Scanner_Utils.intScanner(scanner);

        StudentRepository studentRepository = new StudentRepository();
        StudentMethods studentMethods = new StudentMethods(scanner, studentRepository);

        TeacherRepository teacherRepository = new TeacherRepository();
        TeacherMethods teacherMethods = new TeacherMethods(teacherRepository, scanner);

        AdminRepository adminRepository = new AdminRepository();
        AdminMethods adminMethods = new AdminMethods(scanner, adminRepository);

        boolean exit = false;

        while (!exit) {
            System.out.println("========= Welcome to School Management System =========");
            System.out.println("1. Student Operations\n" +
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
    void studentPage(Student student) {
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


        class studentPage {
            private String ad;
            private String ogrenciNo;
            private String bolum;

            public studentPage(String ad, String ogrenciNo, String bolum) {
                this.ad = ad;
                this.ogrenciNo = ogrenciNo;
                this.bolum = bolum;
            }

            public void kendiBilgileriniGor() {
                System.out.println("Ad: " + ad);
                System.out.println("Ogrenci No: " + ogrenciNo);
                System.out.println("Bolum: " + bolum);
            }

            public void dersPrograminiGor() {
                // Ders programını görüntüleme işlemleri
                System.out.println("Ders Programi: ...");
            }

            public void dersSonuclariniGor() {
                // Ders sonuçlarını görüntüleme
                System.out.println("Ders Sonuclari: ...");
            }

            public void dersSecimiYap() {
                // Ders seçimi yapma
                System.out.println("Ders Secimi Yapiliyor...");
            }

            public void yoklamaAl() {
                // Yoklama alma
                System.out.println("Yoklama Aliniyor...");
            }
        }


        //Hanife Ocak 225-325
    }

    //Emrah Kaya 327 -477
    void teacherPage(Teacher teacher) {
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


    public void adminPage(Admins admins) {
        /* Cihan Guler 479 - 679

    //Cihan Guler 479 - 679

    void adminPage(Admins admins){
            /* Cihan Guler 479 - 679
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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our system..." + admins.getName());
        boolean running = true;

        while (running) {
            System.out.println("========= School Management System =========");
            System.out.println("===Select the part you want to transact wit===");
            System.out.println("1. All student information...");
            System.out.println("2. Student Transactions");
            System.out.println("3. Course Tracking and Selection");
            System.out.println("4. Student Grade Tracking");
            System.out.println("5. Teacher Information and Transactions");
            System.out.println("6. Reporting");
            System.out.println("7. Department of Finance");
            System.out.println("0. Exit");
            System.out.print("Please select an action: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    classesMethods.showAllStudentInfo();
                    break;
                case 2:
                    studentMethods();
                    break;
                case 3:
                    // 1. ders programini goster
                    // 2. ders kredisi belirle
                    System.out.println("1. Show syllabus.");
                    System.out.println("2. Determine course credit.");
                    System.out.println("Press :1 or 2 ");
                    int choice2 = Scanner_Utils.intScanner(scanner);
                    if (choice2 == 1) {
                        lessonMethods.allClassesSchedule();
                    } else if (choice2 == 2) {
                        //ders kredisi belirle yen method hangisi bulamadım
                    } else {
                        System.out.println("Make a valid keystroke");
                    }
                    break;
                case 4:
                    //      1. tum sinifin notlarini gor
                    //      2. ogrenci notunu gir/ duzenle
                    System.out.println("Press 1 to see the lecture notes of the class.");
                    System.out.println("Press 2 to enter the student grade and edit it.");
                    System.out.println("Press : ");
                    int choice3 = Scanner_Utils.intScanner(scanner);
                    if (choice3 == 1) {
                        classesMethods.showAllClassNotes();
                    } else if (choice3 == 2) {
                        studentMethods.updateStudentNote();
                    } else {
                        System.out.println("Make a valid keystroke");
                    }
                    break;
                case 5:
                    teacherMethods();
                    break;
                case 6:
                    reportMethods();
                    break;
                case 7:
                    financeMethods();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
        //Cihan Guler 479 - 679
    }

    private void studentMethods() {
        System.out.println("Student Operation Menu");
        boolean exit = false;
        while (!exit) {
            System.out.println("===Student Operations===");
            System.out.println("1. Add a new student");
            System.out.println("2. Delete Student By ID");
            System.out.println("3. Update Student By ID");
            System.out.println("4. Find Student");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentMethods.addSomeoneInfo();
                case 2:
                    studentMethods.removeSomeoneInfo();
                    break;
                case 3:
                    studentMethods.updateSomeoneInfo();
                    break;
                case 4:
                    System.out.println("Enter student ID to find : ");
                    int studentid = scanner.nextInt();
                    scanner.nextLine();
                    studentMethods.getSomeoneInfo(studentid);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
                    break;
            }
        }
    }

    private void teacherMethods() {
        System.out.println("Teacher Operation Menu");
        boolean exit = false;
        while (!exit) {
            System.out.println("===Teacher Operations/Informations===");
            System.out.println("1. See your personal information");
            System.out.println("2. Add a new Teacher");
            System.out.println("3. Delete Teacher By ID");
            System.out.println("4. Update Teacher By ID");
            System.out.println("5. Find Teacher");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //See your personal information
                    //bütün öğretmenleri gösteren method var mı? yok galiba!
                case 2:
                    teacherMethods.addSomeoneInfo();
                    break;
                case 3:
                    teacherMethods.removeSomeoneInfo();
                    break;
                case 4:
                    teacherMethods.updateSomeoneInfo();
                    break;
                case 5:
                    System.out.println("Enter teacher ID to find : ");
                    int teacherId = scanner.nextInt();
                    scanner.nextLine();
                    teacherMethods.getSomeoneInfo(teacherId);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
                    break;
            }
        }
    }

    private void reportMethods() {
        System.out.println("Report Operation Menu");
        boolean exit = false;
        while (!exit) {

            System.out.println("===Report Operations===");
            System.out.println("1. show success according to course");
            System.out.println("2. show class success");
            System.out.println("3. show student success");
            System.out.println("4. Show students according to their success");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reportMethods.showLessonSuccess();
                case 2:
                    reportMethods.showClassSuccess();
                    break;
                case 3:
                    reportMethods.showStudentSuccess();
                    break;
                case 4:
                    reportMethods.showStudentRank();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
                    break;
            }
        }
    }

    private void financeMethods() {
        System.out.println("Finance Operation Menu");
        boolean exit = false;
        while (!exit) {

            System.out.println("===Finance Operations===");
            System.out.println("1. Show Income Table");
            System.out.println("2. Show Expense Table");
            System.out.println("3. Show Payment Tracking Table");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    financeMethods.showIncomeTable();
                case 2:
                    financeMethods.showExpenseTable();
                    break;
                case 3:
                    financeMethods.showPaymentTrackingTable();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
                    break;
            }
        }
    }

}