package me.dev.superavesome.musicplayer.ui.categorySongList;

import java.util.List;

import me.dev.superavesome.musicplayer.base.BasePresenter;
import me.dev.superavesome.musicplayer.base.BaseView;
import me.dev.superavesome.musicplayer.constants.Category;
import me.dev.superavesome.musicplayer.model.Song;

/**
 * Created by vardansharma on 26/11/16.
 */

public class CategorySongListContract {
    public interface View extends BaseView {
        void showData(List<Song> songs);
    }

    public interface Presenter extends BasePresenter {
        void getData(String categoryId, @Category int categoryType);
    }
}
