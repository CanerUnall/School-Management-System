package service;

import domain.Grades;
import repository.ClassesRepository;
import java.util.Scanner;

public class ClassesMethods {
    private final ClassesRepository classesRepository;
    private final Scanner scanner;

    public ClassesMethods(ClassesRepository classesRepository, Scanner scanner) {
        this.classesRepository = classesRepository;
        this.scanner = scanner;
    }

    //Hanife Ocak 16-116
    public void showAllClassNotes(){
        //burada once hangi sinifin notlarini gormek istedigi sorulacak
        //daha sonra hangi dersin notlarini gormek istedigi sorulacak
        // daha sonra secilen sinifa ve derse gore
        // ClassesRepository clasindaki getAllClassNotes methodu cagrilacak






























































































        // Hanife Ocak 6-106
    }

    //Seval Senturk 119 - 219
    public void showAllStudentInfo(){

        /*once hangi sinifa ait ogrencilerin bilgilerini gormek istedigini sorsun
        daha sonra ClassesRepository clasindaki getAllClassInfo methodu cagrilacak */


        // Hangi sınıfa ait öğrenci bilgilerini görmek istediğini kullanıcıdan al
        System.out.println("Hangi sınıfa ait öğrenci bilgilerini görmek istersiniz?");
        String inputName = scanner.nextLine();

     // Kullanıcının girdiği sınıf adına karşılık gelen enum değerini bul
        Grades grades;
        try {
            grades = Grades.valueOf(inputName.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Geçersiz sınıf adı!");
            return;
        }

        classesRepository.getAllClassInfo(grades);


































































        //Seval Senturk 109 - 209
    }

}
