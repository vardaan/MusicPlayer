package me.dev.superavesome.musicplayer.data.local;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

abstract class Finder<T> {

  //todo make it efficient by using projection
  protected final Context context;
  private ArrayList<T> list;

  public Finder(Context context) {
    this.context = context;
  }

  public List<T> getData() {
    final Cursor cursor = getCursor();
    try {
      //If there is no path return an empty list
      if (cursor == null || !cursor.moveToFirst()) {
        return new ArrayList<>(0);//todo may be collection.empty
      }

      list = new ArrayList<>(cursor.getCount());
      //If there is path then continue
      do {
        final T data = buildObjectFromCursor(cursor);
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

  protected abstract Cursor getCursor();

  protected abstract T buildObjectFromCursor(Cursor cursor);
}
