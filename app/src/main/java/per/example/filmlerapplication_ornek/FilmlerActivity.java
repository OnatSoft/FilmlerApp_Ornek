package per.example.filmlerapplication_ornek;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class FilmlerActivity extends AppCompatActivity {
    Toolbar toolbar2;
    RecyclerView filmlerRv;
    ArrayList<Filmler> filmlerArrayList = new ArrayList<>();
    FilmlerAdapter adapter;
    Kategoriler kategori;
    DBConnection dbc;
    TextInputEditText editKategoriAd2;
    TextInputLayout txtLytKategoriAd;
    Button btnGuncelle, btnSil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);

        toolbar2 = findViewById(R.id.toolbar2);
        filmlerRv = findViewById(R.id.filmlerRv);
        btnGuncelle = findViewById(R.id.btnGuncelle);
        btnSil = findViewById(R.id.btnSil);
        editKategoriAd2 = findViewById(R.id.editKategoriAd2);
        txtLytKategoriAd = findViewById(R.id.txtLytKategoriAd);
        dbc = new DBConnection(this);


        kategori = (Kategoriler) getIntent().getSerializableExtra("kategoriNesne");

        toolbar2.setTitle(kategori.getKategori_Ad() + " Filmleri");
        setSupportActionBar(toolbar2);

        filmlerArrayList = new FilmlerDao().tumFilmlerByKategoriID(dbc, kategori.getKategori_id());
        filmlerRv.setAdapter(new FilmlerAdapter(this, filmlerArrayList));
        filmlerRv.setHasFixedSize(true);
        filmlerRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        editKategoriAd2.setText(kategori.getKategori_Ad());

        btnGuncelle.setOnClickListener(view -> {

            String kategoriAd = editKategoriAd2.getText().toString().trim();
            if (TextUtils.isEmpty(kategoriAd)) {

                txtLytKategoriAd.setError("Lütfen bu alanı doldurun.");
            } else {

                new KategoriDao().kategoriGuncelle(dbc, kategoriAd, kategori.getKategori_id());
                startActivity(new Intent(FilmlerActivity.this, MainActivity.class));
                finish();
            }
        });

        btnSil.setOnClickListener(view -> {

            String kategoriAd = editKategoriAd2.getText().toString().trim();

            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setIcon(R.drawable.roundicon_warning_24);
            ad.setTitle("Kategori Sil");
            ad.setMessage("Seçtiğiniz " + kategori.getKategori_Ad() + " kategorisini silmek istiyor musunuz?\nBu işlem geri alınamaz!");

            ad.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    new KategoriDao().kategoriSil(dbc, kategori.getKategori_id());
                    startActivity(new Intent(FilmlerActivity.this, MainActivity.class));
                    finish();
                }
            });

            ad.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(FilmlerActivity.this, "İptal edildi. :)", Toast.LENGTH_SHORT).show();
                }
            }).show();
        });

    }
}