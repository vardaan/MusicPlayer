package me.dev.superavesome.musicplayer.ui.albumList;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.domain.GetAllAlbumsUseCase;

/**
 * Created by vardansharma on 15/11/16.
 */
@Module
public class AlbumListModule {
    private AlbumListContract.View view;

    public AlbumListModule(AlbumListContract.View view) {
        this.view = view;
    }

    @Provides
    public AlbumListContract.View providesView(){
        return view;
    }

    @Provides
    public AlbumListPresenter providePresenter(AlbumListContract.View view,
                                               GetAllAlbumsUseCase useCase){
        return new AlbumListPresenter(view,useCase);
    }
}
