package me.dev.superavesome.musicplayer.ui.genreList;

import java.util.List;

import me.dev.superavesome.musicplayer.base.BasePresenter;
import me.dev.superavesome.musicplayer.base.BaseView;
import me.dev.superavesome.musicplayer.model.Genre;

/**
 * Created by vardansharma on 18/11/16.
 */

public class GenreListContract {
    interface View extends BaseView {
        void showAllGenres(List<Genre> genres);
    }

    interface Presenter extends BasePresenter {
        void getAllGenres();
    }
}
