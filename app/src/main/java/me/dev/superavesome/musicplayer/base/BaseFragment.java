package me.dev.superavesome.musicplayer.base;

import android.support.v4.app.Fragment;

import me.dev.superavesome.musicplayer.di.component.AppComponent;

/**
 * Created by vardansharma on 15/11/16.
 */

public class BaseFragment extends Fragment implements BaseView{
    public AppComponent getAppComponent() {
        BaseApp baseApp = (BaseApp) getActivity().getApplication();
        return baseApp.getApplicationComponent();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showEmptyScreen() {

    }

    @Override
    public void hideEmptyScreen() {

    }

    @Override
    public void showErrorScreen() {

    }
}
