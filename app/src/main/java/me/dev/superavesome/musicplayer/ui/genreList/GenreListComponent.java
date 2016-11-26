package me.dev.superavesome.musicplayer.ui.genreList;

import dagger.Component;
import me.dev.superavesome.musicplayer.di.ActivityScope;
import me.dev.superavesome.musicplayer.di.component.AppComponent;

/**
 * Created by vardansharma on 25/11/16.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {GenreListModule.class})
public interface GenreListComponent {
    void inject(GenreListFragment target);

    GenreListPresenter provideGenreListPresenter();
}
