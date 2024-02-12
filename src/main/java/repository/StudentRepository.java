package repository;

import config.JDBC_Utils;
import domain.*;

import java.sql.SQLException;

import java.util.List;

import domain.UserRol;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements SameRepoOperations<Student> {

    public void createStudentTable() {

        JDBC_Utils.setConnection();//DB ile bağlantı kurmak için  Connection
        JDBC_Utils.setStatement();//Sorgu oluşturmak için Statement
        //JDBC_Utils.setPrst();//Belki parametreli sorgular oluşturmak için PreparedStatement
        try {
            JDBC_Utils.getSt().executeUpdate("CREATE TABLE IF NOT EXISTS t_student(" +
                    "    std_id INT PRIMARY KEY," +
                    "    std_name VARCHAR(50) NOT NULL CHECK(LENGTH(std_name) > 0)," +
                    "    std_surName VARCHAR(50) NOT NULL CHECK(LENGTH(std_surName) > 0)," +
                    "    password VARCHAR(30) NOT NULL CHECK(LENGTH(password) > 8)," +
                    "    address VARCHAR(50) NOT NULL," +
                    "    phoneNumber VARCHAR(50)," +
                    "    role VARCHAR(50)," +
                    "    grade VARCHAR(50)," +
                    "    thisYearGradeAvg REAL CHECK(lastYearGradeAvg >= 0)," +
                    "    lastYearGradeAvg REAL CHECK(lastYearGradeAvg >= 0)," +
                    "    payment REAL," +
                    "    totalPrice REAL," +
                    "    percentDiscount INT," +
                    "    lessonCredit INT" +
                    ");");

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
    public Student find(int id) {

        JDBC_Utils.setConnection();// veritabanına bağlanmak için gerekli olan bağlantı ve statement arayüzünü ayarlıyoruz
        JDBC_Utils.setStatement();
        String query = ("SELECT * FROM t_student WHERE std_id=" + id);//Ardından, verilen ID'ye göre öğrenci bilgilerini almak için
        // bir sorgu (query) oluşturuyor ve bu sorguyu çalıştırıyoruz.
        Student student = null;
        try {
            ResultSet resultSet = JDBC_Utils.getSt().executeQuery(query);//sorguyu çalıştırarak sonuçları alıyoruz

            while (resultSet.next()) {
                student = new Student();//Yeni bir öğrenci objesi oluşturuyoruz Sonuç kümesinden alınan değerleri öğrenci objesine atıyoruz
                student.setStudentID(resultSet.getInt("std_id"));
                student.setName(resultSet.getString("std_name"));
                student.setSurName(resultSet.getString("std_surName"));
                student.setPassword(resultSet.getString("password"));
                student.setRole(UserRol.STUDENT);
                student.setAddress(resultSet.getString("address"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
                student.setThisYearGradeAvg(resultSet.getDouble("thisYearGradeAvg"));
                student.setLastYearGradeAvg(resultSet.getDouble("lastYearGradeAvg"));
                student.setPayment(resultSet.getDouble("payment"));
                student.setTotalPrice(resultSet.getInt("totalPrice"));
                student.setPercentDiscount(resultSet.getInt("percentDiscount"));
                student.setLessonCredit(resultSet.getInt("lessonCredit"));
                Grades grade = Grades.valueOf(resultSet.getString("grade"));
                student.setGrade(grade);
                List<Attendance> historyAttendance = new ArrayList<>();// Boş devam durumu ve ders listesi oluşturulur
                student.setHistoryAttendance(historyAttendance);//Eğer direkt olarak bir Attendance objesini öğrenciye set etmek isteseydik,
                //  bir öğrenci sadece bir tane devam (attendance) kaydına sahip olabilirdi.
                // Ancak genellikle bir öğrencinin birden fazla dersi olabilir ve her ders için ayrı bir devam durumu
                // kaydı bulunabilir. Bu yüzden her ders için ayrı bir devam durumu oluşturulmalı ve bu devam durumları
                // bir listede saklanmalıdır.
                List<Lessons> allLessons = new ArrayList<>();
                student.setAllLessons(allLessons);// allLessons doğrudan set edilmedi, çünkü her öğrenci nin dersleri  bir listede tutulmalıdır
                // ve her bir ders öğrenciye özgü bir özellik içerebilir. Bu durumda, her öğrencinin aldığı dersleri temsil
                //eden bir liste (List<Lessons>) oluşturmak ve bu liste üzerinde işlem yapmak daha uygun oluyor.
                // Bu kod parçasında, öğrencinin aldığı derslerin bilgilerini tutmak için önce bir boş HashMap<Integer, Lessons>
                // oluşturulur. Daha sonra her bir ders için  döngü oluşturulur, ders bilgileri alınır ve bu bilgiler
                // allLessons hash map'ine eklenir. Sonuç olarak, öğrencinin aldığı tüm dersler allLessons adlı bu hash map
                // içerisinde saklanır. Bu yapı, her dersin öğrenciye özgü bir şekilde tutulmasını sağlar.
            }
        } catch (SQLException e) { // Veritabanı hatası durumunda bir RuntimeException fırlatır.
            System.out.println(e.getMessage() + "hata burada1");
        }

        String studentAllLesson = "SELECT * FROM t_attendance WHERE std_id=" + id;//Öğrencinin devam durumu için bir sorgu daha (studentAllLesson) oluşturuluyor
        // ve bu sorgu çalıştırılarak öğrencinin devam durumu bilgileri alınıyor. Bu bilgiler bir Attendance objesine atanıyor ve öğrenci objesine ekleniyor.
        try {
            ResultSet resultSet2 = JDBC_Utils.getSt().executeQuery(studentAllLesson);// // Öğrencinin devam durumu sorgusunu çalıştırır
            LessonsRepository lessonsRepository = new LessonsRepository();// Derslerin depolandığı bir repository oluşturulur
            List<Lessons> allLessons = lessonsRepository.getAllLessons(); // Tüm dersleri alır

            while (resultSet2.next()) {
                Attendance attend = new Attendance(); // Yeni bir devam nesnesi oluşturuyoruz
                for (Lessons lessons : allLessons) { // Tüm dersler üzerinde döngü oluşturuyoruz
                    if (lessons.getName().name().equals(resultSet2.getString("lesson_name"))) { // Eğer dersin adı, veritabanından gelen ad ile eşleşiyorsa
                        attend.setLesson(lessons);//attend objesine ekliyoruz
                    }
                }
                attend.setDate(resultSet2.getDate("date")); // Devam durumu tarih bilgilerini ayarlıyoruz
                if (student != null) {
                    student.getHistoryAttendance().add(attend);
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage() + "hata burada2"); // SQL istisnası durumunda hata mesajı yazdırıyoruz
        } finally {
            try {
                JDBC_Utils.getSt().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage() + "hata burada4");
            }
        }
        JDBC_Utils.setConnection();

        try {

            String query3 = "SELECT * FROM t_lessons WHERE std_id =?";
            JDBC_Utils.setPrst(query3);
            JDBC_Utils.getPrst().setInt(1, id); // id parametresini ayarla
            ResultSet resultSet3 = JDBC_Utils.getPrst().executeQuery();
            TeacherRepository teacherRepository = new TeacherRepository(); // Öğretmenlerin depolandığı bir repository oluşturuyoruz

            while (resultSet3.next()) {//lesson tablosundan bilgileri alip lessons'a set ediyoruz
                Lessons lessons = new Lessons();// lessons objesi oluşturuyoruz
                lessons.setName(LessonNames.valueOf(resultSet3.getString("lesson_name")));
                lessons.setLessonCredit(resultSet3.getInt("lessonCredit"));
                lessons.setLessonFee(resultSet3.getDouble("lessonFee"));
                lessons.setStudentNote(resultSet3.getInt("studentNote"));
                lessons.setDay(resultSet3.getString("lesson_day"));
                int teacherId = resultSet3.getInt("teacherID"); // Öğretmen ID'sini alıyoruz
                for (Teacher teachers : teacherRepository.getAllTeacher()) {   // Tüm öğretmenler üzerinde for döngüsü kuruyoruz
                    if (teachers.getTeacherID() == teacherId) { // Eğer öğretmenin ID'si, veritabanından gelen ID ile eşleşiyorsa
                        lessons.setTeacher(teachers);//öğretmen bilgisini lessons'a set ediyoruz
                    }
                }
                String successDegreeString = resultSet3.getString("lessonSuccessDegree");
                if (successDegreeString != null) {
                    try {
                        lessons.setLessonSuccessDegree(SuccessDegree.valueOf(successDegreeString));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Geçersiz lessonSuccessDegree: " + successDegreeString);
                        // Burada bir hata işleme mekanizması ekleyebilirsiniz.
                    }
                } else {
                    // successDegreeString null ise, uygun bir işlem yapılmalı
                }

                if (student != null) {
                    student.getAllLessons().add(lessons);
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage() + "hata burada3");
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println(e.getMessage() + "hata burada4");
            }
        }
        return student;
    }


    @Override
    public void addRepoSomeoneInfo(Student person) {

        JDBC_Utils.setConnection();
        String sql = "INSERT INTO t_student (std_id, std_name, std_surName, password, address," +
                " phoneNumber,role,grade,thisYearGradeAvg,lastYearGradeAvg,payment,totalPrice,percentDiscount,lessonCredit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";

        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setInt(1, person.getStudentID());
            JDBC_Utils.getPrst().setString(2, person.getName());
            JDBC_Utils.getPrst().setString(3, person.getSurName());
            JDBC_Utils.getPrst().setString(4, person.getPassword());
            JDBC_Utils.getPrst().setString(5, person.getAddress());
            JDBC_Utils.getPrst().setString(6, person.getPhoneNumber());
            JDBC_Utils.getPrst().setString(7, String.valueOf(person.getRole()));
            JDBC_Utils.getPrst().setString(8, String.valueOf(person.getGrade()));
            JDBC_Utils.getPrst().setDouble(9, person.getThisYearGradeAvg());
            JDBC_Utils.getPrst().setDouble(10, person.getLastYearGradeAvg());
            JDBC_Utils.getPrst().setDouble(11, person.getPayment());
            JDBC_Utils.getPrst().setDouble(12, person.getTotalPrice());
            JDBC_Utils.getPrst().setInt(13, person.getPercentDiscount());
            JDBC_Utils.getPrst().setDouble(14, person.getLessonCredit());

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
    public void removeRepoSomeoneInfo(Student person) {

        JDBC_Utils.setConnection();
        String sql = "DELETE FROM t_student WHERE std_id = ?";
        JDBC_Utils.setPrst(sql);

        try {
            JDBC_Utils.getPrst().setInt(1, person.getStudentID());

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

        String sql = "SELECT * FROM t_student WHERE std_id = ?";

        JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setInt(1, id);
            ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();

            while (resultSet.next()) {
                System.out.print("Student ID : " + resultSet.getInt("std_id"));
                System.out.print(" Name : " + resultSet.getString("std_name"));
                System.out.print(" Last Name : " + resultSet.getString("std_surName"));
                System.out.print(" Address : " + resultSet.getString("address"));
                System.out.print(" Phone Number : " + resultSet.getString("phoneNumber"));
                System.out.print(" Student AVG : " + resultSet.getDouble("thisYearGradeAvg"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }
        }

    }

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

    }

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

    public void updateFeeInfo(Student person, Double payment) {

        JDBC_Utils.setConnection();

        String sql = "UPDATE t_student SET payment=? WHERE std_id=?";

        JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setDouble(1, payment);
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

    public void updateTotalPriceInfo(Student person, Double totalPrice) {

        JDBC_Utils.setConnection();

        String sql = "UPDATE t_student SET totalPrice=? WHERE std_id=?";

        JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setDouble(1, totalPrice);
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());


            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated Student Total Price Information !...");
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

    public void updateLessonNoteInfo(Student person, Lessons lesson, int note) {

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


    }

    public void updateSuccessDegreeInfo(Student person, Lessons lessons, SuccessDegree successDegree) {


        JDBC_Utils.setConnection();

        String sql = "UPDATE t_lessons SET lessonSuccessDegree=? WHERE std_id=? AND lesson_name=?";

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

    public void updateStudentLessonCredit(Student person, int credit) {

        JDBC_Utils.setConnection();

        String sql = "UPDATE t_student SET lessonCredit=? WHERE std_id=?";

        JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setInt(1, credit);
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());


            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated Student Lesson Credit !...");
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

    public void updateRepoThisYearGradeAvg(Student person, double thisYearAvg) {

        JDBC_Utils.setConnection();

        String sql = "UPDATE t_student SET thisYearGradeAvg=? WHERE std_id=?";

        JDBC_Utils.setPrst(sql);

        try {

            JDBC_Utils.getPrst().setDouble(1, thisYearAvg);
            JDBC_Utils.getPrst().setInt(2, person.getStudentID());


            int affectedRows = JDBC_Utils.getPrst().executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Updated Student This Year Avg !...");
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

    public List<Student> getAllStudents() {
        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        List<Student> allStudents = new ArrayList<>();

        String query = "SELECT * FROM t_student";


        try {
            ResultSet resultSet = JDBC_Utils.getSt().executeQuery(query);


            while (resultSet.next()) {
                Student student = new Student();

                int id = resultSet.getInt("std_id");
                student.setStudentID(id);
                student.setName(resultSet.getString("std_name"));
                student.setSurName(resultSet.getString("std_surname"));
                student.setRole(UserRol.STUDENT);
                student.setAddress(resultSet.getString("address"));
                student.setPhoneNumber(resultSet.getString("phoneNumber"));
                student.setThisYearGradeAvg(resultSet.getInt("thisYearGradeAvg"));
                student.setLastYearGradeAvg(resultSet.getInt("lastYearGradeAvg"));
                student.setPayment(resultSet.getInt("payment"));
                student.setTotalPrice(resultSet.getInt("totalPrice"));
                student.setLessonCredit(resultSet.getInt("lessonCredit"));
                student.setThisYearGradeAvg(resultSet.getDouble("thisYearGradeAvg"));
                student.setPercentDiscount(resultSet.getInt("percentDiscount"));

                Grades grade = Grades.valueOf(resultSet.getString("grade"));
                student.setGrade(grade);

                List<Attendance> historyAttendance = new ArrayList<>();
                student.setHistoryAttendance(historyAttendance);
                List<Lessons> allLessons = new ArrayList<>();
                student.setAllLessons(allLessons);

                allStudents.add(student);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        String query2 = "SELECT * FROM t_attendance ";//devamsizlik tablosundaki herseyi getiren sorgu

        try {
            ResultSet resultSet2 = JDBC_Utils.getSt().executeQuery(query2);
            Attendance attendance = new Attendance();
            Lessons lessons = new Lessons();
            LessonsRepository lessonsRepository = new LessonsRepository();

            while (resultSet2.next()) {
                attendance.setDate(resultSet2.getDate("date"));
                LessonNames lessonNames = LessonNames.valueOf(resultSet2.getString("lesson_name"));//hangi dersten devamsizlik oldugunu bulmak icin
                //LessonsNames enum turunde oldugu icin valueOf() kullandik garanti olsun verilen deger ile enum degeri ayni olsun diye

                for (Lessons lesson : lessonsRepository.getAllLessons()) {
                    if (lesson.getName().equals(lessonNames)) {//db'deki devamsizlik tablosundan gelen lessonNames ile allLessonsdaki handi ders eslesmisse;
                        attendance.setLesson(lessons);//o dersi attendance objesine set ettik

                        int id = resultSet2.getInt("studentID");//db'den studentID'yi getirdik

                        for (Student student : allStudents) {
                            if (student.getStudentID() == id) {//db'deki id ile allStudentdaki hangi ogrenci eslesmisse;
                                student.getHistoryAttendance().add(attendance);//o ogrencinin historyAttendance'si Map'ine id ve attendace'yi ekledik
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        String query3 = "SELECT * FROM t_lessons ";//lesson tablosundan herseyi getiren sorgu

        try {
            ResultSet resultSet3 = JDBC_Utils.getSt().executeQuery(query3);
            Lessons lessons = new Lessons();
            TeacherRepository teacherRepository = new TeacherRepository();
            while (resultSet3.next()) {//lesson tablosundan bilgileri alip lessons'a set ettik
                lessons.setName(LessonNames.valueOf(resultSet3.getString("lesson_name")));
                lessons.setLessonCredit(resultSet3.getInt("lessonCredit"));
                lessons.setLessonFee(resultSet3.getDouble("lessonFee"));
                lessons.setStudentNote(resultSet3.getInt("studentNote"));
                lessons.setDay(resultSet3.getString("lesson_day"));
                int teacherId = resultSet3.getInt("teacherID");
                String successDegreeString = resultSet3.getString("lessonSuccessDegree");
                if (successDegreeString != null) {
                    try {
                        lessons.setLessonSuccessDegree(SuccessDegree.valueOf(successDegreeString));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Geçersiz lessonSuccessDegree: " + successDegreeString);
                        // Burada bir hata işleme mekanizması ekleyebilirsiniz.
                    }
                } else {
                    // successDegreeString null ise, uygun bir işlem yapılmalı
                }
                for (Teacher teachers : teacherRepository.getAllTeacher()) {
                    if (teachers.getTeacherID() == teacherId) {
                        lessons.setTeacher(teachers);

                        int id = resultSet3.getInt("studentID");

                        for (Student student : allStudents) {
                            if (student.getStudentID() == id) {
                                student.getAllLessons().add(lessons);
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

    }

    public void getStudentThisYearGradeAvg() {
        JDBC_Utils.setConnection();

        String sql = "SELECT std_id, std_name, std_surName, thisYearGradeAvg FROM t_student ORDER BY thisYearGradeAvg DESC";

        JDBC_Utils.setPrst(sql);

        try {

            ResultSet resultSet = JDBC_Utils.getPrst().executeQuery();

            while (resultSet.next()) {
                System.out.print("Student ID : " + resultSet.getInt("std_id"));
                System.out.print(" Name : " + resultSet.getString("std_name"));
                System.out.print(" Last Name : " + resultSet.getString("std_surName"));
                System.out.print(" Student AVG : " + resultSet.getDouble("thisYearGradeAvg"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                JDBC_Utils.getPrst().close();
                JDBC_Utils.getCon().close();
            } catch (SQLException e) {
                System.err.println("Error : " + e.getMessage());
            }
        }

    }
}