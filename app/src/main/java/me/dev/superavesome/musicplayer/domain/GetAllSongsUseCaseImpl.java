package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.data.DataSource;
import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

/**
 * Created by vardansharma on 15/11/16.
 */
public class GetAllSongsUseCaseImpl implements GetAllSongsUseCase {
    private DataSource dataSource;

    public GetAllSongsUseCaseImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Observable<List<Song>> getAllSongs() {
        return dataSource.getAllSongs();
    }
}
