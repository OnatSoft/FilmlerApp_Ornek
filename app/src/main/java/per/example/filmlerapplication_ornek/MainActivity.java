package per.example.filmlerapplication_ornek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView kategoriRv;
    ArrayList<Kategoriler> kategorilerArrayList = new ArrayList<>();
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
        kategoriRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));

        kategorilerArrayList = new KategoriDao().tumKategoriler(dbc);
        kategoriRv.setAdapter(new KategoriAdapter(this, kategorilerArrayList));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_kategoriEkle) {
            View v = LayoutInflater.from(this).inflate(R.layout.alert_view_design, null);

            TextInputLayout inputLytKategoriAd = v.findViewById(R.id.inputLytKategoriAd);
            TextInputEditText editTxtKategoriAd = v.findViewById(R.id.editTxtKategoriAd);

            AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("Yeni Kategori Ekle");
            ad.setView(v);

            ad.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    String kategoriad = editTxtKategoriAd.getText().toString().trim();

                    if (TextUtils.isEmpty(kategoriad)) {

                        Toast.makeText(MainActivity.this, "Lütfen bu alanı doldurun.", Toast.LENGTH_LONG).show();
                    } else {

                        new KategoriDao().kategoriEkle(dbc, kategoriad);
                        Toast.makeText(getApplicationContext(), "Kategori başarıyla kaydedildi.", Toast.LENGTH_LONG).show();
                    }
                }
            });

            ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            }).show();

        } else if (item.getItemId() == R.id.action_filmEkle) {

            Snackbar.make(toolbar, "Film ekleme işlemi şu an yapılamıyor.", Snackbar.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void veritabaniKopyala() {

        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        helper.openDataBase();
    }
}