package com.mario.githubexample.components.ui.browserdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseActivity;
import com.mario.githubexample.components.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by mario on 07/06/18.
 */

public class BrowserDetailsActivity extends BaseActivity {

    @Inject
    BrowserDetailsFragment browserDetailsFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    protected BaseFragment getFragment() {
        return browserDetailsFragment;
    }

    @Override
    public void onBackPressed() {
        if (browserDetailsFragment.webView.canGoBack()) {
            browserDetailsFragment.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
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
