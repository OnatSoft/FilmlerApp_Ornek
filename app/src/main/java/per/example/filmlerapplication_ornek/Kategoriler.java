package per.example.filmlerapplication_ornek;

import java.io.Serializable;

public class Kategoriler implements Serializable {
    private int kategori_id;
    private String kategori_Ad;

    public Kategoriler() {
    }

    public Kategoriler(int kategori_id, String kategori_Ad) {
        this.kategori_id = kategori_id;
        this.kategori_Ad = kategori_Ad;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getKategori_Ad() {
        return kategori_Ad;
    }

    public void setKategori_Ad(String kategori_Ad) {
        this.kategori_Ad = kategori_Ad;
    }
}
