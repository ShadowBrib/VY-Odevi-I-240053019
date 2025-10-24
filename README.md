# Veri Yapıları Ödevi I: Bağlı Liste ile Randevu Takip Sistemi

* **Video Sunumu:**
---

**Öğrenci Bilgileri**
* **Adı Soyadı: Enes Çalış** 
* **Öğrenci Numarası: 240053019** 

## Ödev Açıklaması

Bu proje, Veri Yapıları dersi kapsamında bir kliniğin hasta randevularını takip etmek için kullandığı basit bir sistemi  simüle eder. Proje, Java'nın hazır kütüphaneleri kullanılmadan , Tek Yönlü Doğrusal Bağlı Liste (Singly Linked List) veri yapısı sıfırdan tasarlanarak  geliştirilmiştir.

Sistem; acil durum (listenin başına ekleme), normal randevu (listenin sonuna ekleme), randevu iptali (listeden düğüm silme), randevu arama ve tüm listeyi görüntüleme işlemlerini destekler.

## Sınıf Yapıları 

Proje, ödev yönergelerine uygun olarak 4 ana sınıftan oluşmaktadır:

1.  **`Hasta.java`**
    * **Amaç:** Randevu sistemindeki bir hastanın veri modelini tutar.
    * **İçerik:** `hastaID`, `adSoyad`, `randevuTarihi` değişkenlerini ve bu bilgileri ekrana basan `bilgileriGoster()` metodunu içerir.

2.  **`Node.java`**
    * **Amaç:** Bağlı listenin her bir düğümünü temsil eder.
    * **İçerik:** `veri` (bir `Hasta` nesnesi) ve `sonraki` (bir sonraki `Node` referansı) olmak üzere iki değişken içerir.

3.  **`RandevuListesi.java`**
    * **Amaç:** Bağlı listenin tüm mantığını ve operasyonel metotlarını içeren yönetici sınıftır.
    * **İçerik:** Listenin başını tutan `head` referansını ve aşağıdaki ana metotları içerir:
        * `acilDurumEkle(Hasta hasta)`: Hastayı listenin başına ekler.
        * `randevuEkle(Hasta hasta)`: Hastayı listenin sonuna ekler.
        * `randevulptal(int hastaID)`: Verilen ID'ye sahip hastayı listeden siler.
        * `randevuAra(int hastaID)`: Verilen ID'ye sahip hastayı listede arar ve bulursa bilgilerini gösterir.
        * `listeyiGoruntule()`: Listedeki tüm hastaları sırayla ekrana yazdırır.

4.  **`Main.java`**
    * **Amaç:** `RandevuListesi` sınıfında tanımlanan tüm metotların doğru çalışıp çalışmadığını test etmek için kullanılır.
