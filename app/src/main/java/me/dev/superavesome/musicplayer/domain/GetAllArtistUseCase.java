package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.model.Artist;
import rx.Observable;

/**
 * Created by vardansharma on 15/11/16.
 */

public interface GetAllArtistUseCase {
    Observable<List<Artist>> getAllArtistUseCase();
}
