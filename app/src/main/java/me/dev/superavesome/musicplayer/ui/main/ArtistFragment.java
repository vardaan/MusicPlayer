package me.dev.superavesome.musicplayer.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.ArrayList;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.data.local.ArtistFinder;
import me.dev.superavesome.musicplayer.model.Artist;

public class ArtistFragment extends Fragment {
  @Bind(R.id.rv_artists) RecyclerView rvArtists;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_artists, container, false);
    ButterKnife.bind(this, view);
    final FragmentActivity activity = getActivity();
    //    //todo do this in background
    ArtistFinder artistFinder = new ArtistFinder(activity);
    rvArtists.setLayoutManager(new LinearLayoutManager(activity));
    rvArtists.setAdapter(new ArtistAdapter(artistFinder.getData(), activity));
    //
    return view;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  class ArtistAdapter extends RecyclerView.Adapter<ArtistVH> {
    private final ArrayList<Artist> artists;
    private final Context context;

    ArtistAdapter(ArrayList<Artist> artists, Context context) {
      this.artists = artists;
      this.context = context;
    }

    @Override public ArtistVH onCreateViewHolder(ViewGroup parent, int viewType) {
      final LayoutInflater ll = LayoutInflater.from(parent.getContext());
      final View view = ll.inflate(R.layout.item_artist, parent, false);
      return new ArtistVH(view);
    }

    @Override public void onBindViewHolder(final ArtistVH vh, int position) {
      final Artist artist = artists.get(position);

      vh.txtArtistName.setText(artist.getName());
      String artistInfo = String.valueOf(artist.getNumAlbums()) +
          ((artist.getNumAlbums() > 1) ? " Albums  " : " Album  ") +
          artist.getNumTracks() +
          (artist.getNumTracks() > 1 ? " Tracks" : " Track");
      vh.txtArtistInfo.setText(artistInfo);
    }

    @Override public int getItemCount() {
      return artists.size();
    }
  }

  static class ArtistVH extends RecyclerView.ViewHolder {

    @Bind(R.id.txt_artist_name) TextView txtArtistName;
    @Bind(R.id.txt_artist_info) TextView txtArtistInfo;

    public ArtistVH(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
