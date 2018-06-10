package com.mario.githubexample.components.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseDialogFragment;
import com.mario.githubexample.components.ui.search.SearchActivity;

import javax.inject.Inject;

import butterknife.OnClick;

public class LoginFragment extends BaseDialogFragment<LoginContract.Presenter> implements LoginContract.View {

    @Inject
    LoginContract.Presenter presenter;

    @Inject
    public LoginFragment() {
    }

    @Override
    protected LoginContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter != null) {
            presenter.setView(this);
        }
    }

    @OnClick(R.id.button_login_with_github)
    public void onClick() {
        presenter.onLoginClicked();
    }

    @Override
    public void showAuthorizeGitHub(String authUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl));
        startActivity(intent);
    }

    @Override
    public Uri getDataFromUriIntent() {
        return getActivity().getIntent().getData();
    }

    @Override
    public void goToSearchScreen() {
        startActivity(new Intent(getActivity(), SearchActivity.class));
        getActivity().finish();
    }
}
