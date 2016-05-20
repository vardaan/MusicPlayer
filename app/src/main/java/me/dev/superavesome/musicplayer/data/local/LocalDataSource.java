package me.dev.superavesome.musicplayer.data.local;

import android.content.Context;
import android.provider.MediaStore;
import java.util.List;
import me.dev.superavesome.musicplayer.data.DataSource;
import me.dev.superavesome.musicplayer.data.SongFinder;
import me.dev.superavesome.musicplayer.model.Song;

/**
 * Created by Vardan sharma on 20/5/16.
 */
public final class LocalDataSource implements DataSource {

  final SongFinder songFinder;

  public LocalDataSource(Context context) {
    this.songFinder = new SongFinder(context);
  }

  //todo make an abstraction use rxjava
  @Override public List<Song> getAllSongs() {
    return songFinder.getData();
  }

  @Override public List<MediaStore.Audio.Artists> getAllArtist() {
    return null;
  }

  @Override public List<MediaStore.Audio.Genres> getAllGenres() {
    return null;
  }
}
