package com.mario.githubexample.components.ui.main;

import javax.inject.Inject;

/**
 * Created by mario on 06/06/18.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    @Inject
    MainPresenter() {
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }
}
