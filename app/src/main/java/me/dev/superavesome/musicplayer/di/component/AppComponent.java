package me.dev.superavesome.musicplayer.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import me.dev.superavesome.musicplayer.base.BaseActivity;
import me.dev.superavesome.musicplayer.di.module.ApplicationModule;
import me.dev.superavesome.musicplayer.di.module.DataModule;
import me.dev.superavesome.musicplayer.di.module.DomainModule;
import me.dev.superavesome.musicplayer.di.module.LocalDataStoreModule;
import me.dev.superavesome.musicplayer.domain.GetAllAlbumsUseCase;
import me.dev.superavesome.musicplayer.domain.GetAllArtistUseCase;
import me.dev.superavesome.musicplayer.domain.GetAllGenreUseCase;
import me.dev.superavesome.musicplayer.domain.GetAllSongsUseCase;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class,
        DataModule.class,
        DomainModule.class,
        LocalDataStoreModule.class})
public interface AppComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();

    GetAllAlbumsUseCase provideGetAllAlbumsUseCase();

    GetAllSongsUseCase provideGetAllSongsUseCase();

    GetAllArtistUseCase provideGetAllArtistUseCase();

    GetAllGenreUseCase provideGetAllGenreUseCase();
}
