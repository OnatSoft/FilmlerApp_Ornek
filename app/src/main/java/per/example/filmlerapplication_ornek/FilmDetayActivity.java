package per.example.filmlerapplication_ornek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmDetayActivity extends AppCompatActivity {
    ImageView imgFilmResim;
    TextView txtFilmAd, txtFilmYonetmen, txtFilmYil;
    Filmler film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detay);

        imgFilmResim = findViewById(R.id.imgDetayResim);
        txtFilmAd = findViewById(R.id.txtFilmAd);
        txtFilmYil = findViewById(R.id.txtFilmYil);
        txtFilmYonetmen = findViewById(R.id.txtFilmYonetmen);


        film = (Filmler) getIntent().getSerializableExtra("filmBilgi");

        txtFilmAd.setText(film.getFilm_Ad());
        txtFilmYonetmen.setText(film.getYonetmen_id().getYonetmen_Ad());
        txtFilmYil.setText(String.valueOf(film.getFilm_Yil()));
        imgFilmResim.setImageResource(getResources().getIdentifier(film.getFilm_Resim(), "drawable", getPackageName()));
    }
}