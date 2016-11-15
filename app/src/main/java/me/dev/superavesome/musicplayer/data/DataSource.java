package me.dev.superavesome.musicplayer.data;

import android.provider.MediaStore;

import java.util.List;

import me.dev.superavesome.musicplayer.model.Album;
import me.dev.superavesome.musicplayer.model.Artist;
import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

//todo add doc
public interface DataSource {
    Observable<List<Song>> getAllSongs();

    Observable<List<Album>> getAllAlbums();

    Observable<List<Artist>> getAllArtist();

    Observable<List<MediaStore.Audio.Genres>> getAllGenres();

}
