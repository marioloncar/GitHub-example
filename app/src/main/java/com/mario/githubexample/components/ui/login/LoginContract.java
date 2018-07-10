package com.mario.githubexample.components.ui.login;

import android.net.Uri;

import com.mario.githubexample.components.ui.base.MvpDialogView;
import com.mario.githubexample.components.ui.base.MvpPresenter;

/**
 * Created by mario on 10/06/18.
 */

interface LoginContract {
    interface Presenter extends MvpPresenter<View> {
        void onLoginClicked();
    }

    interface View extends MvpDialogView<Presenter> {
        void showAuthorizeGitHub(String authUrl);

        Uri getDataFromUriIntent();

        void goToSearchScreen();
    }
}
