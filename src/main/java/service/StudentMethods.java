package service;

import config.Scanner_Utils;
import domain.Lessons;
import domain.Student;
import domain.SuccessDegree;
import repository.StudentRepository;

import java.util.Scanner;

public class StudentMethods implements Login<Student>, SameOperations  {
    private final Scanner scanner;
    private final StudentRepository studentRepository;
    public StudentMethods(Scanner scanner, StudentRepository studentRepository) {
        this.scanner = scanner;
        this.studentRepository = studentRepository;
    }
    @Override
    public Student find(int id) {
        //Ersagun Eryildiz 17-67

        //burada StudentRepository nin find methodu cagrilacak ve oradan alinan obje return edilecek
        //Nesibe hoca hotel sisteminde exceptionslarin pratigini yaptirmisti. biz de burada exceptions attiracagiz.
        return null;











































        //Ersagun Eryildiz 17-67
    }

    @Override
    public void login() {
/* Gaukhar Ergin 70-170

1. burada ogrenciden ogrenci id alinacak.
2. daha sonra yukaridaki find methodu cagrilacak.
3. return olarak gelen obje null degilse sifre sorulacak.
4. sifre dogru ise SchoolManagementSystem clasindaki studentPage methodu burada cagrilacak.
5. sifre yanlis ise yanlis oldugu soylenecek ve devam etmek / cikis yapmak isteyip istemedigi sorulacak ona gore dongu devam edecek.
        */

























































































        // Gaukhar Ergin 70-170
    }

    @Override
    public void addSomeoneInfo() {
//Husnu Sen 174- 274
        /*
        1. burada eklenecek ogrencinin tum bilgileri sirasiyla alinacak ve obje olusturulacak
        2. ogrencinin odemesi gereken para miktarini bu classta yer alan setStudentPrice methodunu kullanarak hesaplayacaksin
        3. daha sonra StudentRepository clasindaki addRepoSomeoneInfo methodu cagrilacak ve ogrenci dbye kayit edilecek.
        4. ogrenci basariyla kaydedildi diye sout atilacak.

         */


























































































//Husnu Sen 174- 274
    }

    @Override
    public void removeSomeoneInfo() {
        //Caner Unal 277- 327
        /*
        1. once silinecek ogrencinin id alinacak
        2. StudentMethods icindeki find methodu ile o ogrenci bulunacak
        3. daha sonra StudentRepository clasindaki removeRepoSomeoneInfo methodu cagrilarak ogrenci silinecek
         */










































        //Caner Unal 277- 327
    }
    @Override
    public void updateSomeoneInfo() {
        // Seval Senturk 328 - 478
/*
        1. once ogrencinin id alinacak
        2. StudentMethods icindeki find methodu ile o ogrenci bulunacak
        3. daha sonra update edilecek islem sorulacak
        4. StudentRepository clasindaki updateRepoSomeoneInfo methodu cagrilarak ogrenci bilgisii update edilecek
        choice 1 ise Adres, 2 ise sınıf, 3 ise ucret, 4 ise notu,  5 ise basari durumu
         */












































































































































        // Seval Senturk 328 - 480
    }

    @Override
    public void getSomeoneInfo(int id) {
        // Zehra Erol 482 - 532
/*1. once ogrencinin id alinacak
        2. StudentRepository clasindaki getRepoSomeoneInfo methodu cagrilacak */













































// Zehra Erol 482 - 532
    }
    public void updateStudentNote(){

        //Hanife Ocak 534 - 584
                /*
        1. once ogrencinin id alinacak
        2. StudentMethods icindeki find methodu ile o ogrenci bulunacak
        3. daha sonra hangi ders notunu update etmek istedigi sorulacak
        4. StudentRepository clasindaki updateRepoSomeoneInfo methodu choice 4 olarak cagrilarak
        5. ogrenci notu update edildikten sonra bu classtaki alttaki setAndReturnSuccessDegree methodu cagrilacak


         */




































        //Hanife Ocak 534 - 584

    }

    public SuccessDegree setAndReturnSuccessDegree(Student student, Lessons lessons,int not){

       // Husnu Sen 586 - 686


        // StudentRepository clasindaki updateRepoSomeoneInfo methodu choice 5 olarak cagrilarak

        //bu method ogrenci notunu update ederken cagrilacak ona gore basarisi update edilmis olacak
        //burada ogrencinin ders basari durumu da girilecek

        return null;
























































































        // Husnu Sen 586 - 686
    }

    public void setStudentPrice(Student student, double lastYearGradeAvg){

//Omer Faruk Osmanoglu 688 - 788
        //ogrencinin toplam odeyecegi miktar set edilmis olacak
        //kac puan araligina ne kadar indirim yapilacagini bu methodu yazan arkadas takdir edecek.
        //bu method yardimci method olarak ogrenci kaydi yapilirken cagrilacak.





























































































//Omer Faruk Osmanoglu 688 - 788
    }


}
