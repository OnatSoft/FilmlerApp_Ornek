package per.example.filmlerapplication_ornek;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KategoriDao {
    SQLiteDatabase dbx;

    public ArrayList<Kategoriler> tumKategoriler(DBConnection dbc){

        ArrayList<Kategoriler> kategorilerArrayList = new ArrayList<>();
        SQLiteDatabase db = dbc.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM kategoriler", null);

        while (c.moveToNext()) {
            Kategoriler ktg = new Kategoriler(
                    c.getInt(c.getColumnIndexOrThrow("kategori_id"))
                    , c.getString(c.getColumnIndexOrThrow("kategori_ad")));
            kategorilerArrayList.add(ktg);
        }

        return kategorilerArrayList;
    }

    public void kategoriEkle(DBConnection dbc, String kategoriAd) {

        dbx = dbc.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("kategori_ad", kategoriAd);

        dbx.insertOrThrow("kategoriler", null, cv);
        dbx.close();
    }

    public void kategoriGuncelle(DBConnection dbc, String kategoriAd, int kategoriID) {

        dbx = dbc.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("kategori_ad", kategoriAd);
        cv.put("kategori_id", kategoriID);

        dbx.update("kategoriler", cv, "kategori_id=?", new String[]{String.valueOf(kategoriID)});
        dbx.close();
    }

    public void kategoriSil(DBConnection dbc, int kategoriID) {

        dbx = dbc.getWritableDatabase();
        dbx.delete("kategoriler", "kategori_id=?", new String[]{String.valueOf(kategoriID)});
        dbx.close();
    }
}
