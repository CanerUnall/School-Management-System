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

        //SELECT orders.order_id, orders.order_date, customers.customer_name
        //FROM orders
        //JOIN customers ON orders.customer_id = customers.customer_id
        //WHERE orders.order_date BETWEEN '2023-01-01' AND '2023-12-31';

        String getAdmin = "SELECT * FROM t_admin a " +
                "RIGHT JOIN t_teacher t " +
                "ON t.teacherID=a.teacherID " +
                "WHERE a.admin_id=" + id;
        Admins admin = null;

        try {

            ResultSet result = JDBC_Utils.getSt().executeQuery(getAdmin);

            while (result.next()) {
               admin=new Admins();
                admin.setAdminID(result.getInt("admin_id"));
                admin.setAddress(result.getString("address"));
                admin.setPassword(result.getString("password"));
                admin.setName(result.getString("tchr_name"));
                admin.setSurName(result.getString("tchr_surName"));
                admin.setPhoneNumber(result.getString("phoneNumber"));
                admin.setBranch(result.getString("branch"));
                admin.setSalary(result.getDouble("salary"));
                admin.setRole(UserRol.ADMIN);
                admin.setTeacherID(result.getInt("admin_teacherID"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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


