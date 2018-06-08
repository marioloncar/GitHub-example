package com.mario.githubexample.components.ui.userdetails;

import com.mario.githubexample.data.model.repo.Owner;

import javax.inject.Inject;

public class UserDetailsPresenter implements UserDetailsContract.Presenter {

    private UserDetailsContract.View view;
    private Owner owner;

    @Inject
    UserDetailsPresenter() {
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
    public void setView(UserDetailsContract.View view) {
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
