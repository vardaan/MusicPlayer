package me.dev.superavesome.musicplayer.ui.songList;

import dagger.Component;
import me.dev.superavesome.musicplayer.di.ActivityScope;
import me.dev.superavesome.musicplayer.di.component.AppComponent;

/**
 * Created by vardansharma on 15/11/16.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = SongListModule.class)
interface SongListComponent {

    void inject(SongListFragment target);

    SongListPresenter getSongListPresenter();
}
