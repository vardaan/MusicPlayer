package me.dev.superavesome.musicplayer.ui.albumList;

import java.util.List;

import me.dev.superavesome.musicplayer.base.BasePresenter;
import me.dev.superavesome.musicplayer.base.BaseView;
import me.dev.superavesome.musicplayer.model.Album;

/**
 * Created by vardansharma on 15/11/16.
 */

public class AlbumListContract {
    interface Presenter extends BasePresenter {
        void getAlbums();
    }

    interface View extends BaseView {
        void showAlbums(List<Album> albumList);
    }
}
