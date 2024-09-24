package per.example.filmlerapplication_ornek;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FilmlerDao {

    public ArrayList<Filmler> tumFilmlerByKategoriID(DBConnection dbc, int kategori_id){

        ArrayList<Filmler> filmlerArrayList = new ArrayList<>();
        SQLiteDatabase db = dbc.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM filmler,kategoriler,yonetmenler WHERE " +
                "filmler.kategori_id = kategoriler.kategori_id " +
                "AND filmler.yonetmen_id = yonetmenler.yonetmen_id AND filmler.kategori_id=" + kategori_id, null);

        while (c.moveToNext()){

            Yonetmenler y = new Yonetmenler(c.getInt(c.getColumnIndexOrThrow("yonetmen_id"))
                    ,c.getString(c.getColumnIndexOrThrow("yonetmen_ad")));

            Kategoriler k = new Kategoriler(c.getInt(c.getColumnIndexOrThrow("kategori_id"))
                    ,c.getString(c.getColumnIndexOrThrow("kategori_ad")));

            Filmler f = new Filmler(c.getInt(c.getColumnIndexOrThrow("film_id"))
                    , c.getString(c.getColumnIndexOrThrow("film_ad"))
                    , c.getInt(c.getColumnIndexOrThrow("film_yil"))
                    , c.getString(c.getColumnIndexOrThrow("film_resim"))
                    , c.getString(c.getColumnIndexOrThrow("film_aciklama")), k, y);
            filmlerArrayList.add(f);
        }

        return filmlerArrayList;
     }
}
