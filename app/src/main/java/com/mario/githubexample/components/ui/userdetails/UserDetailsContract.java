package com.mario.githubexample.components.ui.userdetails;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;
import com.mario.githubexample.data.model.repo.Owner;

interface UserDetailsContract {
    interface Presenter extends BasePresenter<View> {
        void onOpenInBrowserClicked();
    }

    interface View extends BaseDialogView<Presenter> {
        Owner getOwnerExtra();

        void showUserData(Owner user);

        void showUserDetailsInBrowser(String url);
    }
}
