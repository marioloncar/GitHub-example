package com.mario.githubexample.components.ui.main;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;
import com.mario.githubexample.data.model.repo.Items;

import java.util.List;

import io.reactivex.ObservableSource;

/**
 * Created by mario on 06/06/18.
 */

interface MainContract {
    interface Presenter extends BasePresenter<View> {
        void searchRepositories(String keyword);
    }

    interface View extends BaseDialogView<Presenter> {
        void showSearchResults(List<Items> items);
        void showNoResults();
    }
}
