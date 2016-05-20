package me.dev.superavesome.musicplayer;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import me.dev.superavesome.musicplayer.model.Song;
import timber.log.Timber;

/**
 * Created by Vardan sharma on 8/5/16.
 *
 * Temp class
 */
public class Finder {
  private Context context;
  private List<Song> mSongs = new ArrayList<>();

  public Finder(Context context) {
    this.context = context;
  }

  public List<Song> getAllSongs() {
    final Cursor cursor =
        context.getContentResolver().query(getUri(), null, getSelection(), null, getSortOrder());
    try {
      //If there is no path return an empty list
      if (cursor == null || !cursor.moveToFirst()) return new ArrayList<>();

      //If there is path then continue
      do {
        final Song song = buildSongFromCursor(cursor);
        if (song != null) {
          //obj.setPosInList(cursor.getPosition()).setContext(getContext()).lock();
          Timber.d(song.toString());
          mSongs.add(song);
        }
      } while (cursor.moveToNext() && !cursor.isClosed());
    } catch (Exception e) {
      Timber.e(e.getMessage());
    } finally {
      if (cursor != null && !cursor.isClosed()) cursor.close();
    }

    Song song = buildSongFromCursor(cursor);
    Timber.d(song.toString());
    return mSongs;
  }

  protected Uri getUri() {
    return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
  }

  protected String getSelection() {
    return MediaStore.Audio.Media.IS_MUSIC + "!=0";
  }

  protected String getSortOrder() {
    return MediaStore.Audio.Media.DEFAULT_SORT_ORDER;
  }

  @NonNull private Song buildSongFromCursor(Cursor cursor) {
    return new Song.Builder().album(
        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)))
        .albumId(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)))
        .artist(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)))
        .artistId(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID)))
        .duration(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)))
        .genre(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)))
        .build();
  }
}
