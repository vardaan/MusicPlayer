package me.dev.superavesome.musicplayer.ui.songList;

import javax.inject.Inject;

import me.dev.superavesome.musicplayer.domain.GetAllSongsUseCase;
import me.dev.superavesome.musicplayer.utils.RxUtils;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

import static me.dev.superavesome.musicplayer.utils.Preconditions.checkNotNull;

/**
 * Created by vardansharma on 15/11/16.
 */

class SongListPresenter implements SongListContract.Presenter<SongListContract.View> {
    private GetAllSongsUseCase useCase;
    private SongListContract.View view;
    private CompositeSubscription subscriptions;

    @Inject
    SongListPresenter(SongListContract.View view, GetAllSongsUseCase useCase) {
        this.useCase = checkNotNull(useCase,"GetAllSongsUseCase is null");
        this.view = checkNotNull(view,"SongListContract.View is null");
        subscriptions = new CompositeSubscription();
    }

    @Override
    public void getSongList() {
        subscriptions.add(useCase.getAllSongs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(songs -> {
                    view.showSongList(songs);
                }, throwable -> {
                    Timber.e(throwable.getMessage());
                }));
    }

    @Override
    public void detachFromUi() {
        RxUtils.unSubscribe(subscriptions);
    }
}
