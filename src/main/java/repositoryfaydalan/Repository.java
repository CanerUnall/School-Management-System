/*import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static Connection con;
    private static Statement st;
    private static PreparedStatement prst;

    private static void setConnection() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Shopping_Site", "Caner Unal", "Asd181116.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void setStatement() {
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void setPrst(String query) {
        try {
            prst = con.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    static void startWithJdbc() {

        setConnection();
        setStatement();

        String createTableAdmin = "CREATE TABLE IF NOT EXISTS t_admins (admin_id VARCHAR(20)," +
                "admin_password VARCHAR(20))";

        String createTableCustomer = "CREATE TABLE IF NOT EXISTS t_customers (id_number VARCHAR(50), name VARCHAR(30)," +
                "password VARCHAR(30), gender VARCHAR(10), age INTEGER, emails VARCHAR(40), cargo_address VARCHAR(50)," +
                "card_number VARCHAR(30), card_expiration_date VARCHAR(10), card_cvv VARCHAR(5), phone_number VARCHAR(10), balance REAL, bonus REAL)";


        String createTableCustomerUploadHistory = "CREATE TABLE IF NOT EXISTS t_c_upload_history (id_number VARCHAR(50), date VARCHAR(15)," +
                "old_balance REAL, upload_amount REAL, new_balance REAL)";

        String createTableCustomerWithdrawHistory = "CREATE TABLE IF NOT EXISTS t_c_withdraw_history (id_number VARCHAR(50), date VARCHAR(15)," +
                "old_balance REAL, withdraw_amount REAL, new_balance REAL)";

        String createTableCustomerBonusHistory = "CREATE TABLE IF NOT EXISTS t_c_bonus_history (id_number VARCHAR(50), date VARCHAR(15)," +
                "upload_bonus REAL, new_bonus REAL)";

        String createTableCustomerPurchasedItemHistory = "CREATE TABLE IF NOT EXISTS t_c_purchased_item_history (id_number VARCHAR(50), date VARCHAR(15)," +
                "product_name VARCHAR(30),product_price REAL, product_amount INTEGER)";

        String createTableCustomerSpendHistory = "CREATE TABLE IF NOT EXISTS t_c_spend_history (id_number VARCHAR(50), date VARCHAR(15)," +
                "old_balance REAL, spend_amount REAL, new_balance REAL)";

        String createTableBlockedCustomer = "CREATE TABLE IF NOT EXISTS t_blocked_customers (id_number VARCHAR(50), name VARCHAR(30)," +
                "password VARCHAR(30), gender VARCHAR(10), age INTEGER, emails VARCHAR(40), cargo_address VARCHAR(50), card_number VARCHAR(30), " +
                "card_expiration_date VARCHAR(10), card_cvv VARCHAR(5), phone_number VARCHAR(10), balance REAL, bonus REAL)";

        try {
            st.executeUpdate(createTableAdmin);
            st.executeUpdate(createTableCustomer);
            st.executeUpdate(createTableCustomerUploadHistory);
            st.executeUpdate(createTableCustomerWithdrawHistory);
            st.executeUpdate(createTableCustomerBonusHistory);
            st.executeUpdate(createTableCustomerPurchasedItemHistory);
            st.executeUpdate(createTableCustomerSpendHistory);
            st.executeUpdate(createTableBlockedCustomer);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {


            String getAllCustomers = "SELECT * FROM t_customers";
            ResultSet result = st.executeQuery(getAllCustomers);
            while (result.next()) {
                String c_Id = result.getString("id_number");
                String cName = result.getString("name");
                String password = result.getString("password");
                String gender = result.getString("gender");
                int age = result.getInt("age");
                String email = result.getString("emails");
                String adres = result.getString("cargo_address");
                String cardNumber = result.getString("card_number");
                String lastDate = result.getString("card_expiration_date");
                String cvv = result.getString("card_cvv");
                String pNumber = result.getString("phone_number");
                double balance = result.getDouble("balance");
                double bonus = result.getDouble("bonus");


                List<Musteri> bakiyeYuklemeGecmisiAcilisi = new ArrayList<>();
                List<Musteri> bakiyeCekmeGecmisiAcilisi = new ArrayList<>();
                List<Urunler> alinanUrunGecmisiAcilisi = new ArrayList<>();
                List<Musteri> bonusGecmisiAcilisi = new ArrayList<>();
                List<Musteri> harcamaGecmisi = new ArrayList<>();

                List<Urunler> alisverisSepetiAcilisi = new ArrayList<>();

                Musteri musTeri = new Musteri(cName, password, age,
                        gender, cardNumber, lastDate, cvv,
                        adres, pNumber, email, balance, bonus, c_Id,
                        alisverisSepetiAcilisi, alinanUrunGecmisiAcilisi, bakiyeCekmeGecmisiAcilisi,
                        bakiyeYuklemeGecmisiAcilisi, bonusGecmisiAcilisi, harcamaGecmisi);

                Musteri.getTumKullanicilar().add(musTeri);


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {

            String getAllCustomers = "SELECT * FROM t_blocked_customers";
            ResultSet result = st.executeQuery(getAllCustomers);
            while (result.next()) {
                String c_Id = result.getString("id_number");
                String cName = result.getString("name");
                String password = result.getString("password");
                String gender = result.getString("gender");
                int age = result.getInt("age");
                String email = result.getString("emails");
                String adres = result.getString("cargo_address");
                String cardNumber = result.getString("card_number");
                String lastDate = result.getString("card_expiration_date");
                String cvv = result.getString("card_cvv");
                String pNumber = result.getString("phone_number");
                double balance = result.getDouble("balance");
                double bonus = result.getDouble("bonus");


                List<Musteri> bakiyeYuklemeGecmisiAcilisi = new ArrayList<>();
                List<Musteri> bakiyeCekmeGecmisiAcilisi = new ArrayList<>();
                List<Urunler> alinanUrunGecmisiAcilisi = new ArrayList<>();
                List<Musteri> bonusGecmisiAcilisi = new ArrayList<>();
                List<Musteri> harcamaGecmisi = new ArrayList<>();

                List<Urunler> alisverisSepetiAcilisi = new ArrayList<>();

                Musteri musTeri = new Musteri(cName, password, age,
                        gender, cardNumber, lastDate, cvv,
                        adres, pNumber, email, balance, bonus, c_Id,
                        alisverisSepetiAcilisi, alinanUrunGecmisiAcilisi, bakiyeCekmeGecmisiAcilisi,
                        bakiyeYuklemeGecmisiAcilisi, bonusGecmisiAcilisi, harcamaGecmisi);

                Musteri.getEngellenenKullanicilar().add(musTeri);


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {

            String getAllHistory = "SELECT * FROM t_c_upload_history";
            ResultSet result2 = st.executeQuery(getAllHistory);

            while (result2.next()) {

                String idNumber = result2.getString("id_number");
                String date = result2.getString("date");
                double oldBalance = result2.getDouble("old_balance");
                double amount = result2.getDouble("upload_amount");
                double newBalance = result2.getDouble("new_balance");

                Musteri bakiyeYuklemeIslemi = new Musteri(date, oldBalance, amount, newBalance, idNumber);

                for (Musteri hesap : Musteri.getTumKullanicilar()) {
                    if (hesap.getKullaniciNumarasi().equals(idNumber)) {
                        hesap.getBakiyeYuklemeGecmisi().add(bakiyeYuklemeIslemi);
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //----------------------------------------------
        try {
            String getAllHistory1 = "SELECT * FROM t_c_withdraw_history";
            ResultSet result3 = st.executeQuery(getAllHistory1);


            while (result3.next()) {
                String idNumber = result3.getString("id_number");
                String date = result3.getString("date");
                double oldBalance = result3.getDouble("old_balance");
                double amount = result3.getDouble("withdraw_amount");
                double newBalance = result3.getDouble("new_balance");


                Musteri islemGecmisi = new Musteri(date, oldBalance, amount, newBalance, idNumber);
                for (Musteri hesap : Musteri.getTumKullanicilar()) {
                    if (hesap.getKullaniciNumarasi().equals(idNumber)) {
                        hesap.getBakiyeCekmeGecmisi().add(islemGecmisi);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//-------------------------------------------------------------------
        try {
            String getAllHistory2 = "SELECT * FROM t_c_purchased_item_history";
            ResultSet result4 = st.executeQuery(getAllHistory2);


            while (result4.next()) {
                String idNumber = result4.getString("id_number");
                String date = result4.getString("date");
                String product_name = result4.getString("product_name");
                double product_price = result4.getDouble("product_price");
                int product_amount = result4.getInt("product_amount");


                Urunler alinanUrun = new Urunler(idNumber, date, product_name, product_price, product_amount);
                for (Musteri hesap : Musteri.getTumKullanicilar()) {
                    if (hesap.getKullaniciNumarasi().equals(idNumber)) {
                        hesap.getAlinanUrunGecmisi().add(alinanUrun);
                    }
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //-------------------------------------------------

        try {
            String getAllHistory3 = "SELECT * FROM t_c_bonus_history";
            ResultSet result5 = st.executeQuery(getAllHistory3);

            while (result5.next()) {
                String idNumber = result5.getString("id_number");
                String date = result5.getString("date");
                double upload_bonus = result5.getDouble("upload_bonus");
                double new_bonus = result5.getDouble("new_bonus");


                Musteri bonusGecmisi = new Musteri(idNumber, upload_bonus, date, new_bonus);
                for (Musteri hesap : Musteri.getTumKullanicilar()) {
                    if (hesap.getKullaniciNumarasi().equals(idNumber)) {
                        hesap.getBonusGecmisi().add(bonusGecmisi);
                    }
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

//--------------------------------------------------

        try {
            String getAllHistory4 = "SELECT * FROM t_c_spend_history";
            ResultSet result6 = st.executeQuery(getAllHistory4);


            while (result6.next()) {
                String idNumber = result6.getString("id_number");
                String date = result6.getString("date");
                double old_balance = result6.getDouble("old_balance");
                double upload_amount = result6.getDouble("spend_amount");
                double new_balance = result6.getDouble("new_balance");


                Musteri harcamaGecmisii = new Musteri(date, old_balance, upload_amount, new_balance, idNumber);

                for (Musteri hesap : Musteri.getTumKullanicilar()) {
                    if (hesap.getKullaniciNumarasi().equals(idNumber)) {
                        hesap.getHarcamaGecmisi().add(harcamaGecmisii);
                    }
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    static void customerAdd(Musteri musteri) {
        setConnection();


        String sql = "INSERT INTO t_customers(id_number, name ,password, gender, age, emails, cargo_address, card_number, " +
                "card_expiration_date, card_cvv, phone_number, balance, bonus)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        setPrst(sql);
        try {

            prst.setString(1, musteri.getKullaniciNumarasi());
            prst.setString(2, musteri.getKullaniciAdi());
            prst.setString(3, musteri.getKullanıcıSifre());
            prst.setString(4, musteri.getKullaniciCinsiyeti());
            prst.setInt(5, musteri.getKullaniciYasi());
            prst.setString(6, musteri.getMailAdresi());
            prst.setString(7, musteri.getKargoAdresi());
            prst.setString(8, musteri.getBankaKartiNumarasi());
            prst.setString(9, musteri.getSonKullanmaTarihi());
            prst.setString(10, musteri.getBankaKartiGuvenlikKodu());
            prst.setString(11, musteri.getTel());
            prst.setDouble(12, musteri.getSiteBakiyesi());
            prst.setDouble(13, musteri.getMusteriBonus());


            prst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void BlockedCustomerAdd(Musteri musteri) {
        setConnection();

        String sql = "INSERT INTO t_blocked_customers(id_number, name ,password, gender, age, emails, cargo_address, card_number, " +
                "card_expiration_date, card_cvv, phone_number, balance, bonus)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        setPrst(sql);
        try {

            prst.setString(1, musteri.getKullaniciNumarasi());
            prst.setString(2, musteri.getKullaniciAdi());
            prst.setString(3, musteri.getKullanıcıSifre());
            prst.setString(4, musteri.getKullaniciCinsiyeti());
            prst.setInt(5, musteri.getKullaniciYasi());
            prst.setString(6, musteri.getMailAdresi());
            prst.setString(7, musteri.getKargoAdresi());
            prst.setString(8, musteri.getBankaKartiNumarasi());
            prst.setString(9, musteri.getSonKullanmaTarihi());
            prst.setString(10, musteri.getBankaKartiGuvenlikKodu());
            prst.setString(11, musteri.getTel());
            prst.setDouble(12, musteri.getSiteBakiyesi());
            prst.setDouble(13, musteri.getMusteriBonus());

            prst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void uploadHistoryAdd(String cNumber, Musteri history) {
        setConnection();

        String sql = "INSERT INTO t_c_upload_history(id_number, date, old_balance,upload_amount,new_balance) VALUES (?,?,?,?,?)";
        setPrst(sql);
        try {

            prst.setString(1, cNumber);
            prst.setString(2, history.getIslemTarihi());
            prst.setDouble(3, history.getIslemOncesiSiteBakiyesi());
            prst.setDouble(4, history.getIslemTutari());
            prst.setDouble(5, history.getSiteBakiyesi());

            prst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void withdrawHistoryAdd(String cNumber, Musteri history) {
        setConnection();

        String sql = "INSERT INTO t_c_withdraw_history(id_number, date, old_balance,withdraw_amount,new_balance) VALUES (?,?,?,?,?)";
        setPrst(sql);
        try {

            prst.setString(1, cNumber);
            prst.setString(2, history.getIslemTarihi());
            prst.setDouble(3, history.getIslemOncesiSiteBakiyesi());
            prst.setDouble(4, history.getIslemTutari());
            prst.setDouble(5, history.getSiteBakiyesi());

            prst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void bonusHistoryAdd(String cNumber, Musteri history) {
        setConnection();

        String sql = "INSERT INTO t_c_bonus_history(id_number, date, upload_bonus,new_bonus) VALUES (?,?,?,?)";
        setPrst(sql);
        try {

            prst.setString(1, cNumber);
            prst.setString(2, history.getIslemTarihi());
            prst.setDouble(3, history.getKazanilanBonus());
            prst.setDouble(4, history.getMusteriBonus());


            prst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    static void purchasedItemHistoryAdd(String cNumber, Urunler history) {
        setConnection();

        String sql = "INSERT INTO t_c_purchased_item_history(id_number, date, product_name,product_price,product_amount) VALUES (?,?,?,?,?)";
        setPrst(sql);
        try {

            prst.setString(1, cNumber);
            prst.setString(2, history.getIslemTarihi());
            prst.setString(3, history.getUrunAdi());
            prst.setDouble(4, history.getUrunFiyati());
            prst.setInt(5, history.getAlinanUrunAdeti());

            prst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    static void spendHistoryAdd(String cNumber, Musteri history) {
        setConnection();

        String sql = "INSERT INTO t_c_spend_history(id_number, date, old_balance,spend_amount,new_balance) VALUES (?,?,?,?,?)";
        setPrst(sql);
        try {

            prst.setString(1, cNumber);
            prst.setString(2, history.getIslemTarihi());
            prst.setDouble(3, history.getIslemOncesiSiteBakiyesi());
            prst.setDouble(4, history.getIslemTutari());
            prst.setDouble(5, history.getSiteBakiyesi());

            prst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
*/