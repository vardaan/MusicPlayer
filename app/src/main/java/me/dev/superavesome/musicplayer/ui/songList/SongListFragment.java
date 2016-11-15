package me.dev.superavesome.musicplayer.ui.songList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.model.Song;

public class SongListFragment extends Fragment implements SongListContract.View {

    @Bind(R.id.rv_songs)
    RecyclerView rvSongs;

    public SongListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_song_list, container, false);
        ButterKnife.bind(this, view);

        rvSongs.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void showSongList(List<Song> songs) {
        final SongAdapter adapter = new SongAdapter(songs, getActivity());
        rvSongs.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        //todo
    }

    @Override
    public void hideLoading() {
        //todo
    }

    @Override
    public void showEmptyScreen() {
        //todo
    }

    @Override
    public void hideEmptyScreen() {
        //todo
    }

    @Override
    public void showErrorScreen() {
        //todo
    }
}
