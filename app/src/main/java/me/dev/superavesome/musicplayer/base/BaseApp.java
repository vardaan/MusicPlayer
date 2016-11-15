package me.dev.superavesome.musicplayer.base;

import android.app.Application;

import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.di.component.AppComponent;
import me.dev.superavesome.musicplayer.di.component.DaggerAppComponent;
import me.dev.superavesome.musicplayer.di.module.ApplicationModule;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Vardan sharma on 8/5/16.
 * Base application for our application enables calligraphy
 */
public class BaseApp extends Application {
    private AppComponent applicationComponent;

    public AppComponent getApplicationComponent() {
        return DaggerAppComponent.builder().applicationModule(new ApplicationModule(this))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // enabling calligraphy
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder().setDefaultFontPath("fonts/Roboto-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());

        //enabling Timber
        Timber.plant(new Timber.DebugTree());//todo refactor add else statement
    }
}
