package com.mario.githubexample.components.ui.repodetails;

import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mario on 08/06/18.
 */

@Module
public abstract class RepoDetailsModule {

    @ActivityScoped
    @Binds
    abstract RepoDetailsContract.Presenter provideRepoDetailsPresenter(RepoDetailsPresenter repoDetailsPresenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract RepoDetailsFragment repoDetailsFragment();

}