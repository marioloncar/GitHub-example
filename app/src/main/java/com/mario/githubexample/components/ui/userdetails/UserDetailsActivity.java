package com.mario.githubexample.components.ui.userdetails;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseActivity;
import com.mario.githubexample.components.base.BaseFragment;

import javax.inject.Inject;

public class UserDetailsActivity extends BaseActivity {

    @Inject
    UserDetailsFragment userDetailsFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    protected BaseFragment getFragment() {
        return userDetailsFragment;
    }
}
