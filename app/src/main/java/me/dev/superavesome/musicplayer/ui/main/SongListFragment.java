package me.dev.superavesome.musicplayer.ui.main;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.util.List;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.data.local.LocalDataSource;
import me.dev.superavesome.musicplayer.model.Song;

import static java.lang.Long.parseLong;

public class SongListFragment extends Fragment {

  @Bind(R.id.rv_songs) RecyclerView rvSongs;

  public SongListFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_song_list, container, false);
    ButterKnife.bind(this, view);

    rvSongs.setLayoutManager(new LinearLayoutManager(getActivity()));

    LocalDataSource dataSource = new LocalDataSource(getActivity());

    final List<Song> songs = dataSource.getAllSongs();
    final SongAdapter adapter = new SongAdapter(songs, getActivity());
    rvSongs.setAdapter(adapter);
    return view;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  class SongAdapter extends RecyclerView.Adapter<SongVH> {
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
      Picasso.with(context).load(albumArtUri).into(vh.imageView);
    }

    @Override public int getItemCount() {
      return songs.size();
    }
  }

  static class SongVH extends RecyclerView.ViewHolder {
    @Bind(R.id.img_song) ImageView imageView;
    @Bind(R.id.txt_title) TextView txtTitle;
    @Bind(R.id.txt_artist) TextView txtArtist;

    public SongVH(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
