package me.dev.superavesome.musicplayer.ui.artistList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.InputMismatchException;

import me.dev.superavesome.musicplayer.RxSchedulersOverrideRule;
import me.dev.superavesome.musicplayer.domain.GetAllArtistUseCase;
import me.dev.superavesome.musicplayer.model.Artist;
import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vardansharma on 26/11/16.
 */
public class ArtistListPresenterTest {

    @Rule
    public RxSchedulersOverrideRule testScheduler = new RxSchedulersOverrideRule();
    @Mock
    ArtistListContract.View view;

    @Mock
    GetAllArtistUseCase useCase;

    ArtistListContract.Presenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new ArtistListPresenter(view, useCase);
    }

    @Test
    public void shouldShowDataInCaseOfSuccess() throws Exception {
        final ArrayList<Artist> artists = new ArrayList<>();
        when(useCase.getAllArtistUseCase()).thenReturn(Observable.just(artists));
        presenter.getArtistList();
        verify(view).showData(artists);
    }

    @Test
    public void shouldCallShowErrorInCaseOfFailure() throws Exception{
        when(useCase.getAllArtistUseCase()).thenReturn(Observable.error(new InputMismatchException()));
        presenter.getArtistList();
        verify(view).showErrorScreen();
    }

}
