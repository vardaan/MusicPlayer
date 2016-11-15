package me.dev.superavesome.musicplayer.ui.artistList;

import java.util.List;

import me.dev.superavesome.musicplayer.base.BasePresenter;
import me.dev.superavesome.musicplayer.base.BaseView;
import me.dev.superavesome.musicplayer.model.Artist;

/**
 * Created by vardansharma on 15/11/16.
 */

public class ArtistListContract {
    interface View extends BaseView {
        void showData(List<Artist> artists);
    }

    interface Presenter extends BasePresenter {
        void getArtistList();
    }
}
