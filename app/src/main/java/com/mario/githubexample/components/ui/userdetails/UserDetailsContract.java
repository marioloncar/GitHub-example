package com.mario.githubexample.components.ui.userdetails;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;
import com.mario.githubexample.data.model.user.User;

/**
 * Created by mario on 10/06/18.
 */

interface UserDetailsContract {
    interface Presenter extends BasePresenter<View> {
        void onRevokeAccessClicked();
    }

    interface View extends BaseDialogView<Presenter> {
        void showUserDetails(User user);

        void showLoginScreen();
    }
}
