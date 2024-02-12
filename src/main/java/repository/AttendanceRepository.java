package repository;

import config.JDBC_Utils;

import java.sql.SQLException;

import static config.JDBC_Utils.setConnection;
import static config.JDBC_Utils.setStatement;

public class AttendanceRepository {

    public void createAttendanceTable() {
        setConnection();
        setStatement();

        String createAttendanceTable = "CREATE TABLE IF NOT EXISTS t_attendance (" +
                "attendanceID SERIAL PRIMARY KEY," +
                "lesson_name VARCHAR(25)," +
                "date DATE," +
                "std_id INT REFERENCES t_student(std_id)" +
                ")";

        try {
            JDBC_Utils.getSt().executeUpdate(createAttendanceTable);

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


}
