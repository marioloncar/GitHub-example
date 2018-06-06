package com.mario.githubexample.components.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mario.githubexample.R;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by mario on 06/06/18.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity {

    protected abstract int getLayoutId();

    protected abstract BaseFragment getFragment();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        ButterKnife.bind(this);

        if (savedInstanceState == null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, getFragment())
                    .commit();
        }
    }
}
