package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.data.DataManager;
import me.dev.superavesome.musicplayer.model.Genre;
import rx.Observable;

/**
 * Created by vardansharma on 18/11/16.
 */
public class GetAllGenreUseCaseImpl implements GetAllGenreUseCase {
    private DataManager dataManager;

    public GetAllGenreUseCaseImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public Observable<List<Genre>> getAllGenre() {
        return dataManager.getAllGenres();
    }
}
