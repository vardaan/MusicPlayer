package me.dev.superavesome.musicplayer.ui.genreSongList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import me.dev.superavesome.musicplayer.RxSchedulersOverrideRule;
import me.dev.superavesome.musicplayer.constants.Category;
import me.dev.superavesome.musicplayer.domain.GetAllSongsFromCategoryUseCase;
import me.dev.superavesome.musicplayer.model.Song;
import me.dev.superavesome.musicplayer.ui.categorySongList.CategorySongListContract;
import me.dev.superavesome.musicplayer.ui.categorySongList.CategorySongListPresenterImpl;
import rx.Observable;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vardansharma on 26/11/16.
 */

public class CategorySongListPresenterTest {
    @Rule
    public RxSchedulersOverrideRule rule = new RxSchedulersOverrideRule();

    @Mock
    public CategorySongListContract.View view;

    @Mock
    public GetAllSongsFromCategoryUseCase useCase;


    CategorySongListPresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new CategorySongListPresenterImpl(view, useCase);
    }

    @Test
    public void shouldCallShowLoadingWhenRequestingData() throws Exception {
        final ArrayList<Song> songs = new ArrayList<>();
        when(useCase.getAllSongsFromCategory(anyString(), anyInt())).thenReturn(Observable.just(songs));
        presenter.getData("someId", Category.ARTIST);
        verify(view).showLoading();
    }

    @Test
    public void shouldCallShowDataOnSuccess() throws Exception {
        final ArrayList<Song> songs = new ArrayList<>();
        when(useCase.getAllSongsFromCategory(anyString(), anyInt())).thenReturn(Observable.just(songs));
        presenter.getData("someId", Category.ALBUM);
        verify(view).showData(songs);
    }

    @Test
    public void shouldShowErrorScreenOnError() throws Exception {
        when(useCase.getAllSongsFromCategory(anyString(), anyInt())).thenReturn(Observable.error(new Throwable()));
        presenter.getData("someId", Category.ALBUM);
        verify(view).showErrorScreen();
    }
}