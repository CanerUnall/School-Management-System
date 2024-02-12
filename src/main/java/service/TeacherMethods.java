package service;

import config.Scanner_Utils;
import controller.SchoolManagementSystem;
import domain.Grades;
import domain.LessonNames;
import domain.Teacher;
import domain.UserRol;
import exceptions.TeacherNotFoundException;
import repository.TeacherRepository;

import java.sql.SQLException;
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
        try {
            Teacher foundTeacher = teacherRepository.find(id);
            if (foundTeacher != null) {
                return foundTeacher;
            } else {
                throw new TeacherNotFoundException("Teacher not found with ID :" + id);
            }
        } catch (TeacherNotFoundException e) {
            System.out.println("Hata: " + e.getMessage());
        }
        return null;
    }


    @Override
    public void login() {

        System.out.println("Please enter teacher Id!");
        int teacherId = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();
        Teacher foundedTeacher = find(teacherId);

        if (foundedTeacher != null) {
            boolean girisBasarili = false;

            do {
                System.out.println("Enter the password of the student...");
                String inputPassword = scanner.nextLine();
                if (inputPassword.equals(foundedTeacher.getPassword())) {
                    SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem();
                    schoolManagementSystem.teacherPage(foundedTeacher);
                } else {
                    System.out.println("Wrong password!...");
                    System.out.println("Enter 't' to try again, 'c' to exit: ");
                    char secim = scanner.next().charAt(0);
                    scanner.nextLine();

                    if (secim == 'c' || secim == 'C') {
                        girisBasarili = true;
                        System.out.println("Signing out....");
                    }
                }
            } while (!girisBasarili);
        }
    }


    @Override
    public void addSomeoneInfo() {

        Teacher teacher = new Teacher();
        System.out.print("Enter teacher name: ");
        teacher.setName(scanner.nextLine());
        System.out.print("Enter teacher surname: ");
        teacher.setSurName(scanner.nextLine());
        System.out.print("Enter teacher password: ");
        teacher.setPassword(scanner.nextLine());
        System.out.print("Enter teacher phone number: ");
        teacher.setPhoneNumber(scanner.nextLine());
        teacher.setRole(UserRol.TEACHER);
        System.out.print("Enter teacher address: ");
        teacher.setAddress(scanner.nextLine());
        System.out.print("Enter teacher salary: ");
        teacher.setSalary(Scanner_Utils.doubleScanner(scanner));

        System.out.print("Enter teacher branch: ");
        int x = 1;
        for (LessonNames lessonNames : LessonNames.values()) {
            System.out.println(x + " " + lessonNames.name());
            x++;
        }
        int gradeChoice = Scanner_Utils.intScanner(scanner);
        scanner.nextLine();
        teacher.setBranch(LessonNames.values()[gradeChoice - 1].name());

        int teacherID = Teacher.getTeacherRegistrationNumber() + getAllTeacher().size();
        teacher.setTeacherID(teacherID);

        teacherRepository.addRepoSomeoneInfo(teacher);

        System.out.println("\n\nTeacher saved successfully");
        System.out.print("New teacher's ID: " + teacherID);
    }


    @Override
    public void removeSomeoneInfo() {

        System.out.println("Silinecek Öğretmenin id'sini Giriniz"); //ilk olarak kullanıcıdan silinecek öğretmenin id'sini alalım
        int id = Scanner_Utils.intScanner(scanner); // aldığımız id'yi scanner ekleyelim
        scanner.nextLine();
        Teacher foundedTeacher = find(id); //teacher tipinde  foundedTeacher field oluşturuyoruz ve silinecek hocayı find methodu bu field'a eşitliyoruz
        teacherRepository.removeRepoSomeoneInfo(foundedTeacher); // teacher repository den aldığımız removeRepoSomeoneInfo methodu ile siliyoruz.

    }


    @Override
    public void updateSomeoneInfo() {

        System.out.println(" Enter the teacher's id: ");
        int id = Scanner_Utils.intScanner(scanner);// aldığımız id'yi scanner ekleyelim
        scanner.nextLine();
        Teacher foundTeacher = teacherRepository.find(id);

        if (foundTeacher != null) {
            // 3. Güncellenecek işlemi sor
            System.out.println("Select update information: ");
            System.out.println("1. Address");
            System.out.println("2. Branch");
            System.out.println("3. Salary");
            int choice = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();
            // 4. TeacherRepository sınıfındaki updateRepoSomeoneInfo metodunu çağırarak öğretmen bilgisini güncelle


            switch (choice) {
                case 1:
                    System.out.println("Enter new address:");
                    String newAddress = scanner.nextLine();
                    teacherRepository.updateAdressInfo(foundTeacher, newAddress);
                    break;
                case 2:
                    System.out.println("Enter new branch:");
                    int x = 1;
                    for (LessonNames lessonNames : LessonNames.values()) {
                        System.out.println(x + " " + lessonNames.name());
                        x++;
                    }
                    int gradeChoice = Scanner_Utils.intScanner(scanner);
                    scanner.nextLine();
                    String newBranch = LessonNames.values()[gradeChoice - 1].name();
                    teacherRepository.updateBranchInfo(foundTeacher, newBranch);
                    break;
                case 3:
                    System.out.println("Enter new salary:");
                    double newSalary = Scanner_Utils.doubleScanner(scanner);
                    scanner.nextLine();
                    teacherRepository.updateSalaryInfo(foundTeacher, newSalary);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } else {
            System.out.println("Not teacher found!.");
        }
    }


    @Override
    public void getSomeoneInfo(int id) {

        teacherRepository.getRepoSomeoneInfo(id);

    }


    public List<Teacher> getAllTeacher() {

        List<Teacher> teachers;

        teachers = teacherRepository.getAllTeacher();

        return teachers;

    }

}
