package com.mario.githubexample.components.ui.search;

import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.di.FragmentScoped;
import com.mario.githubexample.data.source.repo.RepoRepository;
import com.mario.githubexample.helper.SharedPreferencesHelper;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mario on 06/06/18.
 */

@Module
public abstract class SearchModule {

    @ActivityScoped
    @Binds
    abstract SearchContract.Presenter provideSearchPresenter(SearchPresenter searchPresenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract SearchFragment searchFragment();
}
