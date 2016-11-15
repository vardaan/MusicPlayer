package me.dev.superavesome.musicplayer.data.local;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import me.dev.superavesome.musicplayer.model.Genre;

/**
 * Created by vardansharma on 15/11/16.
 */

public class GenreFinder extends Finder<Genre> {


    private final Context context;

    public GenreFinder(Context context) {
        super(context);
        this.context = context;
    }


    @Override
    protected Cursor getCursor() {
        return context.getContentResolver()
                .query(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI, null, null, null,
                        MediaStore.Audio.Genres.DEFAULT_SORT_ORDER);
    }

    @Override
    protected Genre buildSongFromCursor(Cursor cursor) {
        return new Genre.Builder()
                .name(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Genres.NAME)))
                .id(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Genres._ID)))
                .numOfTracks(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Genres._COUNT)))
                .build();
    }
}
