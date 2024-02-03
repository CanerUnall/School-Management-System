package repository;

import config.JDBC_Utils;
import domain.Lessons;
import domain.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinanceRepository {

    //TODO Rumeysa Dagtekin  15 - 115
    public void getRepoIncomeInfo(){

        //burada tum ogrencilerin cagrilacak ve bir dongu baslatilacak
        //daha sonra ogrencilerin aldiklari dersler de ayri bir donguye girecek
        //ogrencilerin aldiklari derslerin ders ucretleri toplanip gelir olarak yazdirilacak
        //her bir ogrenciden ne kadar alindigi gelir olarak gosterilecek

        //burada tum ogrencilerin aldigi derslerin ucretine ogre ogrencinin odemesi gerekn miktar gelir olarak gosterilecek
        //ogrenci adi - odemesi gereken tutar

        StudentRepository studentRepository=new StudentRepository();
        List<Student> studentList=studentRepository.getAllStudents();

            double sum=0;
            double sum2=0;
            for (Student each:studentList) {   //ogrenci listemizi donguye soktum

               HashMap<Integer,Lessons> lessonshp= each.getAllLessons(); // her ogrencinin derslerini getirip hashMap e atadim.

               for (Map.Entry<Integer,Lessons> w:lessonshp.entrySet()){ // hashMapi donguye sokmak icin entrySet metodunu kullandim

                     sum=sum+ w.getValue().getLessonFee();  //burada dersin ucretini sum'a atamis oldum. Bu dongunun sonunda ogrencinin secmis oldugu butun derslerin ucretleri toplanip sum'a atanir.
               }

               sum2+=sum; // her ogrenciden gelen gelirler sum2 ye atanir.
                System.out.println(each.getName()+" "+each.getSurName() +"--> "+ "Total:  "+sum);
            }
            System.out.println("Total Income: "+sum2); // Toplam gelir







































































        //Cihan Guler  5 - 105
    }

    //TODO Emrah Kaya 117 - 217 BURAYI BASKASI ALACAK
    public void getRepoExpenseInfo(){
        //burada ise tum ogretmenlerin ucretleri gider olarak gosterilecek
        //buna ilislik sorgu yazilacak
        // ogretmen adi - ucreti

        //toplam gider




























































































        //Emrah Kaya 107 - 217
    }

    //TODO  Semra Zengin  219 - 319
    public void getRepoPaymentTrackingInfo(){
        //tum ogrencilerin odemesi gereken tutar, odedigi tutar ve kalan tutar gosterilecek
        //buna iliskin sorgu yazilacak
        JDBC_Utils.setConnection();
        JDBC_Utils.setStatement();

        String query="SELECT studentID,std_name, std_surName, payment, totalPrice FROM t_student";
        System.out.println("====================PAYMENT TRACKING INFO OF ALL STUDENTS================");

        try {
            ResultSet resultSet=JDBC_Utils.getSt().executeQuery(query);
            int leftPrice= resultSet.getInt("totalPrice")-resultSet.getInt("payment");

            while (resultSet.next()){
                System.out.println("Id : "+resultSet.getInt("id"));
                System.out.println("Name : "+resultSet.getString("std_name"));
                System.out.println("Surname : "+resultSet.getString("std_surname"));
                System.out.println("Payment : "+resultSet.getInt("payment"));
                System.out.println("TotalPrice : "+resultSet.getInt("totalPrice"));
                if (leftPrice>0){
                    System.out.println("LeftPrice : "+leftPrice);
                }else{
                    System.out.println("LeftPrice : "+leftPrice+" -->All payments are completed");
                }

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































































































//Semra Zengin  209 - 309
    }
}
