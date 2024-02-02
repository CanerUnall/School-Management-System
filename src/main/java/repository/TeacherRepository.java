package repository;

import domain.Teacher;

public class TeacherRepository implements SameRepoOperations<Teacher>{



    // Umut Ayaz 10 -110
    public void createTeacherTable(){
      /*  bu methodun query si yazilirken if not exist kullanilacak

        tablo adi = t_teacher

        teacherID bu pk olacak

        tchr_name,
        tchr_surName
        password
        address
        phoneNumber
        role
        salary
        branch

                */

















































































        // Umut Ayaz 10 -110
    }

    // Umut Ayaz 113-213
    @Override
    public Teacher find(int id) {

        return null;
































































































        // Umut Ayaz 113-213
    }

    //Mustafa Ubeyde Kayhan 216- 2316
    @Override
    public void addRepoSomeoneInfo(Teacher person) {



































































































        // Mustafa Ubeyde Kayhan 216- 316
    }

    //Gaukhar Ergin 320 420
    @Override
    public void removeRepoSomeoneInfo(Teacher person) {


































































































// Gaukhar Ergin 320 420
    }

    //Ersagun Eryildiz 423 - 623
    @Override
    public void updateAdressInfo(Teacher person, String adress) {

// choice 1 ise adres, 2 ise brans, 3 ise maas update edilsin


        /*if (person != null) {
            int choice = 1; // Güncelleme seçeneği (1: Adres, 2: Branş, 3: Maaş)

            switch (choice) {
                case 1:
                    person.setAddress(address);
                    System.out.println("Updated address information: " + address);
                    break;
                case 2:
                   // Branch branch = new Branch();
                    branch.setBranch(branch);
                    System.out.println("Updated branch information: " + branch);
                    break;
                case 3:
                    //Salary salary = new Salary();
                    salary.setSalary(salary);
                    System.out.println("Updated salary information: " +salary);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } else {
            System.out.println("Invalid teacher information!");
        }
    }*/













































































































































































        //Ersagun Eryildiz 423 - 623
    }

    public void updateBranchInfo(Teacher person, String branch) {

    }

    public void updateSalaryInfo(Teacher person, double salary) {

    }

    // Seval Senturk 626 - 726
    @Override
    public void getRepoSomeoneInfo(int id) {
































































































// Seval Senturk 626 - 726

    }




    //728- 828 arasi tum ogretmenleri get edecek methodu yaz Caner Unal
}
