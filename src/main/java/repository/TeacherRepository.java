package repository;

import config.JDBC_Utils;
import domain.Teacher;
import domain.UserRol;
import java.sql.*;
import java.util.List;;
public class TeacherRepository implements SameRepoOperations<Teacher>{

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
        }finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }


        System.out.println("t_teacher tablosu");
            }
















































            // Umut Ayaz 10 -110

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
                    } finally {try {
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


























































































































        // Umut Ayaz 113-213


    @Override
    public void addRepoSomeoneInfo(Teacher person) {
        //Mustafa Ubeyde Kayhan 216- 2316


































































































        // Mustafa Ubeyde Kayhan 216- 316
    }

    @Override
    public void removeRepoSomeoneInfo(Teacher person) {
//Gaukhar Ergin 320 420

































































































// Gaukhar Ergin 320 420
    }


    @Override
    public void updateAdressInfo(Teacher person, String adress) {
        //Ersagun Eryildiz 423 - 623
// choice 1 ise adres, 2 ise brans, 3 ise maas update edilsin




































































































































































































        //Ersagun Eryildiz 423 - 623
    }
    public void updateBranchInfo(Teacher person, String branch) {

    }
    public void updateSalaryInfo(Teacher person, double salary) {

    }
    @Override
    public void getRepoSomeoneInfo(int id) {
// Seval Senturk 626 - 726































































































// Seval Senturk 626 - 726

    }
    public List<Teacher> getAllTeacher(){
        return null;
    }   //Umut Ayaz
    //728- 828 arasi tum ogretmenleri get edecek methodu yaz Caner Unal
            }
