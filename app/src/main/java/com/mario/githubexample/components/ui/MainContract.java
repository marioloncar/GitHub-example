package com.mario.githubexample.components.ui;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;

interface MainContract {
    interface Presenter extends BasePresenter<View> {

    }

    interface View extends BaseDialogView<Presenter> {

    }
}
