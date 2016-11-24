package me.dev.superavesome.musicplayer.utils;

import android.support.annotation.Nullable;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author vardansharma
 *         <p>
 *         Utilities method for the usage of RX
 */
public class RxUtils {

    private RxUtils() {
        throw new AssertionError("No instances for utility class");
    }

    /**
     * Unsubscribes itself and all inner subscriptions.
     * <p>After call of this method, new {@code Subscription}s added to {@link CompositeSubscription}
     * will be unsubscribed immediately.
     */
    public static void unSubscribe(@Nullable CompositeSubscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /**
     * Stops the receipt of notifications on the {@link Subscriber} that was registered when this Subscription
     * was received.
     * <p>
     * This allows unregistering an {@link Subscriber} before it has finished receiving all events (i.e. before
     * onCompleted is called).
     */
    public static void unSubscribe(@Nullable Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /**
     * Returns observable which subscribes on io thread and observes on
     * main thread.
     * <p>
     * Use it in .compose() function, it just returns a transformed observable
     * which subscribes and observes on given thread.
     */
    public static <T> Observable.Transformer<T, T> applyIOScheduler() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
