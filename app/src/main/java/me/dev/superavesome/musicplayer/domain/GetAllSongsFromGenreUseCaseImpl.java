package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.data.DataSource;
import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

/**
 * Created by vardansharma on 26/11/16.
 */
public class GetAllSongsFromGenreUseCaseImpl implements GetAllSongsFromGenreUseCase {

    private final DataSource dataSource;

    public GetAllSongsFromGenreUseCaseImpl(DataSource dataManager, String genreId) {
        this.dataSource = dataManager;
    }

    @Override
    public Observable<List<Song>> getAllSongsFromGenre(String genreId) {
        return dataSource.getAllSongsFromGenre(genreId);
    }
}
