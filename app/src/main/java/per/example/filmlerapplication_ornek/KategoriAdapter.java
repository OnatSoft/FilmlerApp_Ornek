package per.example.filmlerapplication_ornek;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu> {
    private Context context;
    private List<Kategoriler> kategorilerList;

    public KategoriAdapter(Context context, List<Kategoriler> kategorilerList) {
        this.context = context;
        this.kategorilerList = kategorilerList;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView cardView_Kategori;
        private TextView txtKategoriAd;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            cardView_Kategori = itemView.findViewById(R.id.cardView_Kategori);
            txtKategoriAd = itemView.findViewById(R.id.txtKategoriAd);
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_card, parent, false);
        return new CardTasarimTutucu(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {

        Kategoriler kategori = kategorilerList.get(position);
        holder.txtKategoriAd.setText(kategori.getKategori_Ad());

        holder.cardView_Kategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, FilmlerActivity.class);
                intent.putExtra("kategoriNesne", kategori);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategorilerList.size();
    }
}
