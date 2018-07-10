package com.mario.githubexample.components.ui.search;

import com.mario.githubexample.components.base.MvpDialogView;
import com.mario.githubexample.components.base.MvpPresenter;
import com.mario.githubexample.data.model.repo.Items;
import com.mario.githubexample.data.model.repo.Owner;

import java.util.List;

/**
 * Created by mario on 06/06/18.
 */

interface SearchContract {
    interface Presenter extends MvpPresenter<View> {
        void searchRepositories(String keyword);

        void onSortTypeOptionSelected(String sortType);

        void onUserDetailsClicked();

        void onRepoOwnerClicked(int position);

        void onRepoClicked(int position);
    }

    interface View extends MvpDialogView<Presenter> {
        void showSearchResults(List<Items> items);

        void showNoResults();

        void showCurrentUserDetails();

        void startRepoOwnerDetails(Owner owner);

        void startRepoDetails(Items items);
    }
}
