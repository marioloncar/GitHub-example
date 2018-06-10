package com.mario.githubexample.components.ui.ownerdetails;

import com.mario.githubexample.data.model.repo.Owner;

import javax.inject.Inject;

public class OwnerDetailsPresenter implements OwnerDetailsContract.Presenter {

    private OwnerDetailsContract.View view;
    private Owner owner;

    @Inject
    OwnerDetailsPresenter() {
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
    public void setView(OwnerDetailsContract.View view) {
        this.view = view;
        owner = view.getOwnerExtra();
        if (owner != null) {
            view.showUserData(owner);
        }
    }

    @Override
    public void onOpenInBrowserClicked() {
        if (view != null) {
            view.showUserDetailsInBrowser(owner.getHtmlUrl());
        }
    }
}
