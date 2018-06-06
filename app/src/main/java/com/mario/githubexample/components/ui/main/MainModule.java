package com.mario.githubexample.components.ui.main;

import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mario on 06/06/18.
 */

@Module
public abstract class MainModule {

    @ActivityScoped
    @Binds
    abstract MainContract.Presenter provideMainPresenter(MainPresenter mainPresenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainFragment mainFragment();

}
