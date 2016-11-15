package me.dev.superavesome.musicplayer.ui.albumList;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.domain.GetAllAlbumsUseCase;

/**
 * Created by vardansharma on 15/11/16.
 */
@Module
class AlbumListModule {
    private AlbumListContract.View view;

    AlbumListModule(AlbumListContract.View view) {
        this.view = view;
    }

    @Provides
    AlbumListContract.View providesView(){
        return view;
    }

    @Provides
    AlbumListPresenter providePresenter(AlbumListContract.View view,
                                        GetAllAlbumsUseCase useCase){
        return new AlbumListPresenter(view,useCase);
    }
}
