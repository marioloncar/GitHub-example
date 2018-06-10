package com.mario.githubexample.components.ui.ownerdetails;

import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class OwnerDetailsModule {

    @ActivityScoped
    @Binds
    abstract OwnerDetailsContract.Presenter provideOwnerDetailsPresenter(OwnerDetailsPresenter ownerDetailsPresenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract OwnerDetailsFragment ownerDetailsFragment();
}