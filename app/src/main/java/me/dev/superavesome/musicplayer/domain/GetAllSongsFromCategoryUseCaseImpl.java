package me.dev.superavesome.musicplayer.domain;

import java.util.List;

import me.dev.superavesome.musicplayer.constants.Category;
import me.dev.superavesome.musicplayer.model.Song;
import rx.Observable;

import static me.dev.superavesome.musicplayer.utils.Preconditions.checkNotNull;

/**
 * Created by vardansharma on 26/11/16.
 */
public class GetAllSongsFromCategoryUseCaseImpl implements GetAllSongsFromCategoryUseCase {
    private final GetAllSongsFromArtistUseCase fromArtistUseCase;
    private final GetAllSongsFromAlbumUseCase fromAlbumUseCase;
    private final GetAllSongsFromGenreUseCase fromGenreUseCase;

    public GetAllSongsFromCategoryUseCaseImpl(GetAllSongsFromArtistUseCase fromArtistUseCase,
                                              GetAllSongsFromGenreUseCase fromGenreUseCase,
                                              GetAllSongsFromAlbumUseCase fromAlbumUseCase) {
        this.fromAlbumUseCase = checkNotNull(fromAlbumUseCase, "from album usecase is null");
        this.fromArtistUseCase = checkNotNull(fromArtistUseCase, "from artist usecase is null");
        this.fromGenreUseCase = checkNotNull(fromGenreUseCase, "from genre usecase is null");
    }

    @Override
    public Observable<List<Song>> getAllSongsFromCategory(String categoryId,
                                                          @Category int category) {
        checkNotNull(categoryId, "category id cannot be null");
        switch (category) {
            case Category.ALBUM:
                return fromAlbumUseCase.getAllSongsFromAlbum(categoryId);
            case Category.ARTIST:
                return fromArtistUseCase.getAllSongsFromArtist(categoryId);
            case Category.GENRE:
                return fromGenreUseCase.getAllSongsFromGenre(categoryId);
        }
        throw new IllegalArgumentException();
    }
}
