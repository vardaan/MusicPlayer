package me.dev.superavesome.musicplayer.ui.artistList;

import dagger.Component;
import me.dev.superavesome.musicplayer.di.ActivityScope;
import me.dev.superavesome.musicplayer.di.component.AppComponent;

/**
 * Created by vardansharma on 15/11/16.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ArtistModule.class)
interface ArtistListComponent {
    void inject(ArtistListFragment target);

    ArtistListPresenter provideArtistListPresenter();
}
