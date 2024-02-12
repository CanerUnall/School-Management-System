package service;

import config.Scanner_Utils;
import controller.SchoolManagementSystem;
import domain.Admins;
import domain.LessonNames;
import domain.Teacher;
import domain.UserRol;
import exceptions.AdminNotFoundException;
import repository.AdminRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static domain.Admins.getAdminRegistrationNumber;
import static domain.Teacher.getTeacherRegistrationNumber;

public class AdminMethods implements Login<Admins> {
    private final Scanner scanner;
    private final AdminRepository adminRepository;
    private final TeacherMethods teacherMethods;

    public AdminMethods(Scanner scanner, AdminRepository adminRepository, TeacherMethods teacherMethods) {
        this.scanner = scanner;
        this.adminRepository = adminRepository;
        this.teacherMethods = teacherMethods;
    }

    @Override
    public Admins find(int id) {
        try {
            Admins foundedAdmin = adminRepository.find(id);

            if (foundedAdmin == null) {
                throw new AdminNotFoundException("Admin not found");
            } else return foundedAdmin;
        } catch (AdminNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }

    @Override
    public void login() {

        boolean loggedIn = false;
        do {
            System.out.println("Please enter your admin ID: ");
            int adminId = Scanner_Utils.intScanner(scanner);
            scanner.nextLine();
            Admins admin = find(adminId);

            if (admin != null) {
                System.out.println("Please enter your password: ");
                String password = scanner.next();

                // Check if the entered password matches
                if (admin.getPassword().equals(password)) {
                    // Login successful
                    loggedIn = true;
                    System.out.println("Login successful!");
                    // Call adminPage method of SchoolManagementSystem class
                    SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem();
                    schoolManagementSystem.adminPage(admin);
                } else {
                    System.out.println("Incorrect password. Do you want to exit (Y/N)?");
                    String choice = scanner.next();
                    if (!choice.equalsIgnoreCase("Y")) {
                        loggedIn = true; // Exit loop if choice is not "Y"
                    }
                }
            } else {
                System.out.println("Admin not found. Do you want to exit (Y/N)?");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("Y")) {
                    loggedIn = true; // Exit loop if choice is not "Y"
                }
            }
        } while (!loggedIn);


    }

    public void addAllAdmin() {

        if (adminRepository.getRepoAllAdmins().size() < 12) {
            int teacherID = Teacher.getTeacherRegistrationNumber() + teacherMethods.getAllTeacher().size();
            int adminID = Admins.getAdminRegistrationNumber() + adminRepository.getRepoAllAdmins().size();
            adminRepository.addAdminRepo(new Admins("Seval", "Senturk", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.IT.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Mustafa Ubeyde", "Kayhan", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.TURKISH.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Umut", "Ayaz", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.BIOLOGY.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Omer Faruk", "Osmanoglu", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.ENGLISH.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Semra", "Zengin", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.CHEMICAL.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Husnu", "Senturk", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.GEOGRAPHY.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Gaukhar", "Ergin", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.HISTORY.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Ersagun Yavuz", "Eryildiz", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.PHYSICAL.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Rumeysa", "Dagtekin", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.SPORTS.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Zehra", "Erol", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.IT.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Cihan", "Guler", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.IT.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Hanife", "Ocak", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.MATHS.name(), teacherID, adminID));
            teacherID++;
            adminID++;

            adminRepository.addAdminRepo(new Admins("Caner", "Unal", "1234567890", "Dunya", "00000000", UserRol.ADMIN, 9999, LessonNames.MATHS.name(), teacherID, adminID));
        }
    }

}

