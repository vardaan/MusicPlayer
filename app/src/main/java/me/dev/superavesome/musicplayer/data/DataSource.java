package me.dev.superavesome.musicplayer.data;

import android.provider.MediaStore;
import java.util.List;
import me.dev.superavesome.musicplayer.model.Song;

//todo add doc
public interface DataSource {
  List<Song> getAllSongs();

  List<MediaStore.Audio.Artists> getAllArtist();

  List<MediaStore.Audio.Genres> getAllGenres();
}
