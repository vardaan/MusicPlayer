package me.dev.superavesome.musicplayer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Vardan Sharma on 8/5/16.
 * Enables calligraphy for each activity
 */
public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }
}
