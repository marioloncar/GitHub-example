package com.mario.githubexample.components.di;

import com.mario.githubexample.MvpApp;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by mario on 06/06/18.
 */

@Component(modules = {AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<MvpApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MvpApp> {
    }

}
