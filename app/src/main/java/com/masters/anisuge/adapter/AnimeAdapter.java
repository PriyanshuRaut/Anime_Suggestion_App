package com.masters.anisuge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.masters.anisuge.R;
import com.masters.anisuge.model.AnimeModel.AnimeData;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder> {

    private final Context context;
    private final List<AnimeData> animeModelList;

    public AnimeAdapter(Context context, List<AnimeData> animeModelList) {
        this.context = context;
        this.animeModelList = animeModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_anime, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AnimeData anime = animeModelList.get(position);

        // Set Anime Thumbnail
        Glide.with(context)
                .load(anime.images.imageUrl)
                .into(holder.animeThumbnail);

        // Set Anime Title
        holder.animeTitle.setText(anime.title);

        // Set Anime English Title
        if (anime.titleEnglish != null && !anime.titleEnglish.isEmpty()) {
            holder.animeEnglishTitle.setText(anime.titleEnglish);
        } else {
            holder.animeEnglishTitle.setText("N/A");
        }

        // Set Anime Score
        holder.animeScore.setText("Score: " + (anime.score > 0 ? anime.score : "N/A"));

        // Set Anime Episodes
        holder.animeEpisodes.setText("Episodes: " + (anime.episodes > 0 ? anime.episodes : "N/A"));

        // Set Anime Type
        holder.animeType.setText("Type: " + (anime.type != null ? anime.type : "N/A"));
    }

    @Override
    public int getItemCount() {
        return animeModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView animeThumbnail;
        TextView animeTitle, animeEnglishTitle, animeScore, animeEpisodes, animeType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            animeThumbnail = itemView.findViewById(R.id.animeThumbnail);
            animeTitle = itemView.findViewById(R.id.animeTitle);
            animeEnglishTitle = itemView.findViewById(R.id.animeEnglishTitle);
            animeScore = itemView.findViewById(R.id.animeScore);
            animeEpisodes = itemView.findViewById(R.id.animeEpisodes);
            animeType = itemView.findViewById(R.id.animeType);
        }
    }
}
