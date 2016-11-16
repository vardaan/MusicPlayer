package me.dev.superavesome.musicplayer.ui.artistList;

import javax.inject.Inject;

import me.dev.superavesome.musicplayer.domain.GetAllArtistUseCase;
import me.dev.superavesome.musicplayer.utils.RxUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

import static me.dev.superavesome.musicplayer.utils.Preconditions.checkNotNull;

/**
 * Created by vardansharma on 15/11/16.
 */
class ArtistListPresenter implements ArtistListContract.Presenter {
    private GetAllArtistUseCase useCase;
    private ArtistListContract.View view;
    private CompositeSubscription subscription;

    @Inject
    public ArtistListPresenter(ArtistListContract.View view, GetAllArtistUseCase useCase) {
        this.useCase = checkNotNull(useCase, "GetAllArtistUseCase is null");
        this.view = checkNotNull(view, "ArtistListContract.view is null");
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void getArtistList() {
        useCase.getAllArtistUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(artists -> {
                    view.showData(artists);
                }, throwable -> {
                    Timber.e(throwable.getMessage());
                });
    }

    @Override
    public void detachFromUi() {
        RxUtils.unSubscribe(subscription);
    }
}
