package com.mario.githubexample.components.ui.search;

import com.mario.githubexample.R;
import com.mario.githubexample.components.ui.base.BaseActivity;
import com.mario.githubexample.components.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by mario on 06/06/18.
 */

public class SearchActivity extends BaseActivity {

    @Inject
    SearchFragment searchFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    protected BaseFragment getFragment() {
        return searchFragment;
    }

    @Override
    protected boolean isDisplayHomeAsUpEnabled() {
        return false;
    }
}
