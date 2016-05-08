package me.dev.superavesome.musicplayer.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import me.dev.superavesome.musicplayer.ArtistFragment;
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

    setupDrawerContent(navigationView);

    setupViewPager(viewpager);

    tabs.setupWithViewPager(viewpager);
  }

  private void setUpToolbar() {
    setSupportActionBar(toolbar);
    toolbar.setTitle(R.string.my_music);

    //Todo check making some weird animation
    ActionBarDrawerToggle mDrawerToggle =
        new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.my_music,
            R.string.my_music);
    drawerLayout.addDrawerListener(mDrawerToggle);
    mDrawerToggle.syncState();

    final ActionBar ab = getSupportActionBar();
    ab.setHomeAsUpIndicator(R.drawable.ic_menu);
    ab.setDisplayHomeAsUpEnabled(true);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    final int id = item.getItemId();
    switch (id) {
      case android.R.id.home:
        drawerLayout.openDrawer(GravityCompat.START);
        break;
    }
    return super.onOptionsItemSelected(item);
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

  private void setupViewPager(ViewPager viewPager) {
    Adapter adapter = new Adapter(getSupportFragmentManager());
    adapter.addFragment(new ArtistFragment(), "Artists");
    adapter.addFragment(new ArtistFragment(), "Songs");
    adapter.addFragment(new ArtistFragment(), "Genre");
    viewPager.setAdapter(adapter);
  }

  static class Adapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public Adapter(FragmentManager fm) {
      super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
      mFragments.add(fragment);
      mFragmentTitles.add(title);
    }

    @Override public Fragment getItem(int position) {
      return mFragments.get(position);
    }

    @Override public int getCount() {
      return mFragments.size();
    }

    @Override public CharSequence getPageTitle(int position) {
      return mFragmentTitles.get(position);
    }
  }
}
