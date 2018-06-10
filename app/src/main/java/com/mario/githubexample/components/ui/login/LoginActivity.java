package com.mario.githubexample.components.ui.login;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseActivity;
import com.mario.githubexample.components.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by mario on 10/06/18.
 */

public class LoginActivity extends BaseActivity {

    @Inject
    LoginFragment loginFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    protected BaseFragment getFragment() {
        return loginFragment;
    }

    @Override
    protected boolean isDisplayHomeAsUpEnabled() {
        return false;
    }
}
