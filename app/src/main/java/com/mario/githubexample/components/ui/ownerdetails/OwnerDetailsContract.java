package com.mario.githubexample.components.ui.ownerdetails;

import com.mario.githubexample.components.ui.base.MvpDialogView;
import com.mario.githubexample.components.ui.base.MvpPresenter;
import com.mario.githubexample.data.model.repo.Owner;

interface OwnerDetailsContract {
    interface Presenter extends MvpPresenter<View> {
        void onOpenInBrowserClicked();
    }

    interface View extends MvpDialogView<Presenter> {
        Owner getOwnerExtra();

        void showUserData(Owner user);

        void showUserDetailsInBrowser(String url);
    }
}
