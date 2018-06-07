package com.mario.githubexample.components.ui.browserdetails;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;

/**
 * Created by mario on 07/06/18.
 */

interface BrowserDetailsContract {
    interface Presenter extends BasePresenter<View> {

    }

    interface View extends BaseDialogView<Presenter> {
        void loadWebsite(String url);
        String getUrlExtra();
    }
}
