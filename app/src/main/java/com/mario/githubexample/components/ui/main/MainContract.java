package com.mario.githubexample.components.ui.main;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;

/**
 * Created by mario on 06/06/18.
 */

interface MainContract {
    interface Presenter extends BasePresenter<View> {

    }

    interface View extends BaseDialogView<Presenter> {

    }
}
