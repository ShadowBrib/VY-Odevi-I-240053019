package com.etu.randevusistemi;

/**
 * Bağlı listenin her bir düğümünü (Node) temsil eden sınıf.
 * Bu düğüm, bir Hasta nesnesini veri olarak tutar ve bir sonraki düğümü referans olarak gösterir.
 */
public class Node {
    Hasta veri; // Düğümün taşıdığı veri.
    Node sonraki; // Listenin bir sonraki elemanına olan referans.

    /**
     * Node sınıfı için yapıcı metot.
     * * @param hasta Bu düğümde saklanacak olan Hasta nesnesi.
     */
    public Node(Hasta hasta) {
        this.veri = hasta;
        this.sonraki = null; // Varsayılan olarak 'sonraki' referansı null ayarlanır.
    }
}
