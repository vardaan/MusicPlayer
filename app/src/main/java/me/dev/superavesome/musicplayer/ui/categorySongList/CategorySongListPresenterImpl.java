package me.dev.superavesome.musicplayer.ui.categorySongList;

import me.dev.superavesome.musicplayer.constants.Category;
import me.dev.superavesome.musicplayer.domain.GetAllSongsFromCategoryUseCase;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static me.dev.superavesome.musicplayer.utils.Preconditions.checkNotNull;

/**
 * Created by vardansharma on 26/11/16.
 */
public class CategorySongListPresenterImpl implements CategorySongListContract.Presenter {
    private final CategorySongListContract.View view;
    private final GetAllSongsFromCategoryUseCase useCase;

    public CategorySongListPresenterImpl(CategorySongListContract.View view,
                                         GetAllSongsFromCategoryUseCase useCase) {
        this.view = checkNotNull(view, "view is null");
        this.useCase = checkNotNull(useCase, "usecase is null");
    }

    @Override
    public void getData(String categoryId, @Category int categoryType) {
        view.showLoading();
        useCase.getAllSongsFromCategory(categoryId, categoryType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(songs -> {
                    view.showData(songs);
                }, throwable -> {
                    view.showErrorScreen();
                });
    }

    @Override
    public void detachFromUi() {

    }
}
