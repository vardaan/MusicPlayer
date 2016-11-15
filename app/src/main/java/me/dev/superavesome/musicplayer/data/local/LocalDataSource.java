package me.dev.superavesome.musicplayer.data.local;

import android.content.Context;
import android.provider.MediaStore;

import java.util.List;

import javax.inject.Inject;

import me.dev.superavesome.musicplayer.data.DataSource;
import me.dev.superavesome.musicplayer.model.Album;
import me.dev.superavesome.musicplayer.model.Artist;
import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

/**
 * Created by Vardan sharma on 20/5/16.
 */
public final class LocalDataSource implements DataSource {

    final SongFinder songFinder;
    final AlbumFinder albumFinder;
    final ArtistFinder artistFinder;

    @Inject
    public LocalDataSource(Context context, AlbumFinder albumFinder,
                           ArtistFinder artistFinder) {
        this.songFinder = new SongFinder(context);
        this.albumFinder = albumFinder;
        this.artistFinder = artistFinder;
    }

    //todo make an abstraction use rxjava
    @Override
    public Observable<List<Song>> getAllSongs() {
        return Observable.just(songFinder.getData());
    }

    @Override
    public Observable<List<Album>> getAllAlbums() {
        return Observable.just(albumFinder.getData());
    }

    @Override
    public Observable<List<Artist>> getAllArtist() {
        return Observable.just(artistFinder.getData());
    }

    @Override
    public Observable<List<MediaStore.Audio.Genres>> getAllGenres() {
        throw new IllegalStateException("NOT YET IMPLEMENTED");
    }
}
