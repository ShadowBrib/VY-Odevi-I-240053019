package com.etu.randevusistemi;

/**
 * Sistemi test eden, örnek verilerle metotları çağıran ana sınıf.
 * RandevuListesi sınıfının tüm metotlarını test eder.
 */
public class Main {
    public static void main(String[] args) {

        // 1. RandevuListesi oluştur.
        RandevuListesi liste = new RandevuListesi();

        // 2. Örnek hastalar oluştur.
        Hasta h1 = new Hasta(101, "Ahmet Yılmaz", "26.10.2025");
        Hasta h2 = new Hasta(102, "Zeynep Kaya", "27.10.2025");
        Hasta h3 = new Hasta(103, "Mehmet Demir", "28.10.2025");
        Hasta h4 = new Hasta(201, "Elif Çelik", "25.10.2025"); // Acil durum için

        // 3. Listeye normal (sona) ve acil (başa) eklemeler yap.
        liste.randevuEkle(h1);
        liste.randevuEkle(h2);
        liste.randevuEkle(h3);
        liste.acilDurumEkle(h4); // Elif Çelik listenin başına eklenmeli.

        // 4. Listeyi görüntüle.
        // Beklenen sıralama: Elif (201), Ahmet (101), Zeynep (102), Mehmet (103)
        liste.listeyiGoruntule();

        System.out.println("\n*** Arama Testleri ***");
        // 5. Var olan ve olmayan hastaları ara.
        liste.randevuAra(102); // Var olan (Zeynep Kaya)
        liste.randevuAra(999); // Var olmayan

        System.out.println("\n*** Silme Testleri ***");
        // 6. Var olan ve olmayan hastaları silmeyi dene. [cite: 66]

        // Aradan silme (102 - Zeynep Kaya)
        liste.randevulptal(102);
        liste.listeyiGoruntule(); // Liste güncellenmeli.

        // Baştan silme (201 - Elif Çelik)
        liste.randevulptal(201);
        liste.listeyiGoruntule(); // Liste güncellenmeli.

        // Var olmayan hastayı silme denemesi
        liste.randevulptal(999);
        liste.listeyiGoruntule(); // Liste değişmemeli.

        // Kalan son elemanı silme (103 - Mehmet Demir)
        liste.randevulptal(103);
        // Kalan son elemanı silme (101 - Ahmet Yılmaz)
        liste.randevulptal(101);

        // 7. Liste boş mu kontrol et.
        System.out.println("\n*** Liste Boş Kontrolü ***");
        liste.listeyiGoruntule(); // "Randevu listesi boş." mesajı vermeli.
    }
}