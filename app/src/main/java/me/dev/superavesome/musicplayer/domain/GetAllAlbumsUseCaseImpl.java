package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.data.DataSource;
import me.dev.superavesome.musicplayer.model.Album;
import rx.Observable;

/**
 * Created by vardansharma on 15/11/16.
 */

public class GetAllAlbumsUseCaseImpl implements GetAllAlbumsUseCase {
    private DataSource dataSource;

    public GetAllAlbumsUseCaseImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Observable<List<Album>> getAlbumList() {
        return dataSource.getAllAlbums();
    }
}
