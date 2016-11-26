package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

/**
 * Created by vardansharma on 26/11/16.
 */
public interface GetAllSongsFromGenreUseCase {
    Observable<List<Song>> getAllSongsFromGenre(String genreId);
}
