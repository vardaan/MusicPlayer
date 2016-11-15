package me.dev.superavesome.musicplayer.di.module;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.data.DataManager;
import me.dev.superavesome.musicplayer.di.PerActivity;
import me.dev.superavesome.musicplayer.domain.GetAllAlbumsUseCase;
import me.dev.superavesome.musicplayer.domain.GetAllAlbumsUseCaseImpl;
import me.dev.superavesome.musicplayer.domain.GetAllArtistUseCase;
import me.dev.superavesome.musicplayer.domain.GetAllArtistUseCaseImpl;
import me.dev.superavesome.musicplayer.domain.GetAllSongsUseCase;
import me.dev.superavesome.musicplayer.domain.GetAllSongsUseCaseImpl;
import me.dev.superavesome.musicplayer.ui.albumList.AlbumListPresenter;
import me.dev.superavesome.musicplayer.ui.songList.SongListPresenter;

/**
 * Created by vardansharma on 15/11/16.
 */

@Module
public class DomainModule {

    @Provides
    @PerActivity
    GetAllArtistUseCase providesGetAllArtistUseCase(DataManager dataManager) {
        return new GetAllArtistUseCaseImpl(dataManager);
    }

    @Provides
    @PerActivity
    AlbumListPresenter providesAlbumListPresenter(GetAllAlbumsUseCase useCase){
        return new AlbumListPresenter(useCase);
    }

    @Provides
    @PerActivity
    SongListPresenter providesSongListPresenter(GetAllSongsUseCase useCase){
        return new SongListPresenter(useCase);
    }

    @Provides
    @PerActivity
    GetAllAlbumsUseCase providesGetAllAlbumsUseCase(DataManager dataManager) {
        return new GetAllAlbumsUseCaseImpl(dataManager);
    }

    @Provides
    @PerActivity
    GetAllSongsUseCase providesGetAllSongsUseCase(DataManager dataManager) {
        return new GetAllSongsUseCaseImpl(dataManager);
    }
}
