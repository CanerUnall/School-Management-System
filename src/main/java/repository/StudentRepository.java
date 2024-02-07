package repository;
import config.JDBC_Utils;
import domain.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import domain.UserRol;
import exceptions.StudentNotFoundException;
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

            while (resultSet.next()){

            student.setStudentID(resultSet.getInt("student_Id"));
            student.setName(resultSet.getString("std_name"));
            student.setSurName(resultSet.getString("std_surName"));
            student.setRole(UserRol.STUDENT);
            student.setAddress(resultSet.getString("address"));
            student.setPhoneNumber(resultSet.getString("phoneNumber"));
            student.setThisYearGradeAvg(resultSet.getDouble("thisYearGradeAvg"));
            student.setLastYearGradeAvg(resultSet.getDouble("lastYearGradeAvg"));
            student.setPayment(resultSet.getDouble("payment"));
            student.setTotalPrice(resultSet.getInt("totalPrice"));
            student.setLessonCredit(resultSet.getInt("lessonCredit"));

            Grades grade = Grades.valueOf(resultSet.getString("grade"));
            student.setGrade(grade);

            //PercentDiscount percentDiscount = PercentDiscount.valueOf(resultSet.getString("percentDiscount"));
            //student.setPercentDiscount(percentDiscount);

            //student.setHistoryAttendance(resultSet.getString("historyAttandance"));
                
            // student.setAllLessons(resultSet.getInt("id"));

        }

            String studentAllLesson= "SELECT * FROM t_attendance WHERE std_id=" + student.getStudentID();
            ResultSet resultSet1= JDBC_Utils.getSt().executeQuery(studentAllLesson);
            HashMap<Integer, Attendance> attend = new HashMap<>();
            LessonsRepository lessonsRepository = new LessonsRepository();
            List<Lessons> allLessons = lessonsRepository.getAllLessons();

            while(resultSet1.next()){
                Attendance att= new Attendance();

                for (Lessons lessons:allLessons){
                    if (lessons.getName().name().equals(resultSet1.getString("lesson_name"))){
                        att.setLesson(lessons);
                    }
                }

                att.setDate(resultSet1.getDate("date"));
                attend.put(student.getStudentID(),att);
            }
            student.setHistoryAttendance(attend);

            return student;

        }   catch (SQLException e) {
            System.err.println(e.getMessage());
        }   finally {
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

        JDBC_Utils.setConnection();

        String sql = "UPDATE t_student SET address=? WHERE studentID=?";

        JDBC_Utils.setPrst(sql);

        try {
            // Set the parameters for the prepared statement
            JDBC_Utils.getPrst().setString(1, adress);
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());

            // Execute the update statement
            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Öğrenci Adres Bilgisi Güncellendi !...");
            }

        } catch (SQLException e) {
            throw new StudentNotFoundException("Öğrenci Adres Bilgisi Güncellenemedi: " + e.getMessage());
        } finally {

            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }





































































































































































// Seval Senturk 323 - 523
}

    //TODO Seval Senturk 539 - 640
    public void updateClassInfo(Student person, Grades grades) {

        JDBC_Utils.setConnection();

        String sql = "UPDATE t_student SET grade=? WHERE studentID=?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1, grades.name());
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());

            // Execute the update statement
            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Öğrenci Sınıf Bilgisi Güncellendi !...");
            }

        } catch (SQLException e) {
            throw new StudentNotFoundException("Öğrenci Sınıf Bilgisi Güncellenemedi: " + e.getMessage());
        } finally {

            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }





































































    }



    //TODO Seval Senturk 642 - 742
    public void updateFeeInfo(Student person, Double payment) { //readbl olması için Double arguman değiştirildi

        JDBC_Utils.setConnection();

        String sql = "UPDATE t_student SET payment=? WHERE studentID=?";

        JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setDouble(1,payment);
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());


            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Öğrenci Ücret Bilgisi Güncellendi !...");
            }

        } catch (SQLException e) {
            throw new StudentNotFoundException("Öğrenci Ücret Bilgisi Güncellenemedi: " + e.getMessage());
        } finally {

            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }




































































    }

    //TODO Seval Senturk 744 - 842
    public void updateLessonNoteInfo(Student person,Lessons lesson, int note) {

        JDBC_Utils.setConnection();

        String sql = "UPDATE t_lessons SET studentNote=? WHERE studentID=? AND lessonName=?";

        JDBC_Utils.setPrst(sql);

        try {

           JDBC_Utils.getPrst().setInt(1, note);
           JDBC_Utils.getPrst().setInt(2, person.getStudentID());
           JDBC_Utils.getPrst().setString(3, lesson.getName().name());


            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Ders Notu Güncellendi !...");
            }

        } catch (SQLException e) {
            System.out.printf("Ders notu güncellenemedi...!", e.getMessage());
        } finally {

            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }






























































































    } //method ismi değiştirildi

    //TODO Seval Senturk 844 - 944
    public void updateSuccessDegreeInfo(Student person, Lessons lessons, SuccessDegree successDegree) {


        JDBC_Utils.setConnection();

        String sql = "UPDATE t_lessons SET successDegree=? WHERE studentID=? AND lessonName=?";

        JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setString(1, successDegree.name());
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());
            JDBC_Utils.getPrst().setString(3, lessons.getName().name());


            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Başarı Derecesi Güncellendi !...");
            }

        } catch (SQLException e) {
            throw new StudentNotFoundException("Başarı Derecesi Güncellenemedi:  "  + e.getMessage());
        } finally {

            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

































































































    }

    //TODO  Zehra Erol 946 - 1046
    @Override
    public void getRepoSomeoneInfo(int id) {

//burada verilen id ye gore ogrenci bulmak icin StudentRepository icindeki find methodu kullanilacak
// daha sonra o ogrencinin verileri ekrana yazdirilacak

        Student foundedStudent = find(id);

        // JDBC bağlantısını aç

        JDBC_Utils.setConnection();

        String sql = "SELECT * FROM t_student WHERE id = ?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setInt(1, foundedStudent.getStudentID());
            ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();

            if (resultSet.next()) {
                System.out.print(" Student ID : " + resultSet.getInt("studentID"));
                System.out.print(" Name : " + resultSet.getString("firstName"));
                System.out.print(" Last Name : " + resultSet.getString("lastName"));
                System.out.print(" Address : " + resultSet.getString("address"));
                System.out.print(" Phone Number : " + resultSet.getString("phoneNumber"));
                System.out.print(" Student AVG : " + resultSet.getDouble("thisYearGradeAvg"));
                System.out.println();

            }
        } catch (SQLException e) {
            throw new StudentNotFoundException("Aradığınız id'li öğrenci bulunamamıştır.");
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }
        }

























































        

    }

    //TODO Semra Zengin 1048-1148
    public List<Student> getAllStudents() {

    JDBC_Utils.setConnection();
    JDBC_Utils.setStatement();

    List<Student> allStudents = new ArrayList<>();

    String query = "SELECT * FROM t_student";
    System.out.println("====================ALL STUDENTS================");

    try {
        ResultSet resultSet = JDBC_Utils.getSt().executeQuery(query);

        while (resultSet.next()) {
            Student student = new Student();

            int id= resultSet.getInt("id");
            student.setStudentID(id);
            student.setName(resultSet.getString("std_name"));
            student.setSurName(resultSet.getString("std_surname"));
            student.setRole(UserRol.STUDENT);
            student.setAddress(resultSet.getString("address"));
            student.setPhoneNumber(resultSet.getString("phoneNumber"));
            student.setLastYearGradeAvg(resultSet.getInt("lastYearGradeAvg"));
            student.setPayment(resultSet.getInt("payment"));
            student.setTotalPrice(resultSet.getInt("totalPrice"));
            student.setLessonCredit(resultSet.getInt("lessonCredit"));
            student.setThisYearGradeAvg(resultSet.getDouble("thisYearGradeAvg"));
            Grades grade = Grades.valueOf(resultSet.getString("grade"));
            student.setGrade(grade);

//            String query2="SELECT * FROM t_attendance t WHERE t.studentID== "+id;//studentID t_attendance tablosunda fk pldugu icin bu id'li ogrencinin attendance'sini getir dedik
//            ResultSet resultSet2=JDBC_Utils.getSt().executeQuery(query2);
//            Attendance attendance=new Attendance();
//            HashMap<Integer, Attendance> historyAttendance=new HashMap<>();
//            while (resultSet2.next()){
//                attendance.setDate(resultSet2.getDate("date"));
//                attendance.setLesson(resultSet2.getString("lesson_name"));
//            }
//            historyAttendance.put(id,attendance);
//            student.setHistoryAttendance(historyAttendance);
//
//
//            String query3="SELECT * FROM t_lessons l WHERE l.studentID== "+id;
//            ResultSet resultSet3=JDBC_Utils.getSt().executeQuery(query3);
//            Lessons lesson=new Lessons();
//            HashMap<Integer, Lessons> lessonsOfStudent=new HashMap<>();
//            while (resultSet3.next()){
//                lesson.setName(resultSet3.getString("lesson_name"));
//            }
//            historyAttendance.put(id,attendance);
//            student.setHistoryAttendance(historyAttendance);


            allStudents.add(student);


        }
        //yeni bir statemnt uzeriden

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