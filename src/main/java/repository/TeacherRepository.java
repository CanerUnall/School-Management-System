package repository;

import config.JDBC_Utils;
import domain.Teacher;
import domain.UserRol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;;

public class TeacherRepository implements SameRepoOperations<Teacher> {

    public void createTeacherTable() {

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        String sql = "CREATE TABLE IF NOT EXISTS t_teacher ("
                + "teacherID INT PRIMARY KEY,"
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

    }


    @Override
    public Teacher find(int id) {

        JDBC_Utils.setConnection();

        Teacher teacher = null;
        try {

            String sql = "SELECT * FROM t_teacher WHERE teacherID = ?";
            JDBC_Utils.setPrst(sql);

            JDBC_Utils.getPrst().setInt(1, id);

            ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();

            while (resultSet.next()) {
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
        }
        return teacher;

    }

    @Override
    public void addRepoSomeoneInfo(Teacher person) {

        JDBC_Utils.setConnection();
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
            JDBC_Utils.getPrst().setInt(1, person.getTeacherID());
            JDBC_Utils.getPrst().setString(2, person.getName());
            JDBC_Utils.getPrst().setString(3, person.getSurName());
            JDBC_Utils.getPrst().setString(4, person.getPassword());
            JDBC_Utils.getPrst().setString(5, person.getAddress());
            JDBC_Utils.getPrst().setString(6, person.getPhoneNumber());
            JDBC_Utils.getPrst().setString(7, String.valueOf(person.getRole()));
            JDBC_Utils.getPrst().setDouble(8, person.getSalary());
            JDBC_Utils.getPrst().setString(9, person.getBranch());

            JDBC_Utils.getPrst().executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    @Override
    public void removeRepoSomeoneInfo(Teacher person) {

        JDBC_Utils.setConnection();

        String sql = "DELETE FROM t_teacher WHERE teacherID = ?";

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

    }

    @Override
    public void updateAdressInfo(Teacher teacher, String address) {

        JDBC_Utils.setConnection();
        String sql = "UPDATE t_teacher SET address = ? WHERE teacherID = ? ";
        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1, address);
            JDBC_Utils.getPrst().setInt(2, teacher.getTeacherID());
            JDBC_Utils.getPrst().executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }

    }

    public void updateBranchInfo(Teacher person, String branch) {
        JDBC_Utils.setConnection();
        String sql = "UPDATE t_teacher SET branch = ? WHERE teacherID = ? ";
        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1, branch);
            JDBC_Utils.getPrst().setInt(2, person.getTeacherID());
            JDBC_Utils.getPrst().executeUpdate();


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }

    }

    public void updateSalaryInfo(Teacher person, double salary) {

        JDBC_Utils.setConnection();
        String sql = "UPDATE t_teacher SET salary = ? WHERE teacherID = ? ";
        JDBC_Utils.setPrst(sql);


        try {
            JDBC_Utils.getPrst().setDouble(1, salary);
            JDBC_Utils.getPrst().setInt(2, person.getTeacherID());
            JDBC_Utils.getPrst().executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }

    }

    @Override
    public void getRepoSomeoneInfo(int id) {

        JDBC_Utils.setConnection();

        String sql = "SELECT * FROM t_teacher WHERE teacherID = ?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setInt(1, id);
            ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();


            if (resultSet.next()) {
                System.out.print(" Teacher ID : " + resultSet.getInt("teacherID"));
                System.out.print(" Name : " + resultSet.getString("tchr_name"));
                System.out.print(" Surname : " + resultSet.getString("tchr_surName"));
                System.out.print(" Address : " + resultSet.getString("address"));
                System.out.print(" Phone Number : " + resultSet.getString("phoneNumber"));
                System.out.print(" Branch : " + resultSet.getString("branch"));

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

    }

    public List<Teacher> getAllTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        try {
            String sql = "SELECT * FROM t_teacher";
            ResultSet resultSet = JDBC_Utils.getSt().executeQuery(sql);

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setName(resultSet.getString("tchr_name"));
                teacher.setSurName(resultSet.getString("tchr_surName"));
                teacher.setPassword(resultSet.getString("password"));
                teacher.setAddress(resultSet.getString("address"));
                teacher.setPhoneNumber(resultSet.getString("phoneNumber"));
                teacher.setRole(UserRol.valueOf(resultSet.getString("role")));
                teacher.setSalary(resultSet.getDouble("salary"));
                teacher.setBranch(resultSet.getString("branch"));
                teacher.setTeacherID(resultSet.getInt("teacherID"));

                teachers.add(teacher);
            }
            resultSet.close();
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
        return teachers;
    }
}
