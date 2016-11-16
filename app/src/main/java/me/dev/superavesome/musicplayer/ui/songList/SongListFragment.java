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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.base.BaseFragment;
import me.dev.superavesome.musicplayer.model.Song;

public class SongListFragment extends BaseFragment implements SongListContract.View {

    @BindView(R.id.rv_songs)
    RecyclerView rvSongs;

    @Inject
    SongListPresenter presenter;
    private Unbinder unbinder;

    public SongListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSongListComponent.builder()
                .songListModule(new SongListModule(this))
                .appComponent(getAppComponent())
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_song_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        rvSongs.setLayoutManager(new LinearLayoutManager(getActivity()));

        presenter.getSongList();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detachFromUi();
    }


    @Override
    public void showSongList(List<Song> songs) {
        final SongListAdapter adapter = new SongListAdapter(songs, getActivity());
        rvSongs.setAdapter(adapter);
    }
}
