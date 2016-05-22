package me.dev.superavesome.musicplayer;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.List;
import me.dev.superavesome.musicplayer.model.Album;
import timber.log.Timber;

public class AlbumFinder {
  //todo make it efficient by using projection
  private final Context context;
  private List<Album> albumList;

  public AlbumFinder(Context context) {
    this.context = context;
  }

  public List<Album> getAlbums() {
    final Cursor cursor = context.getContentResolver()
        .query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, null, null, null,
            MediaStore.Audio.Albums.DEFAULT_SORT_ORDER);
    try {
      //If there is no path return an empty list
      if (cursor == null || !cursor.moveToFirst()) {
        return new ArrayList<>(0);//todo may be collection.empty
      }

      albumList = new ArrayList<>(cursor.getCount());
      //If there is path then continue
      do {
        final Album album = buildSongFromCursor(cursor);
        //obj.setPosInList(cursor.getPosition()).setContext(getContext()).lock(); //todo do why this
        Timber.d(album.toString());
        albumList.add(album);
      } while (cursor.moveToNext() && !cursor.isClosed());
    } catch (Exception e) {
      Timber.e(e.getMessage());
    } finally {
      if (cursor != null && !cursor.isClosed()) cursor.close();
    }
    return albumList;
  }

  private Album buildSongFromCursor(Cursor cursor) {
    return new Album.Builder().albumName(
        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM)))
        .id(cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Albums._ID)))
        .artistName(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST)))
        .build();
  }
}