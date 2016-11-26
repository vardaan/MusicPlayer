package me.dev.superavesome.musicplayer;

import android.view.Gravity;

import com.codemonkeylabs.fpslibrary.TinyDancer;
import com.squareup.leakcanary.LeakCanary;

import me.dev.superavesome.musicplayer.base.BaseApp;
import timber.log.Timber;

/**
 * Created by vardansharma on 25/11/16.
 */

public class MusicDebugApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        //enabling Timber
        Timber.plant(new Timber.DebugTree());

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        TinyDancer.create()
                .redFlagPercentage(.1f) // set red indicator for 10%
                .startingGravity(Gravity.TOP)
                .startingXPosition(200)
                .startingYPosition(600)
                .show(this);

    }
}
