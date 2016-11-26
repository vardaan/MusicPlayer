package me.dev.superavesome.musicplayer.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import me.dev.superavesome.musicplayer.data.DataManager;
import me.dev.superavesome.musicplayer.model.Genre;
import rx.Observable;

/**
 * Created by vardansharma on 26/11/16.
 */
public class GetAllGenreUseCaseImplTest {
    @Mock
    DataManager dataManager;

    GetAllGenreUseCaseImpl useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCase = new GetAllGenreUseCaseImpl(dataManager);
    }

    @Test
    public void shouldCallDataManagerForGenreList() throws Exception {
        Mockito.when(dataManager.getAllGenres()).thenReturn(Observable.just(new ArrayList<Genre>()));
        useCase.getAllGenre();
        Mockito.verify(dataManager).getAllGenres();
    }
}