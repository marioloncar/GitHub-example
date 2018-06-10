package com.mario.githubexample.components.ui.login;

import android.net.Uri;

import com.mario.githubexample.data.model.token.AccessToken;
import com.mario.githubexample.helper.SharedPreferencesHelper;
import com.mario.githubexample.network.ApiService;
import com.mario.githubexample.network.auth.LoginApi;
import com.mario.githubexample.util.Constants;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private SharedPreferencesHelper sharedPreferencesHelper;
    private LoginApi loginApi = ApiService.createService(LoginApi.class);

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
        Uri uri = view.getDataFromUriIntent();
        if (uri != null && uri.toString().startsWith(REDIRECT_URI)) {
            // use the parameter your API exposes for the code (mostly it's "code")
            String code = uri.getQueryParameter("code");
            if (code != null) {
                // get access token
                Call<AccessToken> call = loginApi.getAccessToken(CLIENT_ID, CLIENT_SECRET, code);
                call.enqueue(new Callback<AccessToken>() {
                    @Override
                    public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                        if (response.body() != null) {
                            sharedPreferencesHelper.storeToken(response.body().getAccessToken());
                            if (view != null) {
                                view.goToSearchScreen();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AccessToken> call, Throwable t) {
                        view.toast("Authorization failed" + t.getMessage());
                    }
                });

            } else if (uri.getQueryParameter("error") != null) {
                view.toast("Authorization failed");
            }
        }
    }
}
