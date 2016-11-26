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
public class GetAllSongsUseCaseImplTest {

    @Mock
    DataManager dataManager;

    GetAllSongsUseCaseImpl useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCase = new GetAllSongsUseCaseImpl(dataManager);
    }

    @Test
    public void shouldCallDataManagerForSongs() throws Exception {
        Mockito.when(dataManager.getAllSongs()).thenReturn(Observable.just(new ArrayList<>()));
        useCase.getAllSongs();
        Mockito.verify(dataManager).getAllSongs();

    }
}