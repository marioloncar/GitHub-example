package com.mario.githubexample.components.ui.ownerdetails;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;
import com.mario.githubexample.data.model.repo.Owner;

interface OwnerDetailsContract {
    interface Presenter extends BasePresenter<View> {
        void onOpenInBrowserClicked();
    }

    interface View extends BaseDialogView<Presenter> {
        Owner getOwnerExtra();

        void showUserData(Owner user);

        void showUserDetailsInBrowser(String url);
    }
}
