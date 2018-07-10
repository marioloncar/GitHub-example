package com.mario.githubexample.components.ui.login;

import android.net.Uri;

import com.mario.githubexample.R;
import com.mario.githubexample.data.prefs.SharedPreferencesHelper;
import com.mario.githubexample.data.network.ApiHelper;
import com.mario.githubexample.auth.LoginApi;
import com.mario.githubexample.util.Constants;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.mario.githubexample.Keys.CLIENT_ID;
import static com.mario.githubexample.Keys.CLIENT_SECRET;
import static com.mario.githubexample.Keys.REDIRECT_URI;

/**
 * Created by mario on 10/06/18.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private SharedPreferencesHelper sharedPreferencesHelper;
    private LoginApi loginApi = ApiHelper.createService(LoginApi.class);
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

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
