package service;

import config.Scanner_Utils;
import domain.*;
import domain.Lessons;
import domain.Student;
import domain.SuccessDegree;
import exceptions.StudentNotFoundException;
import repository.StudentRepository;

import java.util.Map;
import java.util.Scanner;
public class StudentMethods implements Login<Student>, SameOperations  {
    private final Scanner scanner;
    private final StudentRepository studentRepository;
    public StudentMethods(Scanner scanner, StudentRepository studentRepository) {
        this.scanner = scanner;
        this.studentRepository = studentRepository;
    }

    //TODO Ersagun Eryildiz 17-67
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




    //TODO Gaukhar Ergin 70-170

    @Override
    public void login() {
        /*
        1. burada ogrenciden ogrenci id alinacak.
        2. daha sonra yukaridaki find methodu cagrilacak.
        3. return olarak gelen obje null degilse sifre sorulacak.
        4. sifre dogru ise SchoolManagementSystem clasindaki studentPage methodu burada cagrilacak.
        5. sifre yanlis ise yanlis oldugu soylenecek ve devam etmek / cikis yapmak isteyip istemedigi sorulacak ona gore dongu devam edecek.
         */


        System.out.println("Öğrienci id'sini giriniz");
        int id=scanner.nextInt();

        Student foundedStudent=find(id);

        if(foundedStudent!=null) {
           boolean girisBasarili=false;
            do {
                System.out.println("Öğrenci Şifrenizi Giriniz :");
                String sifre = scanner.nextLine();

                if (sifre.equals(foundedStudent.getPassword())) {

                    studentRepository.find(id);

                } else {
                    System.out.println("Şifreyi yanlış girdiniz!...");
                    System.out.println("Tekrar denemek için  't' ,çıkış yapmak için 'c' giriniz: ");
                    char secim = scanner.next().charAt(0);
                    scanner.nextInt();

                    if (secim == 'c' || secim =='C') {
                        System.out.println("Çıkış yapılıyor....");
                    }
                }

            } while (!girisBasarili) ;



        }























































    // Gaukhar Ergin 70-170
}

    //TODO Husnu Sen 174- 274
    @Override
    public void addSomeoneInfo() {
//Husnu Sen 174- 274
        /*
        1. burada eklenecek ogrencinin tum bilgileri sirasiyla alinacak ve obje olusturulacak
        2. ogrencinin odemesi gereken para miktarini bu classta yer alan setStudentPrice methodunu kullanarak hesaplayacaksin
        3. daha sonra StudentRepository clasindaki addRepoSomeoneInfo methodu cagrilacak ve ogrenci dbye kayit edilecek.
        4. ogrenci basariyla kaydedildi diye sout atilacak.

         */

       //   public Student(String name, String surName, String password, String address, String phoneNumber,
       //       UserRol role, int studentID, Grades grade, double lastYearGradeAvg, double payment, HashMap<Integer,
       //       Lessons> allLessons, HashMap<Integer, Attendance> historyAttendance) {
       //   super(name, surName, password, address, phoneNumber, role);
       //   this.studentID = studentID;
       //   this.grade = grade;
       //   this.lastYearGradeAvg = lastYearGradeAvg;
       //   this.payment = payment;
       //   this.allLessons = allLessons;
       //   this.historyAttendance = historyAttendance;
       //   this.lessonCredit = 20;
       //   this.totalPrice = 0;
       //   this.thisYearGradeAvg = 0;
       //       }


        System.out.println("Lütfen eklemek istediğiniz  öğrenci adını giriniz: " );
        String name = scanner.nextLine().trim();
        System.out.println("Lütfen eklemek istediğiniz  öğrenci soyadını giriniz: ");
        String surName = scanner.nextLine().trim();
        System.out.println("Lütfen eklemek istediğiniz  öğrenci password giriniz : ");
        String password = scanner.nextLine().trim();
        System.out.println("Lütfen eklemek istediğiniz  öğrenci adresini giriniz : ");
        String address = scanner.nextLine().trim();
        System.out.println("Lütfen eklemek istediğiniz  öğrenci telefon numarasını giriniz : ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Lütfen öğrencinin ödeyeceği toplam miktarı girin");
        double payment = Scanner_Utils.doubleScanner(scanner);
        boolean sinifBelirleme=false;
        Grades stdgrades = null;
        do  {
            System.out.println("Kaçıncı sınıfa kaydetmek istersiniz");
            int sinif = Scanner_Utils.intScanner(scanner);//


            if (sinif > 0 && sinif < 6) {



                switch (sinif) {
                    case 1:
                        stdgrades = Grades.GRADE1;
                        sinifBelirleme=true;
                        break;
                    case 2:
                        stdgrades = Grades.GRADE2;
                        sinifBelirleme=true;
                        break;
                    case 3:
                        stdgrades = Grades.GRADE3;
                        sinifBelirleme=true;
                        break;
                    case 4:
                        stdgrades = Grades.GRADE4;
                        sinifBelirleme=true;
                        break;
                    case 5:
                        stdgrades = Grades.GRADE5;
                        sinifBelirleme=true;
                        break;
                    default: stdgrades=null;

                }

            } else {
                System.out.println("geçerli bir sınıf bilgisi giriniz");
            }

        }while (!sinifBelirleme);

        System.out.println("Lütfen eklemek istediğiniz  öğrenci Id sini girin : ");
        Integer studentID =  scanner.nextInt();

        System.out.println("Lütfen eklemek istediğiniz  öğrencinin geçen yılki ort. girin: ");
        double lastYearGradeAvg = Scanner_Utils.doubleScanner(scanner);



                Student student = new Student(name,surName,password,address,phoneNumber,UserRol.STUDENT,studentID,stdgrades,lastYearGradeAvg,payment);

                 studentRepository.addRepoSomeoneInfo(student);



      //  String name, String surName, String password, String address, String phoneNumber,
      //          UserRol role, int studentID, Grades grade, double lastYearGradeAvg, double payment, HashMap<Integer,
      //          Lessons> allLessons, HashMap<Integer, Attendance> historyAttendance)


//Husnu Sen 174- 274
    }
    //TODO Caner Unal 277- 327
    @Override
    public void removeSomeoneInfo() {
        //Caner Unal 277- 327
        /*
        1. once silinecek ogrencinin id alinacak
        2. StudentMethods icindeki find methodu ile o ogrenci bulunacak
        3. daha sonra StudentRepository clasindaki removeRepoSomeoneInfo methodu cagrilarak ogrenci silinecek
        */

        System.out.println("Please enter the ID of the student you want to delete.");
        int id= Scanner_Utils.intScanner(scanner);

        if(find(id)!=null){
            studentRepository.removeRepoSomeoneInfo(find(id));
        }
































        //Caner Unal 277- 327
    }

    //TODO  Seval Senturk 328 - 480
    @Override
    public void updateSomeoneInfo() {
/*
        1. once ogrencinin id alinacak
        2. StudentMethods icindeki find methodu ile o ogrenci bulunacak
        3. daha sonra update edilecek islem sorulacak
        4. StudentRepository clasindaki updateRepoSomeoneInfo methodu cagrilarak ogrenci bilgisii update edilecek
        choice 1 ise Adres, 2 ise sınıf, 3 ise ucret, 4 ise notu,  5 ise basari durumu
         */

        System.out.println("Öğrencinin id'sini giriniz...");
        int studentId=Scanner_Utils.intScanner(scanner);

        Student studentToUpdate=find(studentId);

        if(studentToUpdate != null) {

            System.out.println("Güncellenecek bilgiyi seçiniz : ");
            System.out.println("1. Adres\n2. Sınıf\n3. Ücret\n4. Notu\n5. Başarı Durumu");

            int choice = Scanner_Utils.intScanner(scanner);

            switch (choice) {
                case 1:
                    System.out.println("Please Enter New Adress : ");
                    String newAddress = scanner.nextLine();
                    studentToUpdate.setAddress(newAddress);
                    studentRepository.updateAdressInfo(studentToUpdate, newAddress);
                    break;
                case 2:
                    System.out.println("Please Enter New Grade :");
                    for (Grades grades : Grades.values()) {
                        System.out.println(grades.name());
                    }
                    int gradeChoice = Scanner_Utils.intScanner(scanner);
                    Grades newGrade = Grades.values()[gradeChoice - 1];
                    studentToUpdate.setGrade(newGrade);
                    studentRepository.updateClassInfo(studentToUpdate, newGrade);
                    break;
                case 3:
                    System.out.println("Please Enter New Payment: ");
                    double newFee = Scanner_Utils.doubleScanner(scanner);
                    studentToUpdate.setPayment(newFee);
                    studentRepository.updateFeeInfo(studentToUpdate, newFee);
                    break;
                case 4:
                    System.out.println("Which lesson's Note do you want to update?");
                    for (Lessons lesson : studentToUpdate.getAllLessons().values()) {
                            System.out.println(lesson.getName().name());

                    }
                    String lessonChoice = scanner.nextLine();

                    if (studentToUpdate.getAllLessons().containsKey(lessonChoice)) {
                        Lessons selectedLesson = studentToUpdate.getAllLessons().get(lessonChoice);

                        System.out.println("Please Enter New Note: ");
                        int newNote = Scanner_Utils.intScanner(scanner);

                        // İlgili dersin notunu güncelle
                        selectedLesson.setStudentNote(newNote);

                        studentRepository.updateLessonNoteInfo(studentToUpdate, selectedLesson, newNote);

                        System.out.println("Student Note Information Updated !");
                    } else {
                        System.out.println("Invalid lesson Selection!");
                    }
                    break;
                case 5:
                    System.out.println("Which lesson's Success Degree do you want to update?");
                    //Lessons lesson= studentToUpdate.getAllLessons().values();
                    for (Lessons lesson : studentToUpdate.getAllLessons().values()) {
                        System.out.println(lesson.getName().name());
                    }

                    String lessonChoiceForSuccess = scanner.nextLine();

                    if (studentToUpdate.getAllLessons().containsKey(lessonChoiceForSuccess)) {
                        Lessons selectedLesson = studentToUpdate.getAllLessons().get(lessonChoiceForSuccess);

                        System.out.println("Yeni Başarı Durumu Giriniz: ");
                        int SuccessDegree = Scanner_Utils.intScanner(scanner);

                        SuccessDegree newSuccessDegree = domain.SuccessDegree.values()[SuccessDegree - 1];

                        // İlgili dersin başarı durumunu güncelle
                        selectedLesson.setLessonSuccessDegree(newSuccessDegree);

                        studentRepository.updateSuccessDegreeInfo(studentToUpdate, selectedLesson, newSuccessDegree);

                        System.out.println("Student Success Degree Information Updated !");
                    } else {
                        System.out.println("Invalid lesson Selection!");
                    }
                        break;
                    }
                    System.out.println("Student update successful");
            } else{
                System.out.println("The Student you were looking for with " + studentId + " could not be found");
            }

















































        // Seval Senturk 328 - 480
    }



    //TODO  Zehra Erol 482 - 532
    @Override
    public void getSomeoneInfo(int id) {

        /*
        1. StudentRepository clasindaki getRepoSomeoneInfo methodu cagrilacak */

        studentRepository.getRepoSomeoneInfo(id);









































// Zehra Erol
}

    //TODO Hanife Ocak 534 - 584
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

    //TODO  Husnu Sen 586 - 686
    public SuccessDegree setAndReturnSuccessDegree(Student student, Lessons lessons,int not){


       // Husnu Sen 586 - 686


        // StudentRepository clasindaki updateSuccessDegreeInfo methodu olarak cagrilarak


        // StudentRepository clasindaki updateRepoSomeoneInfo methodu choice 5 olarak cagrilarak


        //bu method ogrenci notunu update ederken cagrilacak ona gore basarisi update edilmis olacak
        //burada ogrencinin ders basari durumu da girilecek



        if (not >=80 && not<101){
            studentRepository.updateSuccessDegreeInfo(student,lessons,SuccessDegree.A);
           return SuccessDegree.A;
        }else if (not>=60&&not<80){
            studentRepository.updateSuccessDegreeInfo(student,lessons,SuccessDegree.B);
            return SuccessDegree.B;
        } else if (not>=40&&not<60) {
            studentRepository.updateSuccessDegreeInfo(student,lessons,SuccessDegree.C);
            return SuccessDegree.C;

        } else if (not>=20&&not<40) {
            studentRepository.updateSuccessDegreeInfo(student,lessons,SuccessDegree.D);
            return SuccessDegree.D;
        } else if (not>=0&&not<20) {
            studentRepository.updateSuccessDegreeInfo(student,lessons,SuccessDegree.F);
            return SuccessDegree.F;
        }


      return null;






























































        // Husnu Sen 586 - 686
    }

    //TODO Omer Faruk Osmanoglu 688 - 788
    public void setStudentPercentDiscount(Student student, double lastYearGradeAvg){

    //student.setPercentDiscount(); method ismi degisecek unutma
//Omer Faruk Osmanoglu 688 - 788
        //ogrencinin gecen yil ki ortalamasina gore indirim miktari set edilecek.


        //ogrencinin toplam odeyecegi miktar set edilmis olacak

        //kac puan araligina ne kadar indirim yapilacagini bu methodu yazan arkadas takdir edecek.
        //bu method yardimci method olarak ogrenci kaydi yapilirken cagrilacak.
        //student.setPercentDiscount();

    if(lastYearGradeAvg>90){
        student.setPercentDiscount(20);
    } else if (lastYearGradeAvg>80) {
        student.setPercentDiscount(10);
    } else if (lastYearGradeAvg>70) {
        student.setPercentDiscount(5);
    }



//Omer Faruk Osmanoglu 688 - 788
    }

}
