package me.dev.superavesome.musicplayer.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import me.dev.superavesome.musicplayer.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // move to main activity
    startActivity(MainActivity.createIntent(this));
  }
}
