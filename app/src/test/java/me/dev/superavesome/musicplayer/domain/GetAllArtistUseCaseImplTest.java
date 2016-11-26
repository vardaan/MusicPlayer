package me.dev.superavesome.musicplayer.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import me.dev.superavesome.musicplayer.data.DataManager;
import rx.Observable;

/**
 * Created by vardansharma on 26/11/16.
 */
public class GetAllArtistUseCaseImplTest {
    @Mock
    DataManager dataManager;

    GetAllAlbumsUseCaseImpl useCase;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCase =new GetAllAlbumsUseCaseImpl(dataManager);
    }

    @Test
    public void shouldAllDataManagerForData() throws Exception {
        Mockito.when(dataManager.getAllAlbums()).thenReturn(Observable.just(new ArrayList<>()));
        useCase.getAlbumList();
        Mockito.verify(dataManager).getAllAlbums();

    }
}