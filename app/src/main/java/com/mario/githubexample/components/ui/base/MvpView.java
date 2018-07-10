package com.mario.githubexample.components.ui.base;

import android.app.Activity;
import android.content.Context;

/**
 * Created by mario on 06/06/18.
 */

/**
 * Base view for all other views
 *
 * @param <P> Presenter of view
 */
public interface MvpView<P extends MvpPresenter> {

    Context getContext();

    Activity getActivity();
}
