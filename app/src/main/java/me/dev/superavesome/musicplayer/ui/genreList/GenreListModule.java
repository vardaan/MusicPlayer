package me.dev.superavesome.musicplayer.ui.genreList;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.di.ActivityScope;
import me.dev.superavesome.musicplayer.domain.GetAllGenreUseCase;

/**
 * Created by vardansharma on 25/11/16.
 */
@Module
public class GenreListModule {
    private GenreListContract.View view;

    public GenreListModule(GenreListContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public GenreListContract.View providesView() {
        return view;
    }

    @Provides
    @ActivityScope
    public GenreListContract.Presenter providesPresenter(GetAllGenreUseCase useCase,
                                                         GenreListContract.View view) {
        return new GenreListPresenter(view, useCase);
    }
}
