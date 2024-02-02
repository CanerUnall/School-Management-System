package repository;

import config.JDBC_Utils;
import domain.Admins;

import java.sql.SQLException;
import java.sql.Statement;

public class AdminRepository {

    // Mustafa Ubeyde Kayhan 7 -  57
    public void createAdminTable(){
      /*  bu methodun query si yazilirken if not exist kullanilacak

        tablo adi = t_admin

        adminID bu pk olacak
        teacherID foreign key

*/








































        // Mustafa Ubeyde Kayhan 7 -  57
    }

    // Mustafa Ubeyde Kayhan 61 -  161
    public Admins find(int id){
     //buradan girilen idye gore dbden admin bilgileri alinacak ve obje olusturulup return edilecek

        return null;



























































































        // Mustafa Ubeyde Kayhan 61 -  161
    }


// Rumeysa Dagtekin 164 - 264
   public void addAdminRepo(Admins admin){

        //burada projede yer alan arkadaslar admin olarak dbye eklenmesi icin gerekli sorgu yazilacak.

       JDBC_Utils.setConnection();
       JDBC_Utils.setStatement();

       String sql="INSERT INTO t_admin VALUES ( "+ admin.getAdminID()+
                                                ","+admin.getTeacherID()+ ")";

               try{
                   JDBC_Utils.getSt().executeQuery(sql);
               }catch (SQLException e){
                   System.out.println(e.getMessage());
               }finally {

                   try {
                       JDBC_Utils.getSt().close();
                       JDBC_Utils.getCon().close();
                   } catch (SQLException e) {
                       System.out.println(e.getMessage());
                   }
               }






























































































        // Rumeysa Dagtekin 164 - 264
    }

}
