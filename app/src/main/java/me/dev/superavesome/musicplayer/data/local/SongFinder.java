package me.dev.superavesome.musicplayer.data.local;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import me.dev.superavesome.musicplayer.model.Song;

/**
 * Created by Vardan sharma on 20/5/16.
 */
public class SongFinder extends Finder<Song> {

    public SongFinder(Context context) {
        super(context);
    }

    @Override
    protected Cursor getCursor() {
        return context.getContentResolver()
                .query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null,
                        MediaStore.Audio.Media.IS_MUSIC + "!=0", null,
                        MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
    }

    public void getSongsByAllArtist() {

    }

    @Override
    public Song buildObjectFromCursor(Cursor cursor) {
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
