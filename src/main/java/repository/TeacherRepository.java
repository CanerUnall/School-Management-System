package repository;
import config.JDBC_Utils;
import domain.Teacher;
import domain.UserRol;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TeacherRepository implements SameRepoOperations<Teacher> {

    //TODO  Umut Ayaz 10 -110
    public void createTeacherTable() {
      /*  bu methodun query si yazilirken if not exist kullanilacak



    public static void createTeacherTable() {
// // Umut Ayaz 10 -110
        /*  bu methodun query si yazilirken if not exist kullanilacak
       tablo adi = t_teacher teacherID bu pk olacak

        tchr_name,
        tchr_surName
        password
        address
        phoneNumber
        role
        salary
        branch */

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        String sql = "CREATE TABLE IF NOT EXISTS t_teacher ("
                + "teacherID INT PRIMARY KEY AUTO_INCREMENT,"

                + "tchr_name VARCHAR(15),"

                + "tchr_surName VARCHAR(15),"

                + "password VARCHAR(12),"

                + "address VARCHAR(85),"

                + "phoneNumber VARCHAR(15),"

                + "role VARCHAR(20),"

                + "salary REAL,"

                + "branch VARCHAR(30))";
        try {
            JDBC_Utils.getSt().executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }


        System.out.println("t_teacher tablosu");











































    }


    //TODO  Umut Ayaz 113-213
    @Override
    public Teacher find(int id) {
        // Umut Ayaz 113-213

        {

            JDBC_Utils.setConnection();

            Teacher teacher = null;


            try {

                String sql = "SELECT * FROM t_teacher WHERE teacherID = ?";
                JDBC_Utils.setPrst(sql);

                JDBC_Utils.getPrst().setInt(1, id);

                ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();

                if (resultSet.next()) {
                    teacher = new Teacher(

                            resultSet.getString("tchr_name"),
                            resultSet.getString("tchr_surName"),
                            resultSet.getString("password"),
                            resultSet.getString("address"),
                            resultSet.getString("phoneNumber"),
                            UserRol.TEACHER,
                            resultSet.getDouble("salary"),
                            resultSet.getString("branch"),
                            resultSet.getInt("teacherID")
                    );
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    JDBC_Utils.getPrst().close();
                    JDBC_Utils.getCon().close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                return teacher;

                //String name, String surName, String password, String address, String phoneNumber,
                //                   UserRol role, double salary, String branch, int teacherID

            }
        }

















































    }


    //TODO Mustafa Ubeyde Kayhan 216- 316
    @Override
    public void addRepoSomeoneInfo(Teacher person) {
































































































        // Mustafa Ubeyde Kayhan 216- 316
    }



    //TODO Gaukhar Ergin 320 420
    @Override
    public void removeRepoSomeoneInfo(Teacher person) {
































































































// Gaukhar Ergin 320 420
    }


    //TODO Ersagun Eryildiz 423 - 623
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
    //TODO Ersagun Eryildiz 423 - 623
    public void updateBranchInfo(Teacher person, String branch) {

    }
    //TODO Ersagun Eryildiz 423 - 623
    public void updateSalaryInfo(Teacher person, double salary) {

    }

    //TODO  Seval Senturk 626 - 726
    @Override
    public void getRepoSomeoneInfo(int id) {

        // JDBC bağlantısını aç

        JDBC_Utils.setConnection();

        String sql = "SELECT * FROM t_teacher WHERE id = ?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setInt(1,id);
            ResultSet resultSet=JDBC_Utils.getPrst().executeQuery();


            if (resultSet.next()) {
                System.out.print(" Teacher ID : "+ resultSet.getInt("teacherID"));
                System.out.print(" Name : "+resultSet.getString("tchr_name"));
                System.out.print(" Surname : "+ resultSet.getString("tchr_surName"));
                System.out.print(" Address : "+resultSet.getString("address"));
                System.out.print(" Phone Number : "+ resultSet.getString("phoneNumber"));
                System.out.print(" Branch : "+ resultSet.getString("branch"));

                System.out.println();

            }
        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }
        }




























































// Seval Senturk 626 - 726

    }

    //TODO Umut Ayaz 728 ve devami
    public List<Teacher> getAllTeacher(){
        return null;
    }
    //728- 828 arasi tum ogretmenleri get edecek methodu yaz Caner Unal
}
