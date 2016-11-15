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

    public ArtistModule(ArtistListContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public ArtistListContract.View provideView() {
        return view;
    }

    @Provides
    @ActivityScope
    public ArtistListPresenter provideArtistListPresenter(ArtistListContract.View view, GetAllArtistUseCase useCase){
        return new ArtistListPresenter(view,useCase);
    }
}
