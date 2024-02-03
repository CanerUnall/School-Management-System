package service;

import controller.SchoolManagementSystem;
import domain.Admins;
import repository.AdminRepository;

import java.util.Scanner;

public class AdminMethods implements Login<Admins>{
    private final Scanner scanner;
    private final AdminRepository adminRepository;

    public AdminMethods(Scanner scanner, AdminRepository adminRepository) {
        this.scanner = scanner;
        this.adminRepository = adminRepository;
    }

    // Mustafa Ubeyde Kayhan 17 -  67
    @Override
    public Admins find(int id) {
        //burada AdminRepository nin find methodu cagrilacak ve oradan alinan obje return edilecek
        //Nesibe hoca hotel sisteminde exceptionslarin pratigini yaptirmisti. biz de burada exceptions attiracagiz.

        return null;











































        // Mustafa Ubeyde Kayhan 7 -  57
    }

    //Omer Faruk Osman Oglu 70 - 170
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
            int adminId = scanner.nextInt();

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
                    System.out.println("Incorrect password. Do you want to continue (Y/N)?");
                    String choice = scanner.next();
                    if (!choice.equalsIgnoreCase("Y")) {
                        loggedIn = true; // Exit loop if choice is not "Y"
                    }
                }
            } else {
                System.out.println("Admin not found. Do you want to continue (Y/N)?");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("Y")) {
                    loggedIn = true; // Exit loop if choice is not "Y"
                }
            }
        } while (!loggedIn);
    }
























































































        //Omer Faruk Osman Oglu 60 - 160
    }

