package me.dev.superavesome.musicplayer.utils;

import android.support.annotation.Nullable;

import rx.Subscriber;
import rx.Subscription;
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


}
