package me.dev.superavesome.musicplayer.ui.artistList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.data.local.ArtistFinder;

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
}
