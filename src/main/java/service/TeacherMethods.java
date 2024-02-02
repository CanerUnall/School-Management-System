package service;

import domain.Teacher;
import repository.TeacherRepository;

import java.util.List;
import java.util.Scanner;

public class TeacherMethods implements Login<Teacher>, SameOperations {
    private final TeacherRepository teacherRepository;
    private final Scanner scanner;

    public TeacherMethods(TeacherRepository teacherRepository, Scanner scanner) {
        this.teacherRepository = teacherRepository;
        this.scanner = scanner;
    }

    @Override
    public Teacher find(int id) {
        // Umut Ayaz 18 -68
        //burada TeacherRepository nin find methodu cagrilacak ve oradan alinan obje return edilecek
        //Nesibe hoca hotel sisteminde exceptionslarin pratigini yaptirmisti. biz de burada exceptions attiracagiz.
        return null;












































        // Umut Ayaz 18 -68
    }

    @Override
    public void login() {
        //Rumeysa Dagtekin 71 - 171
/*
1. burada ogretmen ogrenci id alinacak.
2. daha sonra yukaridaki find methodu cagrilacak.
3. return olarak gelen obje null degilse sifre sorulacak.
4. sifre dogru ise SchoolManagementSystem clasindaki teacherPage methodu burada cagrilacak.
5. sifre yanlis ise yanlis oldugu soylenecek ve devam etmek / cikis yapmak isteyip istemedigi sorulacak ona gore dongu devam edecek.
        */


























































































        //Rumeysa Dagtekin 71 - 171
    }

    @Override
    public void addSomeoneInfo() {
    /* Mustafa Ubeyde Kayhan 174- 274
        1. burada eklenecek ogretmenin tum bilgileri sirasiyla alinacak ve obje olusturulacak
        2. daha sonra TeacherRepository clasindaki addRepoSomeoneInfo methodu cagrilacak.
        3. ogretmen basariyla kaydedildi diye sout atilacak.

         */




























































































        //Mustafa Ubeyde Kayhan 174- 274
    }

    @Override
    public void removeSomeoneInfo() {
/* Gaukhar Ergin 277 - 377
        1. once silinecek ogretmenin id alinacak
        2. TeacherMethods icindeki find methodu ile o ogretmen bulunacak
        3. daha sonra TeacherRepository clasindaki removeRepoSomeoneInfo methodu cagrilarak öğretmen silinecek

         */

        System.out.println("Silinecek Öğretmenin id'sini Giriniz");//ilk olarak kullanıcıdan silinecek öğretmenin id'sini alalım
        int id=scanner.nextInt();// aldığımız id'yi scanner ekleyelim
        Teacher foundedTeacher=find(id);//teacher tipinde  foundedTeacher field oluşturuyoruz ve silinecek hocayı find methodu bu field'a eşitliyoruz
        teacherRepository.removeRepoSomeoneInfo(foundedTeacher);// teacher repository den aldığımız removeRepoSomeoneInfo methodu ile siliyoruz.






















































































        //Gaukhar Ergin 277 - 377
    }

    @Override
    public void updateSomeoneInfo() {
        //Ersagun Eryildiz 380 - 580
/*
        1. once ogretmenin id alinacak
        2. TeacherMethods icindeki find methodu ile o ogrenci bulunacak
        3. daha sonra update edilecek islem sorulacak
        4. TeacherRepository clasindaki updateRepoSomeoneInfo methodu cagrilarak ogrenci bilgisii update edilecek
        choice 1 ise Adres, 2 ise brans, 3 ise ucret
         */






























































































































































































        //Ersagun Eryildiz  380 - 580
    }

    @Override
    public void getSomeoneInfo(int id) {
        // Seval Senturk 583 - 683
/*1. once ogretmenin id alinacak
        2. TeacherRepository clasindaki getRepoSomeoneInfo methodu cagrilacak */































































































// Seval Senturk 583 - 683
    }

    public List<Teacher> getAllTeacher(){
        // Caner Unal 686 - 786
        //burada reTeacherRepository clasindaki getAllTeacherRepo methodu cagrilacak
        return null;































































































        // Caner Unal 686 - 786
    }
}