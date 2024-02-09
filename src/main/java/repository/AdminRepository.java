package repository;
import config.JDBC_Utils;
import domain.Admins;

import domain.UserRol;
import exceptions.AdminNotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static config.JDBC_Utils.*;

public class AdminRepository {
    private static Statement st;


    //TODO  Mustafa Ubeyde Kayhan 7 -  57

    public void createAdminTable() {
      /*  bu methodun query si yazilirken if not exist kullanilacak

        tablo adi = t_admin

        adminID bu pk olacak
        teacherID foreign key

*/
        setConnection();
        setStatement();

        String createTableAdmin = "CREATE TABLE IF NOT EXISTS t_admin " +
                "(admin_id INT PRIMARY KEY AUTO_INCREMENT," +
                "admin_name VARCHAR(20))," +
                "admin_surname VARCHAR(20)" +
                "admin_password VARCHAR(20)," +
                "admin_address VARCHAR(50)," +
                "admin_phoneNumber VARCHAR(20)," +
                "admin_role VARCHAR(5)," +
                "admin_salary REAL," +
                "admin_branch VARCHAR(20)," +
                "admin_teacherID INT FOREIGN KEY REFERENCES t_teacher(teacherID))";

        try {
            JDBC_Utils.getSt().executeUpdate(createTableAdmin);
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


        // Mustafa Ubeyde Kayhan 7 -  57
    }


    public Admins find(int id) {
        setConnection();
        setStatement();
        // Mustafa Ubeyde Kayhan 61 -  161
//buradan girilen idye gore dbden admin bilgileri alinacak ve obje olusturulup return edilecek

        String getAdmin = "SELECT * FROM t_admin WHERE admin_id=" + id;
        Admins admin = new Admins();

        try {

            ResultSet result = JDBC_Utils.getSt().executeQuery(getAdmin);

            while (result.next()) {
                admin.setAdminID(result.getInt("admin_id"));
                admin.setName(result.getString("admin_name"));
                admin.setSurName(result.getString("admin_surname"));
                admin.setPassword(result.getString("admin_password"));
                admin.setAddress(result.getString("admin_address"));
                admin.setPhoneNumber(result.getString("admin_phoneNumber"));
                admin.setRole(UserRol.ADMIN);
                admin.setSalary(result.getDouble("admin_salary"));
                admin.setBranch(result.getString("admin_branch"));
                admin.setTeacherID(result.getInt("admin_teacherID"));


            }
        } catch (SQLException e) {
            throw new AdminNotFoundException("Admin not found");
        }finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }
        return admin;
    }
































































//TODO Rumeysa Dagtekin 164 - 264
        public void addAdminRepo (Admins admin){

            //burada projede yer alan arkadaslar admin olarak dbye eklenmesi icin gerekli sorgu yazilacak.

            JDBC_Utils.setConnection();
            JDBC_Utils.setStatement();

            String sql = "INSERT INTO t_admin VALUES ( " + admin.getAdminID() +
                    "," + admin.getTeacherID() + ")";

            try {
                JDBC_Utils.getSt().executeQuery(sql);
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





























            // Rumeysa Dagtekin 164 - 264
        }

    }


