package me.dev.superavesome.musicplayer.ui.songList;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.di.ActivityScope;
import me.dev.superavesome.musicplayer.domain.GetAllSongsUseCase;

/**
 * Created by vardansharma on 15/11/16.
 */
@Module
public class SongListModule {
    private SongListContract.View view;

    SongListModule(SongListContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    SongListContract.View provideView(){
        return view;
    }

    @Provides
    @ActivityScope
    SongListPresenter providePresenter(SongListContract.View view, GetAllSongsUseCase useCase){
        return new SongListPresenter(view,useCase);
    }
}
