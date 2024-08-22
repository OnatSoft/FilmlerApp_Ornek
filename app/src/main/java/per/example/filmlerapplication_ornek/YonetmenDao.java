package per.example.filmlerapplication_ornek;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class YonetmenDao {

    public ArrayList<Yonetmenler> tumYonetmenler(DBConnection dbc){

        ArrayList<Yonetmenler> yonetmenlerArrayList = new ArrayList<>();
        SQLiteDatabase db = dbc.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM yonetmenler", null);

        while (c.moveToNext()){
            Yonetmenler y = new Yonetmenler(
                    c.getInt(c.getColumnIndexOrThrow("yonetmen_id"))
                    ,c.getString(c.getColumnIndexOrThrow("yonetmen_Ad")));
            yonetmenlerArrayList.add(y);
        }

        return yonetmenlerArrayList;
    }
}
