package com.mario.githubexample.components.ui.repodetails;

import com.mario.githubexample.data.model.repo.Items;

import javax.inject.Inject;

/**
 * Created by mario on 08/06/18.
 */

public class RepoDetailsPresenter implements RepoDetailsContract.Presenter {

    private RepoDetailsContract.View view;
    private Items items;

    @Inject
    RepoDetailsPresenter() {
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
    public void setView(RepoDetailsContract.View view) {
        this.view = view;
        items = view.getItemsExtra();
        if (items != null) {
            view.showRepoDetails(items);
        }
    }

    @Override
    public void onOpenInBrowserClicked() {
        if (view != null) {
            view.showRepoDetailsInBrowser(items.getHtmlUrl());
        }
    }

    @Override
    public void onShowOwnerDetailsClicked() {
        if (view != null) {
            view.showOwnerDetails(items.getOwner());
        }
    }
}
