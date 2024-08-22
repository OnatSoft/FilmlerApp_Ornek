package per.example.filmlerapplication_ornek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView kategoriRv;
    ArrayList<Kategoriler> kategorilerArrayList = new ArrayList<>();
    KategoriAdapter adapter;
    DBConnection dbc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kategoriRv = findViewById(R.id.kategoriRv);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);
        veritabaniKopyala();
        dbc = new DBConnection(this);


        kategoriRv.setHasFixedSize(true);
        kategoriRv.setLayoutManager(new LinearLayoutManager(this));

        kategorilerArrayList = new KategoriDao().tumKategoriler(dbc);
        kategoriRv.setAdapter(new KategoriAdapter(this, kategorilerArrayList));
    }


    public void veritabaniKopyala(){

        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        helper.openDataBase();
    }
}