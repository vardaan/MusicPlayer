package me.dev.superavesome.musicplayer.ui.songList;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.model.Song;

import static java.lang.Long.parseLong;

class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongVH> {
    private final List<Song> songs;
    final Uri ART_CONTENT_URI = Uri.parse("content://media/external/audio/albumart");
    private final Context context;

    public SongAdapter(List<Song> songs, Context context) {
      this.songs = songs;
      this.context = context;
    }

    @Override public SongVH onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater inflater = LayoutInflater.from(parent.getContext());
      View view = inflater.inflate(R.layout.item_song, parent, false);
      return new SongVH(view);
    }

    @Override public void onBindViewHolder(SongVH vh, int position) {
      vh.txtArtist.setText(songs.get(position).getArtist());
      vh.txtTitle.setText(songs.get(position).getTitle());
      Uri albumArtUri =
          ContentUris.withAppendedId(ART_CONTENT_URI, parseLong(songs.get(position).getAlbumId()));
      Picasso.with(context)
          .load(albumArtUri)
          .error(R.drawable.placeholder_with_padding)
          .into(vh.imageView);
    }

    @Override public int getItemCount() {
      return songs.size();
    }
    public static class SongVH extends RecyclerView.ViewHolder {
        @Bind(R.id.img_song)
        ImageView imageView;
        @Bind(R.id.txt_title)
        TextView txtTitle;
        @Bind(R.id.txt_artist) TextView txtArtist;

        public SongVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
  }