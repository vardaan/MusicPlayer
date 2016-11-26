package me.dev.superavesome.musicplayer.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import me.dev.superavesome.musicplayer.data.DataSource;
import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vardansharma on 26/11/16.
 */

public class GetAllSongsFromGenreUseCaseImplTest {
    @Mock
    DataSource dataSource;
    String genreId;

    GetAllSongsFromGenreUseCaseImpl useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCase = new GetAllSongsFromGenreUseCaseImpl(dataSource,genreId);
    }

    @Test
    public void shouldCallDataSourceToGetSongs() throws Exception {
        when(dataSource.getAllSongsFromGenre(genreId)).thenReturn(Observable.just(new ArrayList<>()));
        useCase.getAllSongsFromGenre(genreId);
        verify(dataSource).getAllSongsFromGenre(genreId);
    }
}
