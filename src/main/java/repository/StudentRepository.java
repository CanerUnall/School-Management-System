package repository;
import config.JDBC_Utils;
import domain.Grades;
import domain.Lessons;
import domain.Student;
import domain.SuccessDegree;
import java.sql.SQLException;
import java.util.List;
import domain.UserRol;
import java.sql.ResultSet;
import java.util.ArrayList;
public class StudentRepository implements SameRepoOperations<Student> {

    //TODO  Cihan Guler 14-75
    public void createStudentTable() {
        /*
        bu methodun query si yazilirken if not exist kullanilacak
        studentID bu pk olacak
        tablo ismi = t_student

        std_id
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

        JDBC_Utils jdbc_utils = new JDBC_Utils();

        JDBC_Utils.setConnection();//DB ile bağlantı kurmak için  Connection
        JDBC_Utils.setStatement();//Sorgu oluşturmak için Statement
        //JDBC_Utils.setPrst();//Belki parametreli sorgular oluşturmak için PreparedStatement
        try {
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
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }








    }


    //TODO Ersagun Eryildiz 78-178
    @Override
    public Student find(int id) {

        //buradan girilen idye gore dbden ogrenci bilgileri alinacak ve obje olusturulup return edilecek

        //   return null;

        //----------------------------------------------------------------------

        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();
        String query = ("SELECT * FROM t_students WHERE id=" + id);
        System.out.println("================FOUND STUDENT===================");
        try {
            ResultSet resultSet = JDBC_Utils.getSt().executeQuery(query);

            Student student = new Student();

            System.out.println("Id: " + resultSet.getInt("id"));
            System.out.println("Name: " + resultSet.getString("std_name"));
            System.out.println("Surname: " + resultSet.getString("std_surName"));
            System.out.println("Role: " + resultSet.getString("role"));
            System.out.println("Address: " + resultSet.getString("address"));
            System.out.println("PhoneNumber: " + resultSet.getInt("phoneNumber"));
            System.out.println("Grade: " + resultSet.getInt("grade"));
            System.out.println("Age: " + resultSet.getInt("age"));
            System.out.println("LastYearGradeAvg: " + resultSet.getInt("lastYearGradeAvg"));
            System.out.println("Payment: " + resultSet.getInt("payment"));
            System.out.println("TotalPrice: " + resultSet.getInt("totalPrice"));
            System.out.println("LessonCredit: " + resultSet.getInt("lessonCredit"));
            return student;


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
        return null;






















































    }



    //TODO Husnu Sen 182- 282
    @Override
    public void addRepoSomeoneInfo(Student person) {
        /*//


    //Husnu Sen 166-266 eski aralık ?
    @Override
    public void addRepoSomeoneInfo(Student person) {
    /*

    burada parametreden gelen objeye gore dbye kayit icin gerekli sorgular yazilacak ve kayit yapilacak


        burada parametreden gelen objeye gore dbye kayit icin gerekli sorgular yazilacak ve kayit yapilacak


*/
    JDBC_Utils.setConnection();
    String sql = "INSERT INTO students (name, surName, password, address, phoneNumber, role, studentID, grade, lastYearGradeAvg, payment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    JDBC_Utils.setPrst(sql);


    try {
        JDBC_Utils.getPrst().setString(1, person.getName());
        JDBC_Utils.getPrst().setString(2, person.getSurName());
        JDBC_Utils.getPrst().setString(3, person.getPassword());
        JDBC_Utils.getPrst().setString(4, person.getAddress());
        JDBC_Utils.getPrst().setString(5, person.getPhoneNumber());
        JDBC_Utils.getPrst().setString(6, String.valueOf(person.getRole()));
        JDBC_Utils.getPrst().setInt(7, person.getStudentID());
        JDBC_Utils.getPrst().setString(8, String.valueOf(person.getGrade()));
        JDBC_Utils.getPrst().setDouble(9, person.getLastYearGradeAvg());
        JDBC_Utils.getPrst().setDouble(10, person.getPayment());

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



    //
















































}


    //TODO Caner Unal 285- 335

    @Override
    public void removeRepoSomeoneInfo(Student person) {

        /*
        burada parametreden gelen objeye gore direkt olarak ogrenciyi silmek icin gerekli sorgu yazilacak ve ogrenci silinecek

        */









































}

    //TODO Seval Senturk 337 - 537
    @Override
    public void updateAdressInfo(Student person, String adress) {
    // choice 1 ise Adres, 2 ise sınıf, 3 ise ucret, 4 ise notu,  5 ise basari durumu update edecek sekilde yazilsin
    //choice gore islemler switch case ile duzenlenecek
    //   her bir case durumunda degistirilecek olan bilgi ve yerine yazilacak bilgi burada sorulacak







































































































































































// Seval Senturk 323 - 523
} //anlamadım ??? :((((
    //TODO Seval Senturk 337 - 537
    public void updateClassInfo(Student person, Grades grades) {
    }
    //TODO Seval Senturk 337 - 537
    public void updateFeeInfo(Student person, Double fee) {
    }
    //TODO Seval Senturk 337 - 537
    public void updateNoteInfo(Student person, int note) {
    }
    //TODO Seval Senturk 337 - 537
    public void updateSuccessDegreeInfo(Student person, Lessons lessons, SuccessDegree successDegree) {
    }


    //TODO  Zehra Erol 526 - 626

    @Override
    public void getRepoSomeoneInfo(int id) {

//burada verilen id ye gore ogrenci bulmak icin StudentRepository icindeki find methodu kullanilacak
// daha sonra o ogrencinin verileri ekrana yazdirilacak




























































































// Zehra Erol 526 - 626
}

    //TODO Semra Zengin 628 - 728
    public List<Student> getAllStudents() {


    //Semra Zengin 628 - 728

    JDBC_Utils.setConnection();
    JDBC_Utils.setStatement();

    List<Student> allStudents = new ArrayList<>();

    String query = "SELECT * FROM t_student";
    System.out.println("====================ALL STUDENTS================");

    try {
        ResultSet resultSet = JDBC_Utils.getSt().executeQuery(query);

        while (resultSet.next()) {
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
    } finally {
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