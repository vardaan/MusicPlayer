package me.dev.superavesome.musicplayer.ui.genreList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.model.Genre;

/**
 * Created by vardansharma on 25/11/16.
 */

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenreVH> {
    private final List<Genre> genres;
    private final Context context;

    GenresAdapter(List<Genre> genres, Context context) {
        this.genres = genres;
        this.context = context;
    }

    @Override
    public GenreVH onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater ll = LayoutInflater.from(parent.getContext());
        final View view = ll.inflate(R.layout.item_genre, parent, false);
        return new GenreVH(view);
    }

    @Override
    public void onBindViewHolder(final GenreVH vh, int position) {
        final Genre genre = genres.get(position);

        vh.genreName.setText(genre.getName());

    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    static class GenreVH extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_genre_name)
        TextView genreName;

        GenreVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
