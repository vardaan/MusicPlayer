package me.dev.superavesome.musicplayer.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import me.dev.superavesome.musicplayer.constants.Category;

import static org.mockito.Mockito.verify;

/**
 * Created by vardansharma on 26/11/16.
 */
public class GetAllSongsFromCategoryUseCaseImplTest {
    @Mock
    GetAllSongsFromGenreUseCase fromGenreUseCase;

    @Mock
    GetAllSongsFromArtistUseCase fromArtistUseCase;

    @Mock
    GetAllSongsFromAlbumUseCase fromAlbumUseCase;

    GetAllSongsFromCategoryUseCaseImpl useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        useCase = new GetAllSongsFromCategoryUseCaseImpl(fromArtistUseCase,
                fromGenreUseCase, fromAlbumUseCase);
    }

    @Test
    public void shouldCallArtistUsecaseWhenCategoryIsArtist() throws Exception {
        final String categoryId = "anyID";
        useCase.getAllSongsFromCategory(categoryId, Category.ARTIST);
        verify(fromArtistUseCase).getAllSongsFromArtist(categoryId);
    }

    @Test
    public void shouldCallAlbumUsecaseWhenCategoryIsAlbum() throws Exception {
        final String categoryId = "anyID";
        useCase.getAllSongsFromCategory(categoryId, Category.ALBUM);
        verify(fromAlbumUseCase).getAllSongsFromAlbum(categoryId);
    }

    @Test
    public void shouldCallGenreUsecaseWhenCategoryIsGenre() throws Exception {
        final String categoryId = "anyID";
        useCase.getAllSongsFromCategory(categoryId, Category.GENRE);
        verify(fromGenreUseCase).getAllSongsFromGenre(categoryId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfCategoryIsNotImplemented() throws Exception {
        final String categoryId = "anyID";
        int category = 1212;//invalid id
        useCase.getAllSongsFromCategory(categoryId, category);
    }
}