package me.dev.superavesome.musicplayer.ui.albumList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
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
import me.dev.superavesome.musicplayer.model.Album;

/**
 */
public class AlbumListFragment extends BaseFragment implements AlbumListContract.View {

    @Bind(R.id.rv_albums)
    RecyclerView rvAlbums;

    @Inject
    AlbumListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final AlbumListComponent component = DaggerAlbumListComponent.builder()
                .appComponent(getAppComponent())
                .albumListModule(new AlbumListModule(this))
                .build();
        component.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_albums, container, false);
        ButterKnife.bind(this, view);
        final FragmentActivity activity = getActivity();

        rvAlbums.setLayoutManager(new GridLayoutManager(activity, 2));

        presenter.getAlbums();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        presenter.detachFromUi();
    }

    @Override
    public void showAlbums(List<Album> albumList) {
        final FragmentActivity activity = getActivity();
        rvAlbums.setAdapter(new AlbumAdapter(albumList, activity));
    }
}
