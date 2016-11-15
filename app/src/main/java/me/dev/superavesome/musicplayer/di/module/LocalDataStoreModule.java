package me.dev.superavesome.musicplayer.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.data.local.AlbumFinder;
import me.dev.superavesome.musicplayer.data.local.ArtistFinder;
import me.dev.superavesome.musicplayer.data.local.SongFinder;

/**
 * Created by vardansharma on 15/11/16.
 */

@Module
public class LocalDataStoreModule {
    @Provides
    @Singleton
    public SongFinder providesSongFinder(Context context) {
        return new SongFinder(context);
    }

    @Provides
    @Singleton
    public AlbumFinder providesAlbumFinder(Context context) {
        return new AlbumFinder(context);
    }

    @Provides
    @Singleton
    public ArtistFinder providesArtistFinder(Context context) {
        return new ArtistFinder(context);
    }
}
