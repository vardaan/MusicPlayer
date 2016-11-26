package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.data.DataSource;
import me.dev.superavesome.musicplayer.model.Song;
import me.dev.superavesome.musicplayer.utils.Preconditions;
import rx.Observable;

/**
 * Created by vardansharma on 26/11/16.
 */
public class GetAllSongsFromAlbumUseCaseImpl implements GetAllSongsFromAlbumUseCase {
    private final DataSource dataSource;

    public GetAllSongsFromAlbumUseCaseImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Observable<List<Song>> getAllSongsFromAlbum(String albumId) {
        Preconditions.checkNotNull(albumId, "albumId is null");
        return dataSource.getAllSongsFromAlbum(albumId);
    }
}
