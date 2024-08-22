package per.example.filmlerapplication_ornek;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmlerAdapter extends RecyclerView.Adapter<FilmlerAdapter.filmCardTasarimTutucu> {
    private Context context;
    private List<Filmler> filmlerList;

    public FilmlerAdapter(Context context, List<Filmler> filmlerList) {
        this.context = context;
        this.filmlerList = filmlerList;
    }

    public class filmCardTasarimTutucu extends RecyclerView.ViewHolder{
        CardView cardView_Film;
        ImageView imgFilmResim;
        TextView txtFilmBaslik;

        public filmCardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            cardView_Film = itemView.findViewById(R.id.cardView_Film);
            imgFilmResim = itemView.findViewById(R.id.imgFilmResim);
            txtFilmBaslik = itemView.findViewById(R.id.txtFilmBaslik);
        }
    }

    @NonNull
    @Override
    public filmCardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.filmler_card, parent, false);
        return new filmCardTasarimTutucu(v);
    }

    @Override
    public void onBindViewHolder(@NonNull filmCardTasarimTutucu holder, int position) {
        final Filmler film = filmlerList.get(position);

        holder.txtFilmBaslik.setText(film.getFilm_Ad());

        holder.imgFilmResim.setImageResource(context.getResources().getIdentifier(film.getFilm_Resim(), "drawable", context.getPackageName()));

        holder.cardView_Film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, FilmDetayActivity.class);
                intent.putExtra("filmBilgi", film);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filmlerList.size();
    }
}
