package me.dev.superavesome.musicplayer.constants;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;
import static me.dev.superavesome.musicplayer.constants.Category.ALBUM;
import static me.dev.superavesome.musicplayer.constants.Category.ARTIST;
import static me.dev.superavesome.musicplayer.constants.Category.GENRE;

/**
 * Created by vardansharma on 26/11/16.
 */
@Retention(SOURCE)
@IntDef(value = {GENRE, ALBUM, ARTIST})
public @interface Category {
    int GENRE = 0x01;
    int ALBUM = 0x02;
    int ARTIST = 0x03;
}
