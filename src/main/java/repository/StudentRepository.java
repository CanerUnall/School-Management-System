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

            while (resultSet.next()) {

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

            String studentAllLesson = "SELECT * FROM t_attendance WHERE std_id=" + student.getStudentID();
            ResultSet resultSet1 = JDBC_Utils.getSt().executeQuery(studentAllLesson);
            HashMap<Integer, Attendance> attend = new HashMap<>();
            LessonsRepository lessonsRepository = new LessonsRepository();
            List<Lessons> allLessons = lessonsRepository.getAllLessons();

            while (resultSet1.next()) {
                Attendance att = new Attendance();

                for (Lessons lessons : allLessons) {
                    if (lessons.getName().name().equals(resultSet1.getString("lesson_name"))) {
                        att.setLesson(lessons);
                    }
                }

                att.setDate(resultSet1.getDate("date"));
                attend.put(student.getStudentID(), att);
            }
            student.setHistoryAttendance(attend);

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




















    //TODO Caner Unal 285- 335
    @Override
    public void removeRepoSomeoneInfo(Student person) {





































        

    }



// Zehra Erol 526 - 626





}

    //TODO Seval Senturk 337 - 537
    @Override
    public void updateAdressInfo(Student person, String adress) {


        JDBC_Utils.setConnection();

        String sql = "UPDATE t_student SET address=? WHERE std_id=?";

        JDBC_Utils.setPrst(sql);

        try {
            // Set the parameters for the prepared statement
            JDBC_Utils.getPrst().setString(1, adress);
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());

            // Execute the update statement
            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated Student Address Information !...");
            }

        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
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

        String sql = "UPDATE t_student SET grade=? WHERE std_id=?";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setString(1, grades.name());
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());

            // Execute the update statement
            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated Student Grade Information !...");
            }

        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
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

        String sql = "UPDATE t_student SET payment=? WHERE std_id=?";

        JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setDouble(1,payment);
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());


            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated Student Payment Information !...");
            }

        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
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

        String sql = "UPDATE t_lessons SET studentNote=? WHERE std_id=? AND lesson_name=?";

        JDBC_Utils.setPrst(sql);

        try {

           JDBC_Utils.getPrst().setInt(1, note);
           JDBC_Utils.getPrst().setInt(2, person.getStudentID());
           JDBC_Utils.getPrst().setString(3, lesson.getName().name());


            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated Student Lesson Note !...");
            }

        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
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

        String sql = "UPDATE t_lessons SET successDegree=? WHERE studentID=? AND lesson_name=?";

        JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setString(1, successDegree.name());
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());
            JDBC_Utils.getPrst().setString(3, lessons.getName().name());


            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated Student Success Degree !...");
            }

        } catch (SQLException e) {
            System.err.println("Error : " + e.getMessage());
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




            if (resultSet.next()) {
                System.out.print(" Student ID : " + resultSet.getInt("std_id"));
                System.out.print(" Name : " + resultSet.getString("std_name"));
                System.out.print(" Last Name : " + resultSet.getString("std_surName"));
                System.out.print(" Address : " + resultSet.getString("address"));
                System.out.print(" Phone Number : " + resultSet.getString("phoneNumber"));
                System.out.print(" Student AVG : " + resultSet.getDouble("lastYearGradeAvg"));
                System.out.println();

            }
        } catch (SQLException e) {
            throw new StudentNotFoundException("The student with the ID you are looking for was not found !...");
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
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

                int id = resultSet.getInt("id");
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

                HashMap<Integer, Attendance> historyAttendance = new HashMap<>();
                student.setHistoryAttendance(historyAttendance);
                HashMap<Integer, Lessons> allLessons = new HashMap<>();
                student.setAllLessons(allLessons);

                allStudents.add(student);

            }
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        String query2 = "SELECT * FROM t_attendance ";//devamsizlik tablosundaki herseyi getiren sorgu
        ResultSet resultSet2 = null;
        try {
            resultSet2 = JDBC_Utils.getSt().executeQuery(query2);
            Attendance attendance = new Attendance();
            Lessons lessons=new Lessons();
            LessonsRepository lessonsRepository=new LessonsRepository();

            while (resultSet2.next()) {
                attendance.setDate(resultSet2.getDate("date"));
                LessonNames lessonNames=LessonNames.valueOf(resultSet2.getString("lesson_name"));//hangi dersten devamsizlik oldugunu bulmak icin
                //LessonsNames enum turunde oldugu icin valueOf() kullandik garanti olsun verilen deger ile enum degeri ayni olsun diye

                for(Lessons lesson: lessonsRepository.getAllLessons()) {
                    if (lesson.getName().equals(lessonNames)) {//db'deki devamsizlik tablosundan gelen lessonNames ile allLessonsdaki handi ders eslesmisse;
                        attendance.setLesson(lessons);//o dersi attendance objesine set ettik

                        int id = resultSet2.getInt("studentID");//db'den studentID'yi getirdik

                        for (Student student : allStudents) {
                            if (student.getStudentID() == id) {//db'deki id ile allStudentdaki hangi ogrenci eslesmisse;
                                student.getHistoryAttendance().put(id, attendance);//o ogrencinin historyAttendance'si Map'ine id ve attendace'yi ekledik
                            }
                        }
                    }
                }
        }
            }catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        String query3 = "SELECT * FROM t_lessons ";//lesson tablosundan herseyi getiren sorgu
        ResultSet resultSet3 = null;
        try {
            resultSet3 = JDBC_Utils.getSt().executeQuery(query3);
            Teacher teacher=new Teacher();//her lesson'in teacher'i oldugu icin Teacher'dan injeksion yaptik
            Lessons lessons=new Lessons();
            TeacherRepository teacherRepository=new TeacherRepository();
            while (resultSet3.next()) {//lesson tablosundan bilgileri alip lessons'a set ettik
                lessons.setName(LessonNames.valueOf(resultSet3.getString("lesson_name")));
                lessons.setLessonCredit(resultSet3.getInt("lessonCredit"));
                lessons.setLessonFee(resultSet3.getDouble("lessonFee"));
                lessons.setStudentNote(resultSet3.getInt("studentNote"));
                lessons.setDay(resultSet3.getString("lesson_day"));
                //lessons.setLessonSuccessDegree(resultSet3.);
                int teacherId=resultSet3.getInt("teacherID");


                for(Teacher teachers: teacherRepository.getAllTeacher()){
                    if (teachers.getTeacherID()==teacherId){
                        lessons.setTeacher(teachers);

                        int id=resultSet3.getInt("studentID");

                        for (Student student: allStudents){
                            if (student.getStudentID()==id){
                                student.getAllLessons().put(id,lessons);
                            }
                        }
                    }
                }
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