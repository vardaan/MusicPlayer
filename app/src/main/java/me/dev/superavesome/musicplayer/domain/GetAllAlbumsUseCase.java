package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.model.Album;
import rx.Observable;

/**
 * Created by vardansharma on 15/11/16.
 */

public interface GetAllAlbumsUseCase {

    Observable<List<Album>> getAlbumList();
}
