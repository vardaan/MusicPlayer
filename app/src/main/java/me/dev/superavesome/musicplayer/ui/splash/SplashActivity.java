package me.dev.superavesome.musicplayer.ui.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import me.dev.superavesome.musicplayer.ui.main.MainActivity;

/**
 * Shows the application launcher for the time it takes app to boots up
 */

public class SplashActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // move to main activity
    startActivity(MainActivity.createIntent(SplashActivity.this));
    finish();//finish the current one
  }
}
