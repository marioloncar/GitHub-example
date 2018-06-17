package com.mario.githubexample.components.ui.search;

import com.mario.githubexample.components.base.BaseDialogView;
import com.mario.githubexample.components.base.BasePresenter;
import com.mario.githubexample.data.model.repo.Items;
import com.mario.githubexample.data.model.repo.Owner;

import java.util.List;

/**
 * Created by mario on 06/06/18.
 */

interface SearchContract {
    interface Presenter extends BasePresenter<View> {
        void searchRepositories(String keyword);

        void onSortTypeOptionSelected(String sortType);

        void onUserDetailsClicked();

        void onRepoOwnerClicked(int position);

        void onRepoClicked(int position);
    }

    interface View extends BaseDialogView<Presenter> {
        void showSearchResults(List<Items> items);

        void showNoResults();

        void showCurrentUserDetails();

        void startRepoOwnerDetails(Owner owner);

        void startRepoDetails(Items items);
    }
}
