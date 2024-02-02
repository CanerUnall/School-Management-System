package repository;

import config.JDBC_Utils;
import domain.Grades;
import domain.Student;
import domain.SuccessDegree;

import java.sql.SQLException;
import java.util.List;

public class StudentRepository implements SameRepoOperations<Student>{

    // Cihan Guler 9-59
    public void createStudentTable(){

        JDBC_Utils jdbc_utils = new JDBC_Utils();

        JDBC_Utils.setConnection();//DB ile bağlantı kurmak için  Connection
        JDBC_Utils.setStatement();//Sorgu oluşturmak için Statement
        //JDBC_Utils.setPrst();//Belki parametreli sorgular oluşturmak için PreparedStatement
        try{
            JDBC_Utils.getSt().executeUpdate("CREATE TABLE IF NOT EXISTS t_student(" +
                    "studentId SERIAL UNIQUE," +
                    "std_name VARCHAR(50) NOT NULL CHECK(LENGTH(name)>0)," +
                    "std_surName VARCHAR(50) NOT NULL CHECK(LENGTH(name)>0)," +
                    "password VARCHAR(30) NOT NULL CHECK(LENGTH(password)>8)," +
                    "emails VARCHAR(30) NOT NULL CHECK(LENGTH(emails)>0)," +
                    "address VARCHAR(50) NOT NULL," +
                    "phone_number INT NOT NULL," +
                    "role," +
                    "grade INT CHECK(age>=0)," +
                    "lastYearGradeAvg INT CHECK(age>=0)," +
                    "payment INT," +
                    "totalPrice INT," +
                    "balanc");

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

        return null;































































































        //Semra Zengin 628 - 728
    }
}
