package me.dev.superavesome.musicplayer.ui.genreList;


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
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.base.BaseFragment;
import me.dev.superavesome.musicplayer.model.Genre;

public class GenreListFragment extends BaseFragment implements GenreListContract.View {

    @BindView(R.id.rv_genres)
    RecyclerView rvGenres;

    @Inject
    GenreListPresenter presenter;

    public GenreListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerGenreListComponent.builder()
                .appComponent(getAppComponent())
                .genreListModule(new GenreListModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_genre_list, container, false);
        ButterKnife.bind(this, view);
        presenter.getAllGenres();

        rvGenres.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void showAllGenres(List<Genre> genres) {
        rvGenres.setAdapter(new GenresAdapter(genres, getActivity()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachFromUi();
    }
}
