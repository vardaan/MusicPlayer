package me.dev.superavesome.musicplayer.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.data.DataManager;
import me.dev.superavesome.musicplayer.data.local.AlbumFinder;
import me.dev.superavesome.musicplayer.data.local.ArtistFinder;
import me.dev.superavesome.musicplayer.data.local.LocalDataSource;
import me.dev.superavesome.musicplayer.data.local.SongFinder;
import me.dev.superavesome.musicplayer.data.remote.RemoteDataSource;

/**
 * Created by vardansharma on 15/11/16.
 */

@Module
public class DataModule {
    @Provides
    @Singleton
    LocalDataSource providesLocalDataSource(Context context, ArtistFinder artistFinder,
                                            AlbumFinder albumFinder, SongFinder songFinder) {
        return new LocalDataSource(context, albumFinder, artistFinder);
    }

    @Provides
    @Singleton
    DataManager providesDataManger(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        return new DataManager(localDataSource, remoteDataSource);
    }

    @Provides
    @Singleton
    RemoteDataSource providesRemoteDataSource() {
        return new RemoteDataSource();
    }

}
