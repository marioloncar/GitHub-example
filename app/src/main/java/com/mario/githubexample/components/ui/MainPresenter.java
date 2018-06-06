package com.mario.githubexample.components.ui;

import javax.inject.Inject;

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
