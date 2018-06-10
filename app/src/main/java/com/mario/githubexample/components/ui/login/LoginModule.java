package com.mario.githubexample.components.ui.login;

import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


/**
 * Created by mario on 10/06/18.
 */

@Module
public abstract class LoginModule {

    @ActivityScoped
    @Binds
    abstract LoginContract.Presenter provideLoginPresenter(LoginPresenter presenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();

}

