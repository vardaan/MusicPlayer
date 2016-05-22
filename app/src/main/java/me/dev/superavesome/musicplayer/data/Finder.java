package me.dev.superavesome.musicplayer.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import java.util.ArrayList;
import timber.log.Timber;

abstract class Finder<T> {

  //todo make it efficient by using projection
  private final Context context;
  private ArrayList<T> list;

  public Finder(Context context) {
    this.context = context;
  }

  public ArrayList<T> getData() {
    final Cursor cursor = context.getContentResolver()
        .query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null,
            MediaStore.Audio.Media.IS_MUSIC + "!=0", null,
            MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
    try {
      //If there is no path return an empty list
      if (cursor == null || !cursor.moveToFirst()) {
        return new ArrayList<>(0);//todo may be collection.empty
      }

      list = new ArrayList<>(cursor.getCount());
      //If there is path then continue
      do {
        final T data = buildSongFromCursor(cursor);
        //obj.setPosInList(cursor.getPosition()).setContext(getContext()).lock(); //todo do why this
        Timber.d(data.toString());
        list.add(data);
      } while (cursor.moveToNext() && !cursor.isClosed());
    } catch (Exception e) {
      Timber.e(e.getMessage());
    } finally {
      if (cursor != null && !cursor.isClosed()) cursor.close();
    }
    return list;
  }

  protected abstract T buildSongFromCursor(Cursor cursor);
}
