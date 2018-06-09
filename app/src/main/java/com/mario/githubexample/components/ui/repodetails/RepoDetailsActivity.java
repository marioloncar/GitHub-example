package com.mario.githubexample.components.ui.repodetails;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseActivity;
import com.mario.githubexample.components.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by mario on 08/06/18.
 */

public class RepoDetailsActivity extends BaseActivity {

    @Inject
    RepoDetailsFragment repoDetailsFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    protected BaseFragment getFragment() {
        return repoDetailsFragment;
    }
}
