package repository;

import config.JDBC_Utils;
import domain.Lessons;
import domain.Student;
import domain.Teacher;
import service.TeacherMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinanceRepository {
    private final TeacherRepository teacherRepository;

    public FinanceRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void getRepoIncomeInfo() {

        StudentRepository studentRepository = new StudentRepository();
        List<Student> studentList = studentRepository.getAllStudents();

        double sum = 0;
        double sum2 = 0;
        for (Student each : studentList) {   //ogrenci listemizi donguye soktum

            for (Lessons each2 : each.getAllLessons()) {

                sum = sum + each2.getLessonFee();  //burada dersin ucretini sum'a atamis oldum. Bu dongunun sonunda ogrencinin secmis oldugu butun derslerin ucretleri toplanip sum'a atanir.
            }

            sum2 += sum; // her ogrenciden gelen gelirler sum2 ye atanir.
            System.out.println(each.getName() + " " + each.getSurName() + "--> " + "Total:  " + sum);
            sum = 0; //Burada sum degiskenini sifirladim cunku bir sonraki ogrencinin ders ucretlerinin toplamini atamam lazim.

        }
        System.out.println("Total Income: " + sum2); // Toplam gelir

    }

    public void getRepoExpenseInfo() {

        double sum = 0;

        for (Teacher teacher : teacherRepository.getAllTeacher()) {
            System.out.println(teacher.getName() + " " + teacher.getSurName() + " " + teacher.getSalary());
            sum += teacher.getSalary();
        }
        System.out.println("Total Expense : " + sum);

    }

    public void getRepoPaymentTrackingInfo() {

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        String query = "SELECT std_id,std_name, std_surName, payment, totalPrice FROM t_student";
        System.out.println("====================PAYMENT TRACKING INFO OF ALL STUDENTS================");

        try {
            ResultSet resultSet = JDBC_Utils.getSt().executeQuery(query);

            while (resultSet.next()) {
                int leftPrice = resultSet.getInt("totalPrice") - resultSet.getInt("payment");
                System.out.print("Id : " + resultSet.getInt("std_id"));
                System.out.print(" Name : " + resultSet.getString("std_name"));
                System.out.print(" Surname : " + resultSet.getString("std_surname"));
                System.out.print(" Payment : " + resultSet.getInt("payment"));
                System.out.print(" TotalPrice : " + resultSet.getInt("totalPrice"));
                if (leftPrice > 0) {
                    System.out.print(" LeftPrice : " + leftPrice);
                } else {
                    System.out.print(" LeftPrice : " + leftPrice + " -->All payments are completed");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
