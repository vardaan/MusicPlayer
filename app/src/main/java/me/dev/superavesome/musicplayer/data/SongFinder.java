package me.dev.superavesome.musicplayer.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.List;
import me.dev.superavesome.musicplayer.model.Song;
import timber.log.Timber;

/**
 * Created by Vardan sharma on 20/5/16.
 */
public class SongFinder {

  //todo make it efficient by using projection
  private final Context context;
  private ArrayList<Song> mSongs;

  public SongFinder(Context context) {
    this.context = context;
  }

  public List<Song> getData() {
    final Cursor cursor = context.getContentResolver()
        .query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null,
            MediaStore.Audio.Media.IS_MUSIC + "!=0", null,
            MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
    try {
      //If there is no path return an empty list
      if (cursor == null || !cursor.moveToFirst()) {
        return new ArrayList<>(0);//todo may be collection.empty
      }

      mSongs = new ArrayList<>(cursor.getCount());
      //If there is path then continue
      do {
        final Song song = buildSongFromCursor(cursor);
        //obj.setPosInList(cursor.getPosition()).setContext(getContext()).lock(); //todo do why this
        Timber.d(song.toString());
        mSongs.add(song);
      } while (cursor.moveToNext() && !cursor.isClosed());
    } catch (Exception e) {
      Timber.e(e.getMessage());
    } finally {
      if (cursor != null && !cursor.isClosed()) cursor.close();
    }
    return mSongs;
  }

  private Song buildSongFromCursor(Cursor cursor) {
    return new Song.Builder().album(
        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)))
        .albumId(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)))
        .artist(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)))
        .artistId(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID)))
        .duration(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)))
        .genre(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)))
        .path(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)))
        .title(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)))
        .build();
  }
}
