package per.example.filmlerapplication_ornek;

import java.io.Serializable;

public class Yonetmenler implements Serializable {
    private int yonetmen_id;
    private String yonetmen_Ad;

    public Yonetmenler() {
    }

    public Yonetmenler(int yonetmen_id, String yonetmen_Ad) {
        this.yonetmen_id = yonetmen_id;
        this.yonetmen_Ad = yonetmen_Ad;
    }

    public int getYonetmen_id() {
        return yonetmen_id;
    }

    public void setYonetmen_id(int yonetmen_id) {
        this.yonetmen_id = yonetmen_id;
    }

    public String getYonetmen_Ad() {
        return yonetmen_Ad;
    }

    public void setYonetmen_Ad(String yonetmen_Ad) {
        this.yonetmen_Ad = yonetmen_Ad;
    }
}
