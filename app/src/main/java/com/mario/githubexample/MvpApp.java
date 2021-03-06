package com.mario.githubexample;

import com.mario.githubexample.components.di.DaggerAppComponent;

import net.danlew.android.joda.JodaTimeAndroid;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MvpApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }

    @Override
    protected AndroidInjector<? extends MvpApp> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
