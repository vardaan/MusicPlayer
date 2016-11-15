package me.dev.superavesome.musicplayer.base;

/**
 * Created by vardansharma on 15/11/16.
 */

public interface BaseView {
    void showLoading();

    void hideLoading();

    void showEmptyScreen();

    void hideEmptyScreen();

    void showErrorScreen();
}
