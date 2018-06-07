package com.mario.githubexample.components.ui.browserdetails;

import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mario on 07/06/18.
 */

@Module
public abstract class BrowserDetailsModule {

    @ActivityScoped
    @Binds
    abstract BrowserDetailsContract.Presenter provideBrowserPresenter(BrowserDetailsPresenter browserDetailsPresenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract BrowserDetailsFragment browserDetailsFragment();

}