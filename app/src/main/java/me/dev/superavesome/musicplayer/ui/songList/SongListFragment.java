package me.dev.superavesome.musicplayer.ui.songList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.base.BaseFragment;
import me.dev.superavesome.musicplayer.model.Song;

public class SongListFragment extends BaseFragment implements SongListContract.View {

    @Bind(R.id.rv_songs)
    RecyclerView rvSongs;

    @Inject
    SongListPresenter presenter;

    public SongListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSongListComponent.builder()
                .appComponent(getAppComponent())
                .songListModule(new SongListModule(this))
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_song_list, container, false);
        ButterKnife.bind(this, view);

        rvSongs.setLayoutManager(new LinearLayoutManager(getActivity()));


        presenter.getSongList();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        presenter.detachFromUi();
    }


    @Override
    public void showSongList(List<Song> songs) {
        final SongAdapter adapter = new SongAdapter(songs, getActivity());
        rvSongs.setAdapter(adapter);
    }
}
