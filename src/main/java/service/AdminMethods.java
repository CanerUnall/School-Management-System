package service;

import config.Scanner_Utils;
import controller.SchoolManagementSystem;
import domain.Admins;
import exceptions.AdminNotFoundException;
import repository.AdminRepository;

import java.util.Scanner;

public class AdminMethods implements Login<Admins>{
    private final Scanner scanner;
    private final AdminRepository adminRepository;

    public AdminMethods(Scanner scanner, AdminRepository adminRepository) {
        this.scanner = scanner;
        this.adminRepository = adminRepository;
    }

    //TODO  Mustafa Ubeyde Kayhan 17 -  67
    @Override
    public Admins find(int id) {

        Admins foundedAdmin=adminRepository.find(id);

        if(foundedAdmin==null){
            throw new AdminNotFoundException("Admin not found");
        }else return foundedAdmin;





























        // Mustafa Ubeyde Kayhan 7 -  57
    }

    //TODO Omer Faruk Osman Oglu 70 - 170
    @Override
    public void login() {
/*
1. burada yoneticiden id alinacak.
2. daha sonra yukaridaki find methodu cagrilacak.
3. return olarak gelen obje null degilse sifre sorulacak.
4. sifre dogru ise SchoolManagementSystem clasindaki adminPage methodu burada cagrilacak.
5. sifre yanlis ise yanlis oldugu soylenecek ve devam etmek / cikis yapmak isteyip istemedigi sorulacak ona gore dongu devam edecek.
        */


        boolean loggedIn = false;
        do {
            System.out.println("Please enter your admin ID: ");
            int adminId = Scanner_Utils.intScanner(scanner);

            // Find admin by ID
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
                    SchoolManagementSystem schoolManagementSystem=new SchoolManagementSystem();
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


    }

