package com.mario.githubexample.components.ui.ownerdetails;

import com.mario.githubexample.R;
import com.mario.githubexample.components.ui.base.BaseActivity;
import com.mario.githubexample.components.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by mario on 07/06/18.
 */

public class OwnerDetailsActivity extends BaseActivity {

    @Inject
    OwnerDetailsFragment userDetailsFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    protected BaseFragment getFragment() {
        return userDetailsFragment;
    }
}
