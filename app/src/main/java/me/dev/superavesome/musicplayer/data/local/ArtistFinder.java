package me.dev.superavesome.musicplayer.data.local;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import me.dev.superavesome.musicplayer.model.Artist;

/**
 * Created by Vardan sharma on 22/5/16.
 */
public class ArtistFinder extends Finder<Artist> {

    private final Context context;

    public ArtistFinder(Context context) {
        super(context);
        this.context = context;
    }


    @Override
    protected Cursor getCursor() {
        return context.getContentResolver()
                .query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, null, null, null,
                        MediaStore.Audio.Artists.DEFAULT_SORT_ORDER);
    }

    @Override
    protected Artist buildSongFromCursor(Cursor cursor) {
        return new Artist.Builder().name(
                cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists.ARTIST)))
                .numAlbums(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_ALBUMS)))
                .id(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Artists._ID)))
                .numTracks(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Artists.NUMBER_OF_TRACKS)))
                .build();
    }
}
