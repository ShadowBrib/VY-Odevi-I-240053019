package com.etu.randevusistemi;

/**
 * Hastanın verilerini tutan sınıf.
 * Hastanın ID, ad, soyad ve randevu tarihi bilgilerini içerir.
 */
public class Hasta {

    int hastaId;
    String adSoyad;
    String randevuTarihi;

    /**
     * Hasta sınıfı için yapıcı metot.
     * @param hastaId       Hastanın benzersiz kimlik numarası.
     * @param adSoyad       Hastanın adı ve soyadı.
     * @param randevuTarihi         Hastanın randevu tarihi.
     */
    public Hasta(int hastaId, String adSoyad, String randevuTarihi){
        this.hastaId = hastaId;
        this.adSoyad = adSoyad;
        this.randevuTarihi = randevuTarihi;
    }

    /**
     * Hastanın bilgilerini konsola yazdıran metot.
     */
    public void bilgileriGoster(){
        System.out.println(
                "Hasta ID: " + this.hastaId +
                ", Ad Soyad: " + this.adSoyad +
                ", Randevu Tarihi: " + this.randevuTarihi
        );
    }
}
