/*
PROJE YAZILIRKEN UYULACAK KURALLAR.
1- PROJEDE SENARYOSUNUN DISINA CIKILMAYACAK
2- POJO CLASSLAR VE METHOD ISIMLERI BELIRLENECEK VE ONA GORE GOREV DAGILIMI YAPILACAK.
3- PROJELERDE GITHUB AKTIF KULLANILACAK.
    --CLASSLARDA CODE BLOKLARI AYRILABILIR

    OKUL YONETIM SISTEMI
     GRENCI EKRANI
        1. KENDI BILGILERINI
        2. DERS PROGRAMINI GOR
        3. DERS SONUCLARINI
        4. DERS SECIMI
        5. YOKLAMA

    OGRETMEN/ADMIN EKRANI
    1- OGRENCILER
	    1- TUM OGRENCI BILGILERI
		* Adı, soyadı,numarasi, adresi, sınıfı,eski notu, notları ve başarı durumuyla birlikte tüm öğrenci bilgilerini içerir.

	2- OGRENCI ISLEMLERI
		1- EKLEME //ogrenci listteki eleman sayisi 20den fazla olamaz
        * Adı, soyadı, adresi, sınıfı ve ücret (4.5 DEN FAZLA ISE %20 INDIRIM) bilgilerini içeren yeni bir öğrenci eklenir.
        Öğrenci ekleme işlemine daha fazla detay ekleyebiliriz.
        Örneğin, veli bilgileri, öğrencinin kayıt tarihi gibi detayları sisteme ekleyebiliriz.
		2- SILME
			* Öğrenciyi ID'ye göre silme işlemi yapılır.
			Öğrenci silme işlemine ek olarak, silinen öğrencinin bilgilerini bir yedekleme mekanizması oluşturarak geri alma özelliği ekleyebiliriz.
		3- GUNCELLEME
			* Öğrenciyi ID'ye göre güncelleme yapılır. (Adres, sınıf, ücret gibi alanlar güncellenebilir.)
			Öğrenci güncelleme işlemine, notları güncelleme özelliğini de ekleyebiliriz.
		4- OGRENCI BUL
			* Öğrencinin ID'sine göre tüm bilgileri görüntüleme işlemi gerçekleştirilir.

    3- OGRENCI NOT TAKIBI
        1- TUM SINIFIN NOTUNU GORSUN (5, 20)
            * Seçilen sınıfın tüm öğrencilerinin notlarını görüntüleme işlemi yapılır.
            Tüm sınıfın notlarını görüntüleme işlemine sınıf seçimi ekleyebiliriz.
        2- OGRENCI NOTUNU GIR/DUZENLE
            * Belirli bir öğrencinin notlarını giriş ve düzenleme işlemi gerçekleştirilir.
            Öğrenci notlarını girerken, ders seçimi ve dönem seçimi ekleyerek daha ayrıntılı bir not takibi sağlayabiliriz.
        3- YOKLAMA GIRISI

    4- OGRETMENLER
        1- OGRETMEN BILGILERI
            * Sicil numarası, adı, soyadı, adresi ve branşı gibi öğretmen bilgilerini içerir.

        2- OGRETMEN ISLEMLERI
            1- EKLEME
                * Adı, soyadı, adresi, branşı ve maaşı bilgilerini içeren yeni bir öğretmen eklenir.
                Öğretmen ekleme işlemine, öğretmenin uzmanlık alanlarını ve sınıflara atanma özelliğini ekleyebiliriz.
            2- SILME
                * Öğretmeni ID'ye göre silme işlemi yapılır.
            3- GUNCELLEME
                * Öğretmeni ID'ye göre güncelleme yapılır. (Adres, branş, maaş gibi alanlar güncellenebilir.)
                Öğretmen güncelleme işlemine, öğretmenin bransını ve maaşını güncelleme özelliğini ekleyebiliriz.
            4- OGRETMEN BUL
                * Öğretmenin ID'sine göre bilgilerini görüntüleme işlemi gerçekleştirilir.

    5- RAPORLAMA
        1- DERSE GORE BASARI
            * Seçilen derse göre öğrenci başarı durumları raporlanır.
        2- SINIF BASARISI
            * Belirli bir sınıfın genel başarı durumu raporlanır.
        3- OGRENCI BASARISI
            * Belirli bir öğrencinin başarı durumu raporlanır.
        4- SIRALAMA
            * Öğrenci başarısı raporlarına, sıralama (notlara göre sıralama) özelliği ekleyebiliriz.

    6- FINANS(burasi sadece adminlerde gozukecek)
        1- BURAYA YONETICILER GIREBILIR (ID SIFRE KONTROLU OLACAK)
            * ID ve şifre kontrolü ile yöneticilerin finans bölümüne girişi sağlanır.
        2- GELIR TABLOSUNU GORUNTULE
            * Okula gelen gelirleri detaylı bir şekilde görüntüleme işlemi yapılır.
        3- GIDER TABLOSUNU GORUNTULE
            * Okulun harcamalarını içeren gider tablosu oluşturulur. Demirbaşlar gibi özel harcamalar eklenir.
        4- ODEME TAKIBI
            * Kimin ne kadar ödeme yaptığını izleme ve takip etme işlemi yapılır. (Döviz cinsinden ödemeler de dahil edilebilir.)

    GÜVENLİK
        * Kullanıcı girişi için daha güvenli bir kimlik doğrulama sistemi ekleyebiliriz.

    0- CIKIS
        * Programdan çıkış yapma işlemi gerçekleştirilir.

*/
