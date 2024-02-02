package config;

import java.sql.*;

public class JDBC_Utils {

    private static Connection con;
    private static Statement st;
    public static PreparedStatement prst;

    public static void setConnection() {

        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school_management_system", "postgres", "Asd181116.");
        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        }

    }

    public static void setStatement(){

        try {
            st = con.createStatement();
        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }

    public static void setPrst(String query){

        try {
            prst = con.prepareStatement(query);
        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
        }

    }

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        JDBC_Utils.con = con;
    }

    public static Statement getSt() {
        return st;
    }

    public static void setSt(Statement st) {
        JDBC_Utils.st = st;
    }

    public static PreparedStatement getPrst() {
        return prst;
    }

    public static void setPrst(PreparedStatement prst) {
        JDBC_Utils.prst = prst;
    }
}