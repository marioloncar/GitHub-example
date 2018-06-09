package com.mario.githubexample.components.di;

import com.mario.githubexample.components.ui.search.SearchActivity;
import com.mario.githubexample.components.ui.search.SearchModule;
import com.mario.githubexample.components.ui.repodetails.RepoDetailsActivity;
import com.mario.githubexample.components.ui.repodetails.RepoDetailsModule;
import com.mario.githubexample.components.ui.userdetails.UserDetailsActivity;
import com.mario.githubexample.components.ui.userdetails.UserDetailsModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mario on 06/06/18.
 */

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = SearchModule.class)
    abstract SearchActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = UserDetailsModule.class)
    abstract UserDetailsActivity userDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = RepoDetailsModule.class)
    abstract RepoDetailsActivity repoDetailsActivity();
}
