package me.dev.superavesome.musicplayer.ui.songList;

import java.util.List;

import me.dev.superavesome.musicplayer.base.BasePresenter;
import me.dev.superavesome.musicplayer.base.BaseView;
import me.dev.superavesome.musicplayer.model.Song;

/**
 * Created by vardansharma on 15/11/16.
 */

public class SongListContract {
    interface View extends BaseView {
        void showSongList(List<Song> songs);
    }

    interface Presenter<V> extends BasePresenter<V> {
        void getSongList();
    }
}
