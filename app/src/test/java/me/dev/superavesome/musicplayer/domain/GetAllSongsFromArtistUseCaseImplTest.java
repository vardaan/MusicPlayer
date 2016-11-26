package me.dev.superavesome.musicplayer.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import me.dev.superavesome.musicplayer.data.DataSource;
import rx.Observable;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vardansharma on 26/11/16.
 */
public class GetAllSongsFromArtistUseCaseImplTest {
    @Mock
    DataSource dataSource;


    GetAllSongsFromArtistUseCaseImpl useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCase = new GetAllSongsFromArtistUseCaseImpl(dataSource);
    }

    @Test
    public void shouldCallDataSourceToFetchSongs() throws Exception {
        when(dataSource.getAllSongsFromArtist(anyString())).thenReturn(Observable.just(new ArrayList<>()));
        useCase.getAllSongsFromArtist(anyString());
        verify(dataSource).getAllSongsFromArtist(anyString());
    }
}