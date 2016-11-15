package me.dev.superavesome.musicplayer.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import me.dev.superavesome.musicplayer.di.ActivityScope;

/**
 * Created by vardansharma on 15/11/16.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @ActivityScope
    Activity activity() {
        return this.activity;
    }

}
