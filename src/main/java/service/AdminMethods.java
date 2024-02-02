package service;

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



























































































        //Omer Faruk Osman Oglu 60 - 160
    }
}
