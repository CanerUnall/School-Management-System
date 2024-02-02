package repository;

import config.JDBC_Utils;
import domain.Grades;
import domain.Student;
import domain.SuccessDegree;
import domain.UserRol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements SameRepoOperations<Student>{

    // Cihan Guler 9-59
    public void createStudentTable(){
        /*
        bu methodun query si yazilirken if not exist kullanilacak
        studentID bu pk olacak

        tablo ismi = t_student

        std_name,
        std_surName
        password
        address
        phoneNumber
        role
        grade
        lastYearGradeAvg
        payment
        totalPrice
        lessonCredit

        */




























// Cihan Guler 9-59
    }

    //Ersagun Eryildiz 62-162
    @Override
    public Student find(int id) {
        //buradan girilen idye gore dbden ogrenci bilgileri alinacak ve obje olusturulup return edilecek

        return null;






























































































        //Ersagun Eryildiz 62-162
    }

    //Husnu Sen 166- 266
    @Override
    public void addRepoSomeoneInfo(Student person) {
    /*

    burada parametreden gelen objeye gore dbye kayit icin gerekli sorgular yazilacak ve kayit yapilacak


    */





























































































        //Husnu Sen 166- 266
    }

    //Caner Unal 270- 320
    @Override
    public void removeRepoSomeoneInfo(Student person) {

        /*
        burada parametreden gelen objeye gore direkt olarak ogrenciyi silmek icin gerekli sorgu yazilacak ve ogrenci silinecek

        */











































        //Caner Unal 270- 320
    }

    //Seval Senturk 323 - 523
    @Override
    public void updateAdressInfo(Student person, String adress) {
        // choice 1 ise Adres, 2 ise sınıf, 3 ise ucret, 4 ise notu,  5 ise basari durumu update edecek sekilde yazilsin
        //choice gore islemler switch case ile duzenlenecek
        //   her bir case durumunda degistirilecek olan bilgi ve yerine yazilacak bilgi burada sorulacak


































































































































































































// Seval Senturk 323 - 523
    }

    public void updateClassInfo(Student person, Grades grades){}

    public void updateFeeInfo(Student person, Double fee){}

    public void updateNoteInfo(Student person, int note){}

    public void updateSuccessDegreeInfo(Student person, SuccessDegree successDegree){}

    // Zehra Erol 526 - 626
    @Override
    public void getRepoSomeoneInfo(int id) {

//burada verilen id ye gore ogrenci bulmak icin StudentRepository icindeki find methodu kullanilacak
// daha sonra o ogrencinin verileri ekrana yazdirilacak































































































// Zehra Erol 526 - 626
    }

    //Semra Zengin 628 - 728
    public List<Student> getAllStudents(){


//Semra Zengin 628 - 728

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        List<Student> allStudents=new ArrayList<>();

        String query="SELECT * FROM t_student";
        System.out.println("====================ALL STUDENTS================");

        try {
            ResultSet resultSet=JDBC_Utils.getSt().executeQuery(query);

            while (resultSet.next()){
                Student student = new Student();

                student.setStudentID(resultSet.getInt("id"));
                student.setName(resultSet.getString("std_name"));
                student.setSurName(resultSet.getString("std_surname"));
                student.setRole(UserRol.STUDENT);
                student.setAddress(resultSet.getString("address"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
                student.setLastYearGradeAvg(resultSet.getInt("lastYearGradeAvg"));
                student.setPayment(resultSet.getInt("payment"));
                student.setTotalPrice(resultSet.getInt("totalPrice"));
                student.setLessonCredit(resultSet.getInt("lessonCredit"));
                Grades grade = Grades.valueOf(resultSet.getString("grade"));
                student.setGrade(grade);

                allStudents.add(student);


            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return allStudents;






























































































        //Semra Zengin 628 - 728
    }
}
