package me.dev.superavesome.musicplayer.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.data.local.AlbumFinder;
import me.dev.superavesome.musicplayer.data.local.ArtistFinder;
import me.dev.superavesome.musicplayer.data.local.SongFinder;
import me.dev.superavesome.musicplayer.di.PerActivity;

/**
 * Created by vardansharma on 15/11/16.
 */

@Module
public class LocalDataStoreModule {
    @Provides
    @PerActivity
    public SongFinder providesSongFinder(Context context) {
        return new SongFinder(context);
    }

    @Provides
    @PerActivity
    public AlbumFinder providesAlbumFinder(Context context) {
        return new AlbumFinder(context);
    }

    @Provides
    @PerActivity
    public ArtistFinder providesArtistFinder(Context context) {
        return new ArtistFinder(context);
    }
}
