package me.dev.superavesome.musicplayer.data.local;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import java.util.ArrayList;
import me.dev.superavesome.musicplayer.model.Artist;
import timber.log.Timber;

/**
 * Created by Vardan sharma on 22/5/16.
 */
public class ArtistFinder {

  //todo make it efficient by using projection
  private final Context context;
  private ArrayList<Artist> mSongs;

  public ArtistFinder(Context context) {
    this.context = context;
  }

  public ArrayList<Artist> getData() {
    ContentResolver contentResolver = context.getContentResolver();
    String[] projection = {
        MediaStore.Audio.Artists._ID, MediaStore.Audio.Artists.ARTIST,
        MediaStore.Audio.Artists.NUMBER_OF_ALBUMS, MediaStore.Audio.Artists.NUMBER_OF_TRACKS
    };

    final Cursor cursor =
        contentResolver.query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, projection, null, null,
            MediaStore.Audio.Artists.ARTIST + " ASC");

    //final Cursor cursor = context.getContentResolver()
    //    .query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
    //        MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
    try {
      //If there is no path return an empty list
      if (cursor == null || !cursor.moveToFirst()) {
        return new ArrayList<>(0);//todo may be collection.empty
      }

      mSongs = new ArrayList<>(cursor.getCount());
      //If there is path then continue
      do {
        final Artist artist = buildSongFromCursor(cursor);
        //obj.setPosInList(cursor.getPosition()).setContext(getContext()).lock(); //todo do why this
        Timber.d(artist.toString());
        mSongs.add(artist);
      } while (cursor.moveToNext() && !cursor.isClosed());
    } catch (Exception e) {
      Timber.e(e.getMessage());
    } finally {
      if (cursor != null && !cursor.isClosed()) cursor.close();
    }
    return mSongs;
  }

  private Artist buildSongFromCursor(Cursor cursor) {
    return new Artist.Builder().name(
        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST)))
        .numAlbums(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_ALBUMS)))
        .id(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists._ID)))
        .numTracks(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_TRACKS)))
        .build();
  }
}
