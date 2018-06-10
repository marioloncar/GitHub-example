package com.mario.githubexample.components.ui.userdetails;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;
import com.mario.githubexample.data.model.user.User;

interface UserDetailsContract {
    interface Presenter extends BasePresenter<View> {
    }

    interface View extends BaseDialogView<Presenter> {
        void showUserDetails(User user);
    }
}
