package service;

import config.Scanner_Utils;
import domain.Lessons;
import domain.Student;
import domain.SuccessDegree;
import exceptions.StudentNotFoundException;
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
      //  return null;


            Student foundStudent = studentRepository.find(id);
            try {
                if (foundStudent != null) {
                    System.out.println("---------------------------------------------");
                    System.out.println(foundStudent);
                    System.out.println("---------------------------------------------");
                    return foundStudent;
                } else {
                    throw new StudentNotFoundException("Student not found by id : " + id);
                }
            }catch (StudentNotFoundException e){
                System.out.println(e.getMessage());
            }
            return null;
//---------------------------

























        //Ersagun Eryildiz 17-67
    }

    //Gaukhar Ergin 70-170
    @Override
    public void login() {
        /*
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

    // Zehra Erol 482 - 532
    @Override
    public void getSomeoneInfo(int id) {

        /*
        1. once ogrencinin id alinacak

        2. StudentRepository clasindaki getRepoSomeoneInfo methodu cagrilacak */

        System.out.println("Öğrencinin id'sini giriniz...");//ilk olarak 
         id=scanner.nextInt();

        studentRepository.getRepoSomeoneInfo(id);













































// Zehra Erol 482 - 532
    }

    //Hanife Ocak 534 - 584
    public void updateStudentNote(){
                /*
        1. once ogrencinin id alinacak
        2. StudentMethods icindeki find methodu ile o ogrenci bulunacak
        3. daha sonra hangi ders notunu update etmek istedigi sorulacak
        4. StudentRepository clasindaki updateRepoSomeoneInfo methodu choice 4 olarak cagrilarak
        5. ogrenci notu update edildikten sonra bu classtaki alttaki setAndReturnSuccessDegree methodu cagrilacak


         */




































        //Hanife Ocak 534 - 584

    }

    // Husnu Sen 586 - 686
    public SuccessDegree setAndReturnSuccessDegree(Student student, Lessons lessons,int not){

        // StudentRepository clasindaki updateRepoSomeoneInfo methodu choice 5 olarak cagrilarak

        //bu method ogrenci notunu update ederken cagrilacak ona gore basarisi update edilmis olacak
        //burada ogrencinin ders basari durumu da girilecek

        return null;
























































































        // Husnu Sen 586 - 686
    }

    //Omer Faruk Osmanoglu 688 - 788
    public void setStudentPrice(Student student, double lastYearGradeAvg){

    //student.setPercentDiscount(); method ismi degisecek unutma
//Omer Faruk Osmanoglu 688 - 788
        //ogrencinin gecen yil ki ortalamasina gore indirim miktari set edilecek.


        //ogrencinin toplam odeyecegi miktar set edilmis olacak

        //kac puan araligina ne kadar indirim yapilacagini bu methodu yazan arkadas takdir edecek.
        //bu method yardimci method olarak ogrenci kaydi yapilirken cagrilacak.
        //student.setPercentDiscount();
































































































//Omer Faruk Osmanoglu 688 - 788
    }

}
