package repository;

import config.JDBC_Utils;
import domain.Grades;
import domain.Lessons;
import domain.Student;
import domain.UserRol;
import org.apache.commons.collections4.iterators.EntrySetMapIterator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinanceRepository {


    public void getRepoIncomeInfo(){
        //Cihan Guler-Rumeysa Dagtekin  5 - 105
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

    public void getRepoExpenseInfo(){
        //Emrah Kaya 107 - 207
        //burada ise tum ogretmenlerin ucretleri gider olarak gosterilecek
        //buna ilislik sorgu yazilacak
        // ogretmen adi - ucreti

        //toplam gider




























































































        //Emrah Kaya 107 - 207
    }

    public void getRepoPaymentTrackingInfo(){
//Semra Zengin  209 - 309
        //tum ogrencilerin odemesi gereken tutar, odedigi tutar ve kalan tutar gosterilecek
        //buna iliskin sorgu yazilacak































































































//Semra Zengin  209 - 309
    }


}
