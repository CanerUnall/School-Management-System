package controller;

import domain.Admins;
import domain.Student;
import domain.Teacher;
import repository.StudentRepository;
import service.StudentMethods;

public class SchoolManagementSystem {

    private static StudentRepository studentRepository;

    public SchoolManagementSystem(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    static {

        //burada db ile alakali create methodlarindan birkaci cagrilsin.
    }

    static void twoThreads(){
        // Omer Faruk Osmanoglu

        /*
        2 adet thread olusturulacak
        ilk thread icinde db ile alakali create methodlarinin gerisi cagrilsin.
        ikinci thread de ise bizim uygulamamizin starti buradan baslasin
         */



























































































        //21-121 // Omer Faruk Osmanoglu
    }

    static void homePage() {
        //Semra Zengin 123-223

        // kullanicinin ana sayfada gormesi gerekenleri bir dongu ile yazdir.
        /*ogrenci olarak giris yap (ogrenci login  methodu burada cagrilacak)
         * ogretmen olarak giris yap (ogretmen login methodu burada cagrilacak)
         * yonetici olarak giris yap (admin login methodu burada cagrilacak)
         * cikis
         * */





















































































        //Semra Zengin 123-223
    }
    
    static void studentPage(Student student){
        /* Hanife Ocak 225-325

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

    static void teacherPage(Teacher teacher){
        /* Emrah Kaya 327 -477
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

    static void adminPage(Admins admins){
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


































































































































































        //Cihan Guler 479 - 679
    }



}
