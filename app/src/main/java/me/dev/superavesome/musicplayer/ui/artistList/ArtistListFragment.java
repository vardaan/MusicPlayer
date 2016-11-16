package me.dev.superavesome.musicplayer.ui.artistList;

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
import me.dev.superavesome.musicplayer.model.Artist;

public class ArtistListFragment extends BaseFragment implements ArtistListContract.View {
    @BindView(R.id.rv_artists)
    RecyclerView rvArtists;

    @Inject
    ArtistListPresenter presenter;
    private Unbinder unbinder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerArtistListComponent.builder()
                .appComponent(getAppComponent())
                .artistModule(new ArtistModule(this))
                .build().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artists, container, false);
        unbinder = ButterKnife.bind(this, view);
        rvArtists.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.getArtistList();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detachFromUi();
    }

    @Override
    public void showData(List<Artist> artists) {
        rvArtists.setAdapter(new ArtistListAdapter(artists, getActivity()));
    }
}
