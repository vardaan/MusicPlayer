package me.dev.superavesome.musicplayer.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import me.dev.superavesome.musicplayer.MainActivity;

public class SplashActivity extends AppCompatActivity {

  public static Intent createIntent(Context context) {
    return new Intent(context, SplashActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // move to main activity
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }
}
