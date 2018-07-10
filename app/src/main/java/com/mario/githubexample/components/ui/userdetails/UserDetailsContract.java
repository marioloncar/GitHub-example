package com.mario.githubexample.components.ui.userdetails;

import com.mario.githubexample.components.base.MvpDialogView;
import com.mario.githubexample.components.base.MvpPresenter;
import com.mario.githubexample.data.model.user.User;

/**
 * Created by mario on 10/06/18.
 */

interface UserDetailsContract {
    interface Presenter extends MvpPresenter<View> {
        void onRevokeAccessClicked();
    }

    interface View extends MvpDialogView<Presenter> {
        void showUserDetails(User user);

        void showLoginScreen();
    }
}
