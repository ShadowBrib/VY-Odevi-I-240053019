package com.etu.randevusistemi;

/**
 * Tek Yönlü Doğrusal Bağlı Liste mantığını ve metotlarını içeren yönetici sınıf.
 * Bu sınıf, Java'nın hazır kütüphaneleri kullanılmadan sıfırdan tasarlanmıştır.
 */
public class RandevuListesi {

    Node head; // Listenin başını (ilk düğümü) gösteren referans.

    /**
     * RandevuListesi sınıfı için yapıcı metot (Constructor).
     * Listenin başını (head) null olarak başlatır.
     */
    public RandevuListesi() {
        this.head = null;
    }

    /**
     * Acil durum hastalarını listenin BAŞINA ekler.
     * * @param hasta Başa eklenecek Hasta nesnesi.
     */
    public void acilDurumEkle(Hasta hasta) {
        Node yeniAcilHasta = new Node(hasta);
        yeniAcilHasta.sonraki = head; // Yeni düğümün 'sonraki' referansı eski 'head'i gösterir.
        head = yeniAcilHasta; // 'head' referansı artık yeni düğümü gösterir.
        System.out.println("'" + hasta.adSoyad + "' acil durum olarak listenin başına eklendi.");
    }

    /**
     * Normal randevuları listenin SONUNA ekler.
     * *@param hasta Sona eklenecek Hasta nesnesi.
     */
    public void randevuEkle(Hasta hasta) {
        Node yeniRandevu = new Node(hasta);

        // Liste boşsa, bu düğümü 'head' (ilk eleman) yap.
        if (head == null) {
            head = yeniRandevu;
        } else {
            //Liste boş değilse, Listenin sonuna bulmak için 'head' den başla.
            Node temp = head;
            while (temp.sonraki != null) {
                temp = temp.sonraki; // Son düğüme kadar ilerle.
            }
            // Son düğümün 'sonraki' referansına yeni düğümü ata.
            temp.sonraki = yeniRandevu;
        }
        System.out.println("'" + hasta.adSoyad + "' normal randevu olarak listenin sonuna eklendi.");
    }
    /**
     * Verilen hastaID'ye göre listeden randevu siler (iptal eder).
     * * @param hastaID Silinecek hastanın kimlik numarası.
     */
    public void randevulptal(int hastaID) {
        // Liste boşsa, işlem yapma.
        if (head == null) {
            System.out.println("Hata: Liste boş, silinecek hasta bulunamadı.");
            return;
        }

        // Silinecek düğüm 'head' (ilk düğüm) ise:
        if (head.veri.hastaId == hastaID) {
            System.out.println("'" + head.veri.adSoyad + "' ID'li hastanın randevusu iptal edildi (Head).");
            head = head.sonraki; // 'head' referansını bir sonraki düğüme kaydır.
            return;
        }
        // Silinecek düğüm 'head' değilse (arada veya sonda ise):
        Node temp = head;
        Node onceki = null; // Silinecek düğümden bir önceki düğümü tutar.

        // Listede 'hastaID'yi ara.
        while (temp != null && temp.veri.hastaId != hastaID) {
            onceki = temp;
            temp = temp.sonraki;
        }
        // 'temp == null' ise, döngü listenin sonuna gelmiş ve hasta bulunamamıştır.
        if (temp == null) {
            System.out.println(hastaID + " ID'li hasta bulunamadı.");
        } else {
            // Hasta bulundu (temp, silinecek düğümü gösteriyor).
            // 'onceki' düğümün 'sonraki' referansını, 'temp'in 'sonraki' referansına bağla.
            // Bu, 'temp' düğümünü atlar (listeden çıkarır).
            onceki.sonraki = temp.sonraki;
            System.out.println("'" + temp.veri.adSoyad + "' ID'li hastanın randevusu iptal edildi.");
        }
    }
    /**
     * Verilen hastaID'ye göre hastayı arar ve bilgilerini gösterir. [cite: 57, 34]
     * * @param hastaID Aranan hastanın kimlik numarası.
     */
    public void randevuAra(int hastaID) {
        Node temp = head; // Aramaya 'head'den başla.

        while (temp != null) {
            if (temp.veri.hastaId == hastaID) {
                // Hasta bulundu, bilgilerini göster ve metottan çık.
                System.out.print("Bulunan Hasta -> ");
                temp.veri.bilgileriGoster(); // [cite: 57]
                return;
            }
            temp = temp.sonraki; // Bir sonraki düğüme geç.
        }

        // Döngü bittiyse ve 'return' olmadıysa, hasta bulunamamıştır.
        System.out.println(hastaID + " ID'li hasta bulunamadı."); // [cite: 57]

    }
    /**
     * Randevu listesindeki tüm hastaları sırayla görüntüler. [cite: 58, 34]
     */
    public void listeyiGoruntule() {
        if (head == null) {
            System.out.println("Randevu listesi boş."); // [cite: 58]
            return;
        }

        System.out.println("--- TÜM RANDEVU LİSTESİ ---");
        Node temp = head;
        int sayac = 1;
        while (temp != null) {
            System.out.print(sayac + ". ");
            temp.veri.bilgileriGoster();
            temp = temp.sonraki;
            sayac++;
        }
        System.out.println("-----------------------------");
    }
}