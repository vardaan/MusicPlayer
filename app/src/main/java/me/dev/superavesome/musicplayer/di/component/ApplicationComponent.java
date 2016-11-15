package me.dev.superavesome.musicplayer.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import me.dev.superavesome.musicplayer.base.BaseActivity;
import me.dev.superavesome.musicplayer.di.module.ApplicationModule;
import me.dev.superavesome.musicplayer.di.module.DataModule;
import me.dev.superavesome.musicplayer.di.module.DomainModule;
import me.dev.superavesome.musicplayer.di.module.LocalDataStoreModule;
import me.dev.superavesome.musicplayer.ui.albumList.AlbumListPresenter;
import me.dev.superavesome.musicplayer.ui.albumList.AlbumsFragment;
import me.dev.superavesome.musicplayer.ui.artistList.ArtistFragment;
import me.dev.superavesome.musicplayer.ui.artistList.ArtistListPresenter;
import me.dev.superavesome.musicplayer.ui.songList.SongListFragment;
import me.dev.superavesome.musicplayer.ui.songList.SongListPresenter;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class,
        DataModule.class,
        DomainModule.class,
        LocalDataStoreModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    void inject(ArtistFragment target);

    void inject(SongListFragment target);

    void inject(AlbumsFragment target);

    //Exposed to sub-graphs.
    Context context();

    AlbumListPresenter albumListPresenter();

    SongListPresenter songListPresenter();

    ArtistListPresenter artistListPresenter();
}
