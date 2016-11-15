package me.dev.superavesome.musicplayer.ui.songList;

import android.content.Context;
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

class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongVH> {
    private final List<Song> songs;
    private final Context context;

    public SongListAdapter(List<Song> songs, Context context) {
      this.songs = songs;
      this.context = context;
    }

    @Override public SongVH onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater inflater = LayoutInflater.from(parent.getContext());
      View view = inflater.inflate(R.layout.item_song, parent, false);
      return new SongVH(view);
    }

    @Override public void onBindViewHolder(SongVH vh, int position) {
        final Song song = songs.get(position);
        vh.txtArtist.setText(song.getArtist());
      vh.txtTitle.setText(song.getTitle());
      Picasso.with(context)
          .load(song.getImageUri())
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