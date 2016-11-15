package me.dev.superavesome.musicplayer.ui.artistList;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.di.ActivityScope;
import me.dev.superavesome.musicplayer.domain.GetAllArtistUseCase;

/**
 * Created by vardansharma on 15/11/16.
 */

@Module
public class ArtistModule {
    private ArtistListContract.View view;

    ArtistModule(ArtistListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ArtistListContract.View provideView() {
        return view;
    }

    @Provides
    @ActivityScope
    ArtistListPresenter provideArtistListPresenter(ArtistListContract.View view, GetAllArtistUseCase useCase){
        return new ArtistListPresenter(view,useCase);
    }
}
