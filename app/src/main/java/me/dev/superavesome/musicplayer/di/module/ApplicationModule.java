package me.dev.superavesome.musicplayer.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vardansharma on 15/11/16.
 */

@Module
public class ApplicationModule {
    private final Application application;
    public static final String prefName = "me.dev.superfrustated.musicplayer.prefs";

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context provideContext(){
        return application;
    }

    @Provides
    public Application provideApplication(){
        return application;
    }
    @Provides
    public SharedPreferences provideSharedPreferences(Context context){
        return context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
    }
}
