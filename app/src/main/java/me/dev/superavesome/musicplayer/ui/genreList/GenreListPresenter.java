package me.dev.superavesome.musicplayer.ui.genreList;

import me.dev.superavesome.musicplayer.domain.GetAllGenreUseCase;
import rx.subscriptions.CompositeSubscription;

import static me.dev.superavesome.musicplayer.utils.RxUtils.applyIOScheduler;
import static me.dev.superavesome.musicplayer.utils.RxUtils.unSubscribe;

/**
 * Created by vardansharma on 18/11/16.
 */
public class GenreListPresenter implements GenreListContract.Presenter {
    private final GenreListContract.View view;
    private final GetAllGenreUseCase useCase;
    private CompositeSubscription subscription;

    public GenreListPresenter(GenreListContract.View view, GetAllGenreUseCase useCase) {
        this.view = view;
        this.useCase = useCase;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void getAllGenres() {
        view.showLoading();
        subscription.add(useCase.getAllGenre()
                .compose(applyIOScheduler())
                .subscribe(view::showAllGenres, throwable -> {
                    view.showErrorScreen();
                }));
    }

    @Override
    public void detachFromUi() {
        unSubscribe(subscription);
    }
}
