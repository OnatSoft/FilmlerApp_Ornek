package per.example.filmlerapplication_ornek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class FilmlerActivity extends AppCompatActivity {
    Toolbar toolbar2;
    RecyclerView filmlerRv;
    ArrayList<Filmler> filmlerArrayList = new ArrayList<>();
    FilmlerAdapter adapter;
    Kategoriler kategori;
    DBConnection dbc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);

        toolbar2 = findViewById(R.id.toolbar2);
        filmlerRv = findViewById(R.id.filmlerRv);
        dbc = new DBConnection(this);


        kategori = (Kategoriler) getIntent().getSerializableExtra("kategoriNesne");

        toolbar2.setTitle(kategori.getKategori_Ad() + " Türü Filmler");
        setSupportActionBar(toolbar2);

        filmlerArrayList = new FilmlerDao().tumFilmlerByKategoriID(dbc, kategori.getKategori_id());
        filmlerRv.setAdapter(new FilmlerAdapter(this, filmlerArrayList));

        filmlerRv.setHasFixedSize(true);
        filmlerRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }
}