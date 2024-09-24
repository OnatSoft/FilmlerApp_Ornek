package per.example.filmlerapplication_ornek;

import java.io.Serializable;

public class Filmler implements Serializable {
    private int film_id;
    private String film_Ad;
    private int film_Yil;
    private String film_Resim;
    private String film_Aciklama;
    private Kategoriler kategori_id;
    private Yonetmenler yonetmen_id;

    public Filmler() {
    }

    public Filmler(int film_id, String film_Ad, int film_Yil, String film_Resim, String film_Aciklama, Kategoriler kategori_id, Yonetmenler yonetmen_id) {
        this.film_id = film_id;
        this.film_Ad = film_Ad;
        this.film_Yil = film_Yil;
        this.film_Resim = film_Resim;
        this.film_Aciklama = film_Aciklama;
        this.kategori_id = kategori_id;
        this.yonetmen_id = yonetmen_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_Ad() {
        return film_Ad;
    }

    public void setFilm_Ad(String film_Ad) {
        this.film_Ad = film_Ad;
    }

    public int getFilm_Yil() {
        return film_Yil;
    }

    public void setFilm_Yil(int film_Yil) {
        this.film_Yil = film_Yil;
    }

    public String getFilm_Resim() {
        return film_Resim;
    }

    public void setFilm_Resim(String film_Resim) {
        this.film_Resim = film_Resim;
    }

    public String getFilm_Aciklama() {
        return film_Aciklama;
    }

    public void setFilm_Aciklama(String film_Aciklama) {
        this.film_Aciklama = film_Aciklama;
    }

    public Kategoriler getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(Kategoriler kategori_id) {
        this.kategori_id = kategori_id;
    }

    public Yonetmenler getYonetmen_id() {
        return yonetmen_id;
    }

    public void setYonetmen_id(Yonetmenler yonetmen_id) {
        this.yonetmen_id = yonetmen_id;
    }
}
