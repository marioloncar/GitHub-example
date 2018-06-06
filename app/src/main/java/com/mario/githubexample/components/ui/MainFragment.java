package com.mario.githubexample.components.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseDialogFragment;
import com.mario.githubexample.components.di.ActivityScoped;

import javax.inject.Inject;

@ActivityScoped
public class MainFragment extends BaseDialogFragment<MainContract.Presenter> implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @Inject
    public MainFragment() {
    }

    @Override
    protected MainContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.setView(this);
    }
}
