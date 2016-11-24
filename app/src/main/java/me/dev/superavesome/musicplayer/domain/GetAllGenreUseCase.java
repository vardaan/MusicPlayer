package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.model.Genre;
import rx.Observable;

/**
 * Created by vardansharma on 18/11/16.
 */

public interface GetAllGenreUseCase {
    Observable<List<Genre>> getAllGenre();
}
