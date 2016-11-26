package me.dev.superavesome.musicplayer.ui.genreList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import me.dev.superavesome.musicplayer.RxSchedulersOverrideRule;
import me.dev.superavesome.musicplayer.domain.GetAllGenreUseCase;
import me.dev.superavesome.musicplayer.model.Genre;
import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vardansharma on 26/11/16.
 */
public class GenreListPresenterTest {
    @Rule
    public RxSchedulersOverrideRule rule = new RxSchedulersOverrideRule();

    @Mock
    GenreListContract.View view;

    @Mock
    GetAllGenreUseCase useCase;

    GenreListPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new GenreListPresenter(view, useCase);
    }

    @Test
    public void shouldShowDataOnSuccess() throws Exception {
        final ArrayList<Genre> genres = new ArrayList<>();
        when(useCase.getAllGenre()).thenReturn(Observable.just(genres));
        presenter.getAllGenres();
        verify(view).showAllGenres(genres);
    }

    @Test
    public void shouldShowErrorOnFailure() throws Exception {
        when(useCase.getAllGenre()).thenReturn(Observable.error(new Throwable()));
        presenter.getAllGenres();
        verify(view).showErrorScreen();
    }
}