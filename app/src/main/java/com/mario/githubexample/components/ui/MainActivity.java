package com.mario.githubexample.components.ui;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseActivity;
import com.mario.githubexample.components.base.BaseFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainFragment mainFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    protected BaseFragment getFragment() {
        return mainFragment;
    }
}
