package me.dev.superavesome.musicplayer.ui.main;

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

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.dev.superavesome.musicplayer.R;
import me.dev.superavesome.musicplayer.base.BaseActivity;
import me.dev.superavesome.musicplayer.ui.albumList.AlbumListFragment;
import me.dev.superavesome.musicplayer.ui.artistList.ArtistListFragment;
import me.dev.superavesome.musicplayer.ui.songList.SongListFragment;


/**
 * Home screen for our app will hold the drawer and
 * songList, ArtistList and AlbumList in a same fragment
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.main_content)
    CoordinatorLayout mainContent;
    @Bind(R.id.navigation)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUpUI();
    }

    private void setUpUI() {
        setUpToolbar();

        setupDrawerContent(navigationView);

        setupViewPager(viewpager);

        tabs.setupWithViewPager(viewpager);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.my_music);

        //Todo check making some weird animation
        final ActionBarDrawerToggle mDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.my_music,
                        R.string.my_music);
        drawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        final ActionBar ab = getSupportActionBar();
        if (ab == null) {
            throw new IllegalStateException("action bar is null");
        }

        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void setupViewPager(ViewPager viewPager) {
        List<? extends Fragment> fragments
                = Arrays.asList(new AlbumListFragment(), new SongListFragment(), new ArtistListFragment());
        final List<String> titles = Arrays.asList("Albums", "Songs", "Artists");
        final Adapter adapter = new Adapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(fragments.size());
    }

    static class Adapter extends FragmentPagerAdapter {
        private  List<? extends Fragment> fragments;
        private final List<String> titles;

        public Adapter(FragmentManager fm, List<? extends Fragment> fragments, List<String> titles) {
            super(fm);
            this.fragments = fragments;
            this.titles = titles;
        }


        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
