package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.data.DataSource;
import me.dev.superavesome.musicplayer.model.Artist;
import rx.Observable;

/**
 * Created by vardansharma on 15/11/16.
 */

public class GetAllArtistUseCaseImpl implements GetAllArtistUseCase {
    private DataSource dataSource;

    public GetAllArtistUseCaseImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Observable<List<Artist>> getAllArtistUseCase() {
        return dataSource.getAllArtist();
    }
}
