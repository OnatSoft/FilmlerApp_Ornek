package per.example.filmlerapplication_ornek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmDetayActivity extends AppCompatActivity {
    ImageView imgFilmResim;
    TextView txtFilmAd, txtFilmYonetmen, txtFilmYil, txtFilmAciklama;
    Filmler film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detay);

        imgFilmResim = findViewById(R.id.imgDetayResim);
        txtFilmAd = findViewById(R.id.txtFilmAd);
        txtFilmYil = findViewById(R.id.txtFilmYil);
        txtFilmYonetmen = findViewById(R.id.txtFilmYonetmen);
        txtFilmAciklama = findViewById(R.id.txtFilmAciklama);


        film = (Filmler) getIntent().getSerializableExtra("filmBilgi");

        txtFilmAd.setText(film.getFilm_Ad());
        txtFilmYonetmen.setText("Yönetmen: " + film.getYonetmen_id().getYonetmen_Ad());
        txtFilmYil.setText(String.valueOf(film.getFilm_Yil()));
        imgFilmResim.setImageResource(getResources().getIdentifier(film.getFilm_Resim(), "drawable", getPackageName()));

        if (TextUtils.isEmpty(txtFilmAciklama.toString())) {
            txtFilmAciklama.setText("Film Özeti Bulunamadı!");
        } else {
            txtFilmAciklama.setText(film.getFilm_Aciklama());
        }
    }
}