package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.data.DataSource;
import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

/**
 * Created by vardansharma on 26/11/16.
 */

public class GetAllSongsFromArtistUseCaseImpl implements GetAllSongsFromArtistUseCase {
    private final DataSource datasource;

    public GetAllSongsFromArtistUseCaseImpl(DataSource dataSource) {
        this.datasource =dataSource;
    }

    @Override
    public Observable<List<Song>> getAllSongsFromArtist(String artistId) {
        return datasource.getAllSongsFromArtist(artistId);
    }
}
