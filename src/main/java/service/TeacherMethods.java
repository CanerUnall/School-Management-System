package service;

import domain.Teacher;
import exceptions.TeacherNotFoundException;
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

    //TODO  Umut Ayaz 18 -68
    @Override
    public Teacher find(int id) {

        //burada TeacherRepository nin find methodu cagrilacak ve oradan alinan obje return edilecek
        //Nesibe hoca hotel sisteminde exceptionslarin pratigini yaptirmisti. biz de burada exceptions attiracagiz.

        try {

            Teacher foundTeacher = teacherRepository.find(id);

            if (foundTeacher!= null){
                System.out.println(foundTeacher);
                return foundTeacher;
            }else {
                throw new TeacherNotFoundException("Teacher not found with ID :" + id);
            }

        } catch (TeacherNotFoundException e) {

            System.out.println("Hata: " + e.getMessage());
        }
        return null;

























        // Umut Ayaz 18 -68
    }

    //TODO Rumeysa Dagtekin 71 - 171
    @Override
    public void login() {
    /*
    1. burada ogretmen ogrenci id alinacak.
    2. daha sonra yukaridaki find methodu cagrilacak.
    3. return olarak gelen obje null degilse sifre sorulacak.
    4. sifre dogru ise SchoolManagementSystem clasindaki teacherPage methodu burada cagrilacak.
    5. sifre yanlis ise yanlis oldugu soylenecek ve devam etmek / cikis yapmak isteyip istemedigi sorulacak ona gore dongu devam edecek.
            */


























































































        //Rumeysa Dagtekin 71 - 171
    }

    //TODO Mustafa Ubeyde Kayhan 174- 274
    @Override
    public void addSomeoneInfo() {
    /*
        1. burada eklenecek ogretmenin tum bilgileri sirasiyla alinacak ve obje olusturulacak
        2. daha sonra TeacherRepository clasindaki addRepoSomeoneInfo methodu cagrilacak.
        3. ogretmen basariyla kaydedildi diye sout atilacak.

         */




























































































        //Mustafa Ubeyde Kayhan 174- 274
    }

    //TODO Gaukhar Ergin 277 - 377
    @Override
    public void removeSomeoneInfo() {
        /*
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

    //TODO Ersagun Eryildiz 380 - 580
    @Override
    public void updateSomeoneInfo() {

        /*
        1. once ogretmenin id alinacak
        2. TeacherMethods icindeki find methodu ile o ogretmen bulunacak
        3. daha sonra update edilecek islem sorulacak
        4. TeacherRepository clasindaki updateRepoSomeoneInfo methodu cagrilarak ogretmen bilgisii update edilecek
        choice 1 ise Adres, 2 ise brans, 3 ise ucret
         */

            System.out.println(" Enter the teacher's id: ");
            int id=scanner.nextInt();// aldığımız id'yi scanner ekleyelim
            Teacher foundTeacher=teacherRepository.find(id);

            if (foundTeacher != null) {


                // 3. Güncellenecek işlemi sor
                System.out.println("Select update information: ");
                System.out.println("1. Address");
                System.out.println("2. Branch");
                System.out.println("3. Salary");
                int choice = scanner.nextInt();

                // 4. TeacherRepository sınıfındaki updateRepoSomeoneInfo metodunu çağırarak öğretmen bilgisini güncelle
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new address:");
                        String newAddress = scanner.nextLine();
                        teacherRepository.updateAdressInfo(foundTeacher,newAddress);
                        break;
                    case 2:
                        System.out.println("Enter new branch:");
                        String newBranch = scanner.nextLine();
                        teacherRepository.updateBranchInfo(foundTeacher,newBranch);
                        break;
                    case 3:
                        System.out.println("Enter new salary:");
                        double newSalary = scanner.nextDouble();
                        teacherRepository.updateSalaryInfo(foundTeacher,newSalary);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } else {
                System.out.println("Not teacher found!.");
            }




















































































































































        //Ersagun Eryildiz  380 - 580
    }

    //TODO  Seval Senturk 583 - 683
    @Override
    public void getSomeoneInfo(int id) {

        //1. TeacherRepository clasindaki getRepoSomeoneInfo methodu cagrilacak */

        teacherRepository.getRepoSomeoneInfo(id);































































































// Seval Senturk 583 - 683
    }

    //TODO  Umut Ayaz 686 - 786
    public List<Teacher> getAllTeacher(){





        //burada reTeacherRepository clasindaki getAllTeacherRepo methodu cagrilacak
        return null;































































































        //Umut Ayaz 686 - 786
    }
}