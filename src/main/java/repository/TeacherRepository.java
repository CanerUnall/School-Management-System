package repository;
import config.JDBC_Utils;
import domain.Teacher;
import domain.UserRol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;;

public class TeacherRepository implements SameRepoOperations<Teacher> {

    //TODO  Umut Ayaz 10 -110
    public void createTeacherTable() {
      /*  bu methodun query si yazilirken if not exist kullanilacak
>>>>>>> main

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

        // JDBC bağlantısını aç

        JDBC_Utils.setConnection();

        String sql = "DELETE FROM t_teacher WHERE id = ?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setInt(1, person.getTeacherID());
            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Teacher information with ID " + person.getTeacherID() + " has been successfully removed.");
            } else {
                System.out.println("No teacher found with ID " + person.getTeacherID() + ". No records were removed.");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }




































































// Gaukhar Ergin 320 420
    }


    //TODO Ersagun Eryildiz 423 - 623
    @Override
    public void updateAdressInfo(Teacher teacher, String address) {

    JDBC_Utils.setConnection();
    String sql = "UPDATE t_teacher SET address = ? WHERE teacherID = ? ";
    JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1,address);
            JDBC_Utils.getPrst().setInt(2,teacher.getTeacherID());
            JDBC_Utils.getPrst().executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }

    }


        //Ersagun Eryildiz 423 - 623

    //TODO Ersagun Eryildiz 423 - 623
    public void updateBranchInfo(Teacher person, String branch) {
        JDBC_Utils.setConnection();
        String sql = "UPDATE t_teacher SET branch = ? WHERE teacherID = ? ";
        JDBC_Utils.setPrst(sql);


        try {
            JDBC_Utils.getPrst().setString(1,branch);
            JDBC_Utils.getPrst().setInt(2,person.getTeacherID());
            JDBC_Utils.getPrst().executeUpdate();


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }

    }



    //TODO Ersagun Eryildiz 423 - 623
    public void updateSalaryInfo(Teacher person, double salary) {

        JDBC_Utils.setConnection();
        String sql = "UPDATE t_teacher SET salary = ? WHERE teacherID = ? ";
        JDBC_Utils.setPrst(sql);


        try {
            JDBC_Utils.getPrst().setDouble(1,salary);
            JDBC_Utils.getPrst().setInt(2, person.getTeacherID());
            JDBC_Utils.getPrst().executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }

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
    public List<Teacher> getAllTeacher() throws SQLException {
        JDBC_Utils.setStatement();
        List<Teacher> teachers = new ArrayList<>();
        ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();
        try {

            String sql = "SELECT * FROM t_teacher";


                while (resultSet.next()) {
                    Teacher teacher = new Teacher(

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
                    teachers.add(teacher);
                }
            } catch (SQLException e) {
                System.err.println(" LOGIN ERROR: " + e.getMessage());
            } finally {
            resultSet.close();
            }
            return teachers;
        }
    }
    //728- 828 arasi tum ogretmenleri get edecek methodu yaz Caner Unal

