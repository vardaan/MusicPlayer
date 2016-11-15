package me.dev.superavesome.musicplayer.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.data.DataManager;
import me.dev.superavesome.musicplayer.domain.GetAllAlbumsUseCase;
import me.dev.superavesome.musicplayer.domain.GetAllAlbumsUseCaseImpl;
import me.dev.superavesome.musicplayer.domain.GetAllArtistUseCase;
import me.dev.superavesome.musicplayer.domain.GetAllArtistUseCaseImpl;
import me.dev.superavesome.musicplayer.domain.GetAllSongsUseCase;
import me.dev.superavesome.musicplayer.domain.GetAllSongsUseCaseImpl;

/**
 * Created by vardansharma on 15/11/16.
 */

@Module
public class DomainModule {

    @Provides
    @Singleton
    GetAllArtistUseCase providesGetAllArtistUseCase(DataManager dataManager) {
        return new GetAllArtistUseCaseImpl(dataManager);
    }

    @Provides
    @Singleton
    GetAllAlbumsUseCase providesGetAllAlbumsUseCase(DataManager dataManager) {
        return new GetAllAlbumsUseCaseImpl(dataManager);
    }

    @Provides
    @Singleton
    GetAllSongsUseCase providesGetAllSongsUseCase(DataManager dataManager) {
        return new GetAllSongsUseCaseImpl(dataManager);
    }
}
