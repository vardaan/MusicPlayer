package me.dev.superavesome.musicplayer.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;

/**
 */
public class ArtistFragment extends Fragment {

  @Bind(R.id.rv_artist) RecyclerView rvArtist;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_artist, container, false);
    ButterKnife.bind(this, view);

    return view;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }
}
