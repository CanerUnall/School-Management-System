package repository;

import config.JDBC_Utils;
import domain.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

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




































































































































































































        //Ersagun Eryildiz 423 - 623
    }

    public void updateBranchInfo(Teacher person, String branch) {

    }

    public void updateSalaryInfo(Teacher person, double salary) {

    }

    // Seval Senturk 626 - 726
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




    //728- 828 arasi tum ogretmenleri get edecek methodu yaz Caner Unal
}
