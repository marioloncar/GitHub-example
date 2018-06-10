package com.mario.githubexample.components.ui.login;

import android.net.Uri;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;

interface LoginContract {
    interface Presenter extends BasePresenter<View> {
        void onLoginClicked();
    }

    interface View extends BaseDialogView<Presenter> {
        void showAuthorizeGitHub(String authUrl);
        Uri getDataFromUriIntent();
        void goToSearchScreen();
    }
}
