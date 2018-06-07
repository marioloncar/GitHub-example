package com.mario.githubexample.components.ui.browserdetails;

import javax.inject.Inject;

/**
 * Created by mario on 07/06/18.
 */

public class BrowserDetailsPresenter implements BrowserDetailsContract.Presenter {

    private BrowserDetailsContract.View view;
    private String url;

    @Inject
    BrowserDetailsPresenter() {
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
    public void setView(BrowserDetailsContract.View view) {
        this.view = view;
        url = view.getUrlExtra();
        if (url != null) {
            view.loadWebsite(url);
        }
    }
}
