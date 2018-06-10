package com.mario.githubexample.components.ui.login;

import android.net.Uri;

import com.mario.githubexample.R;
import com.mario.githubexample.helper.SharedPreferencesHelper;
import com.mario.githubexample.network.ApiService;
import com.mario.githubexample.network.auth.LoginApi;
import com.mario.githubexample.util.Constants;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mario on 10/06/18.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private SharedPreferencesHelper sharedPreferencesHelper;
    private LoginApi loginApi = ApiService.createService(LoginApi.class);
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    // TODO: Should apply ProGuard to stop from being decompiled
    private static final String CLIENT_ID = "294abcb2a3176949e4a6";
    private static final String CLIENT_SECRET = "95116070ba82b7c4417ad093cae440497fbb1277";
    private static final String REDIRECT_URI = "https://github.com/example";

    @Inject
    LoginPresenter() {
    }

    @Override
    public void onDestroy() {
        view = null;
        compositeDisposable.clear();
    }

    @Override
    public void onResume() {
        if (sharedPreferencesHelper.isUserExisting()) {
            if (view != null) {
                view.goToSearchScreen();
            }
        } else {
            authenticateUser();
        }
    }

    @Override
    public void onPause() {

    }

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
        sharedPreferencesHelper = new SharedPreferencesHelper(view.getContext());
    }

    @Override
    public void onLoginClicked() {
        final String authUrl = Constants.GITHUB_URL + "login/oauth/authorize" + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI;
        if (view != null) {
            view.showAuthorizeGitHub(authUrl);
        }
    }

    private void authenticateUser() {
        final Uri uri = view.getDataFromUriIntent();
        if (uri != null && uri.toString().startsWith(REDIRECT_URI)) {
            // use the parameter your API exposes for the code (mostly it's "code")
            final String code = uri.getQueryParameter("code");
            if (code != null) {
                view.showDialog(R.string.loading, false);
                // get access token
                compositeDisposable.add(loginApi.getAccessToken(CLIENT_ID, CLIENT_SECRET, code)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(response -> {
                            sharedPreferencesHelper.storeToken(response.getAccessToken());
                            if (view != null) {
                                view.dismissDialog();
                                view.goToSearchScreen();
                            }
                        }, throwable -> {
                            view.dismissDialog();
                            view.toast(throwable.getMessage());
                        }));

            } else if (uri.getQueryParameter("error") != null) {
                view.dismissDialog();
                view.toast(R.string.authorization_failed);
            }
        }
    }
}
