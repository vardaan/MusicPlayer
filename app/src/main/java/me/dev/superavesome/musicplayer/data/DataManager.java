package me.dev.superavesome.musicplayer.data;

import java.util.List;

import me.dev.superavesome.musicplayer.data.local.LocalDataSource;
import me.dev.superavesome.musicplayer.data.remote.RemoteDataSource;
import me.dev.superavesome.musicplayer.model.Album;
import me.dev.superavesome.musicplayer.model.Artist;
import me.dev.superavesome.musicplayer.model.Genre;
import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

/**
 * Created by vardansharma on 15/11/16.
 */

public class DataManager implements DataSource {
    private final LocalDataSource localDataSource;
    private final RemoteDataSource remoteDataSource;

    public DataManager(LocalDataSource localDataSource,
                       RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Song>> getAllSongs() {
        return localDataSource.getAllSongs();
    }

    @Override
    public Observable<List<Album>> getAllAlbums() {
        return localDataSource.getAllAlbums();
    }

    @Override
    public Observable<List<Artist>> getAllArtist() {
        return localDataSource.getAllArtist();
    }

    @Override
    public Observable<List<Genre>> getAllGenres() {
        return localDataSource.getAllGenres();
    }

    @Override
    public Observable<List<Song>> getAllSongsFromGenre(String genreId) {
        return localDataSource.getAllSongsFromGenre(genreId);
    }

    @Override
    public Observable<List<Song>> getAllSongsFromArtist( String artistId) {
        return localDataSource.getAllSongsFromGenre(artistId);
    }

    @Override
    public Observable<List<Song>> getAllSongsFromAlbum(String albumId) {
        return localDataSource.getAllSongsFromAlbum(albumId);
    }
}
