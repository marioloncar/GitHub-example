package com.mario.githubexample.components.base;

/**
 * Created by mario on 06/06/18.
 */

public interface MvpPresenter<V extends MvpView> {

    /**
     * Notify the presenter when the View is destroyed
     */
    void onDestroy();

    /**
     * Notify the presenter when the View is resumed
     */
    void onResume();

    /**
     * Notify the presenter when the View is paused
     */
    void onPause();

    /**
     * Pass the view to the presenter
     */
    void setView(V v);
}