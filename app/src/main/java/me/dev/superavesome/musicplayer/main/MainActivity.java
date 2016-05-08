package me.dev.superavesome.musicplayer.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.BaseActivity;
import me.dev.superavesome.musicplayer.R;

public class MainActivity extends BaseActivity {

  @Bind(R.id.toolbar) Toolbar toolbar;
  @Bind(R.id.tabs) TabLayout tabs;
  @Bind(R.id.appbar) AppBarLayout appbar;
  @Bind(R.id.viewpager) ViewPager viewpager;
  @Bind(R.id.main_content) CoordinatorLayout mainContent;
  @Bind(R.id.navigation) NavigationView navigationView;
  @Bind(R.id.drawer_layout) DrawerLayout drawerLayout;

  public static Intent createIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    setUpToolbar();

    drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    setupDrawerContent(navigationView);
    //setupViewPager(viewPager);
  }

  private void setUpToolbar() {
    setSupportActionBar(toolbar);

    final ActionBar ab = getSupportActionBar();
    ab.setHomeAsUpIndicator(R.drawable.ic_menu);
    ab.setDisplayHomeAsUpEnabled(true);
  }

  private void setupDrawerContent(NavigationView navigationView) {
    navigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();
            return true;
          }
        });
  }
}
