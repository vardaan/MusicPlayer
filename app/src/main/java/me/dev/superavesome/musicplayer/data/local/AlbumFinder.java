package me.dev.superavesome.musicplayer.data.local;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import me.dev.superavesome.musicplayer.model.Album;

public class AlbumFinder extends Finder<Album> {

    public AlbumFinder(Context context) {
        super(context);
    }

    @Override
    protected Cursor getCursor() {
        return context.getContentResolver()
                .query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, null, null, null,
                        MediaStore.Audio.Albums.DEFAULT_SORT_ORDER);
    }


    @Override
    protected Album buildSongFromCursor(Cursor cursor) {
        return new Album.Builder().albumName(
                cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM)))
                .id(cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Albums._ID)))
                .artistName(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ARTIST)))
                .build();
    }
}