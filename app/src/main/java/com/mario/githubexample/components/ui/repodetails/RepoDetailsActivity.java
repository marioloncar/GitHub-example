package com.mario.githubexample.components.ui.repodetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
