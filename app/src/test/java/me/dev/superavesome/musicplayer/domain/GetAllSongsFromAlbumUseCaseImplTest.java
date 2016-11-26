package me.dev.superavesome.musicplayer.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import me.dev.superavesome.musicplayer.data.DataSource;

import static org.mockito.Mockito.verify;

/**
 * Created by vardansharma on 26/11/16.
 */
public class GetAllSongsFromAlbumUseCaseImplTest {
    @Mock
    DataSource dataSource;
    GetAllSongsFromAlbumUseCaseImpl useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCase = new GetAllSongsFromAlbumUseCaseImpl(dataSource);
    }

    @Test
    public void shouldCallDataSourceTogetData() throws Exception {
        final String albumId = "123";
        useCase.getAllSongsFromAlbum(albumId);
        verify(dataSource).getAllSongsFromAlbum(albumId);
    }
}