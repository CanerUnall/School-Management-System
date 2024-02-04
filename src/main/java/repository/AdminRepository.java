package repository;

import domain.Admins;
import domain.UserRol;
import exceptions.AdminNotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static config.JDBC_Utils.*;

public class AdminRepository {
    private static Statement st;
    public void createAdminTable(){
        // Mustafa Ubeyde Kayhan 7 -  57
      /*  bu methodun query si yazilirken if not exist kullanilacak

        tablo adi = t_admin

        adminID bu pk olacak
        teacherID foreign key

*/
        setConnection();
        setStatement();
//String name, String surName, String password, String address, String phoneNumber,
//                  UserRol role, double salary, String branch, int teacherID, int adminID

        String createTableAdmin = "CREATE TABLE IF NOT EXISTS t_admin " +
                "(admin_id INT PRIMARY KEY," +
                "admin_name VARCHAR(20))," +
                "admin_surname VARCHAR(20)" +
                "admin_password VARCHAR(20)," +
                "admin_address VARCHAR(50)," +
                "admin_phoneNumber VARCHAR(20)," +
                "admin_role VARCHAR(5)," +
                "admin_salary REAL," +
                "admin_branch VARCHAR(20)," +
                "admin_teacherID INT FOREIGN KEY REFERENCES t_teacher(teacherID))";

            setPrst(createTableAdmin);





































        // Mustafa Ubeyde Kayhan 7 -  57
    }
public ResultSet query(String query) {
    try {
        return st.executeQuery(query);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    public Admins find(int id){
        setConnection();
        setStatement();
        // Mustafa Ubeyde Kayhan 61 -  161
//buradan girilen idye gore dbden admin bilgileri alinacak ve obje olusturulup return edilecek
        String getAdmin = "SELECT * FROM t_admin WHERE admin_id="+id;
        ResultSet result=query(getAdmin);
        //result.getString("id_number");
        //                String cName = result.getString("name");
        //                String password = result.getString("password");
        //                String gender = result.getString("gender");
        //                int age = result.getInt("age");
        //                String email = result.getString("emails");
        //                String adres = result.getString("cargo_address");
        //                String cardNumber = result.getString("card_number");
        //                String lastDate = result.getString("card_expiration_date");
        //                String cvv = result.getString("card_cvv");
        //                String pNumber = result.getString("phone_number");
        // String createTableAdmin = "CREATE TABLE IF NOT EXISTS t_admin " +
        //                "(admin_id INT PRIMARY KEY," +
        //                "admin_name VARCHAR(20))," +
        //                "admin_surname VARCHAR(20)" +
        //                "admin_password VARCHAR(20)," +
        //                "admin_address VARCHAR(50)," +
        //                "admin_phoneNumber VARCHAR(20)," +
        //                "admin_role VARCHAR(5)," +
        //                "admin_salary INT," +
        //                "admin_branch VARCHAR(20)," +
        //                "admin_teacherID INT FOREIGN KEY REFERENCES t_teacher(teacherID))";

        try {
            return new Admins(result.getString("admin_name"),
                    result.getString("admin_surname"),
                    result.getString("admin_password"),
                    result.getString("admin_address"),
                    result.getString("admin_phoneNumber"),
                    UserRol.fromString(result.getString("admin_role")),
                    result.getDouble("admin_salary"),
                    result.getString("admin_branch"),
                    result.getInt("admin_teacherID"),
                    result.getInt("admin_id"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // Mustafa Ubeyde Kayhan 61 -  161
    }


   public void addAdminRepo(){
        // Rumeysa Dagtekin 164 - 264
        //burada projede yer alan arkadaslar admin olarak dbye eklenmesi icin gerekli sorgu yazilacak.
































































































        // Rumeysa Dagtekin 164 - 264
    }

}
