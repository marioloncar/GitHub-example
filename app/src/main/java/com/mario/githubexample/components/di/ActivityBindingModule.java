package com.mario.githubexample.components.di;

import com.mario.githubexample.components.ui.MainActivity;
import com.mario.githubexample.components.ui.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mario on 06/06/18.
 */

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
