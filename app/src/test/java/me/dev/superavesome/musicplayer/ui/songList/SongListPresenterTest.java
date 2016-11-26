package me.dev.superavesome.musicplayer.ui.songList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import me.dev.superavesome.musicplayer.RxSchedulersOverrideRule;
import me.dev.superavesome.musicplayer.domain.GetAllSongsUseCase;
import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vardansharma on 26/11/16.
 */
public class SongListPresenterTest {
    @Rule
    public RxSchedulersOverrideRule hook = new RxSchedulersOverrideRule();

    @Mock
    SongListContract.View view;

    @Mock
    GetAllSongsUseCase useCase;

    SongListContract.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new SongListPresenter(view, useCase);
    }

    @Test
    public void shouldShowDataOnSuccess() throws Exception {
        final ArrayList<Song> songs = new ArrayList<>();
        when(useCase.getAllSongs()).thenReturn(Observable.just(songs));
        presenter.getSongList();
        verify(view).showSongList(songs);

    }

    @Test
    public void shouldShowErrorOnFailure() throws Exception {
        when(useCase.getAllSongs()).thenReturn(Observable.error(new Throwable()));
        presenter.getSongList();
        verify(view).showErrorScreen();
    }
}