package com.mario.githubexample.components.ui.repodetails;

import com.mario.githubexample.components.ui.base.MvpDialogView;
import com.mario.githubexample.components.ui.base.MvpPresenter;
import com.mario.githubexample.data.model.repo.Items;
import com.mario.githubexample.data.model.repo.Owner;

/**
 * Created by mario on 08/06/18.
 */

interface RepoDetailsContract {
    interface Presenter extends MvpPresenter<View> {
        void onOpenInBrowserClicked();

        void onShowOwnerDetailsClicked();
    }

    interface View extends MvpDialogView<Presenter> {
        Items getItemsExtra();

        void showRepoDetails(Items items);

        void showRepoDetailsInBrowser(String url);

        void showOwnerDetails(Owner owner);

    }
}
