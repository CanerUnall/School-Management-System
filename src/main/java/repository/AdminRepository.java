package repository;

import config.JDBC_Utils;
import domain.Admins;
import domain.Teacher;
import domain.UserRol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static config.JDBC_Utils.*;

public class AdminRepository {

    public void createAdminTable() {
        setConnection();
        setStatement();

        String createTableAdmin = "CREATE TABLE IF NOT EXISTS t_admin (" +
                "admin_id INT PRIMARY KEY," +
                "teacherID INT REFERENCES t_teacher(teacherID)" +
                ")";
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

    }


    public Admins find(int id) {
        setConnection();
        setStatement();

        String getAdmin = "SELECT * FROM t_admin a " +
                "RIGHT JOIN t_teacher t " +
                "ON t.teacherID=a.teacherID " +
                "WHERE a.admin_id=" + id;
        Admins admin = null;

        try {

            ResultSet result = JDBC_Utils.getSt().executeQuery(getAdmin);

            while (result.next()) {
                admin = new Admins();
                admin.setAdminID(result.getInt("admin_id"));
                admin.setAddress(result.getString("address"));
                admin.setPassword(result.getString("password"));
                admin.setName(result.getString("tchr_name"));
                admin.setSurName(result.getString("tchr_surName"));
                admin.setPhoneNumber(result.getString("phoneNumber"));
                admin.setBranch(result.getString("branch"));
                admin.setSalary(result.getDouble("salary"));
                admin.setRole(UserRol.ADMIN);
                admin.setTeacherID(result.getInt("teacherID"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return admin;
    }

    public void addAdminRepo(Admins admin) {

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        String query = "INSERT INTO t_teacher(" +
                "teacherID, " +
                "tchr_name, " +
                "tchr_surName, " +
                "password, " +
                "address, " +
                "phoneNumber, " +
                "role, " +
                "salary, " +
                "branch) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        JDBC_Utils.setPrst(query);


        try {
            JDBC_Utils.getPrst().setInt(1, admin.getTeacherID());
            JDBC_Utils.getPrst().setString(2, admin.getName());
            JDBC_Utils.getPrst().setString(3, admin.getSurName());
            JDBC_Utils.getPrst().setString(4, admin.getPassword());
            JDBC_Utils.getPrst().setString(5, admin.getAddress());
            JDBC_Utils.getPrst().setString(6, admin.getPhoneNumber());
            JDBC_Utils.getPrst().setString(7, String.valueOf(admin.getRole()));
            JDBC_Utils.getPrst().setDouble(8, admin.getSalary());
            JDBC_Utils.getPrst().setString(9, admin.getBranch());

            JDBC_Utils.getPrst().executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        String sql = "INSERT INTO t_admin VALUES ( " + admin.getAdminID() +
                "," + admin.getTeacherID() + ")";

        try {
            JDBC_Utils.getSt().executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public List<Admins> getRepoAllAdmins() {

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();
        List<Admins> allAdmins = null;

        try {

            String sql = "SELECT * FROM t_teacher LEFT JOIN t_admin ON t_teacher.teacherID = t_admin.teacherID";
            ResultSet resultSet = JDBC_Utils.getSt().executeQuery(sql);
            allAdmins = new ArrayList<>();
            while (resultSet.next()) {
                Admins admin = new Admins();
                admin.setAdminID(resultSet.getInt("admin_id"));
                admin.setAddress(resultSet.getString("address"));
                admin.setPassword(resultSet.getString("password"));
                admin.setName(resultSet.getString("tchr_name"));
                admin.setSurName(resultSet.getString("tchr_surName"));
                admin.setPhoneNumber(resultSet.getString("phoneNumber"));
                admin.setBranch(resultSet.getString("branch"));
                admin.setSalary(resultSet.getDouble("salary"));
                admin.setRole(UserRol.ADMIN);
                admin.setTeacherID(resultSet.getInt("teacherID"));
                allAdmins.add(admin);
            }
            return allAdmins;
        } catch (SQLException e) {
            System.err.println(" LOGIN ERROR: " + e.getMessage());
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }
        return allAdmins;
    }

}