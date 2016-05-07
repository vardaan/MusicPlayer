package me.dev.superavesome.musicplayer.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import me.dev.superavesome.musicplayer.BaseActivity;
import me.dev.superavesome.musicplayer.R;

public class MainActivity extends BaseActivity {

  public static Intent createIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
