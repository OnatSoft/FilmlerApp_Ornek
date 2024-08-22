package per.example.filmlerapplication_ornek;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KategoriDao {

    public ArrayList<Kategoriler> tumKategoriler(DBConnection dbc){

        ArrayList<Kategoriler> kategorilerArrayList = new ArrayList<>();
        SQLiteDatabase db = dbc.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM kategoriler", null);

        while (c.moveToNext()){
            Kategoriler ktg = new Kategoriler(
                    c.getInt(c.getColumnIndexOrThrow("kategori_id"))
                    ,c.getString(c.getColumnIndexOrThrow("kategori_ad")));
            kategorilerArrayList.add(ktg);
        }

        return kategorilerArrayList;
    }
}
