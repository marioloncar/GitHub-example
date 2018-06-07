package com.mario.githubexample.components.ui.userdetails;

import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class UserDetailsModule {

    @ActivityScoped
    @Binds
    abstract UserDetailsContract.Presenter provideUserDetailsPresenter(UserDetailsPresenter userDetailsPresenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract UserDetailsFragment userDetailsFragment();
}