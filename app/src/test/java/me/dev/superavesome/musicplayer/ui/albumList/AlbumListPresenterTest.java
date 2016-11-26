package me.dev.superavesome.musicplayer.ui.albumList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.InputMismatchException;

import me.dev.superavesome.musicplayer.RxSchedulersOverrideRule;
import me.dev.superavesome.musicplayer.domain.GetAllAlbumsUseCase;
import me.dev.superavesome.musicplayer.model.Album;
import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vardansharma on 26/11/16.
 */
public class AlbumListPresenterTest {
    @Rule
    public RxSchedulersOverrideRule testScheduler = new RxSchedulersOverrideRule();
    @Mock
    AlbumListContract.View view;

    @Mock
    GetAllAlbumsUseCase useCase;

    AlbumListPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new AlbumListPresenter(view, useCase);
    }

    @Test
    public void shouldShowDataInCaseOfSuccess() throws Exception {
        final ArrayList<Album> albumList = new ArrayList<>();
        when(useCase.getAlbumList()).thenReturn(Observable.just(albumList));
        presenter.getAlbums();
        verify(view).showAlbums(albumList);
    }

    @Test
    public void shouldCallShowErrorInCaseOfFailure() throws Exception{
        when(useCase.getAlbumList()).thenReturn(Observable.error(new InputMismatchException()));
        presenter.getAlbums();
        verify(view).showErrorScreen();
    }
}