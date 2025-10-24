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

}