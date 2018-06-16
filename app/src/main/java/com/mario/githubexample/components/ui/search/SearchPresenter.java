package com.mario.githubexample.components.ui.search;

import com.mario.githubexample.data.model.repo.GithubRepo;
import com.mario.githubexample.data.source.repo.RepoRepository;
import com.mario.githubexample.helper.SharedPreferencesHelper;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mario on 06/06/18.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View view;
    private RepoRepository repoRepository;
    private SharedPreferencesHelper sharedPreferencesHelper;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    SearchPresenter() {
    }

    @Override
    public void onDestroy() {
        view = null;
        compositeDisposable.clear();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void setView(SearchContract.View view) {
        this.view = view;
        sharedPreferencesHelper = new SharedPreferencesHelper(view.getContext());
        repoRepository = new RepoRepository(sharedPreferencesHelper);
    }

    @Override
    public void searchRepositories(String keyword) {
        compositeDisposable.add(repoRepository.getRepoRemoteDataSource().searchRepositories(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(GithubRepo::getItems)
                .subscribe(items -> {
                    if (view != null) {
                        if (items.isEmpty()) {
                            view.showNoResults();
                        } else {
                            view.showSearchResults(items);
                        }
                    }
                }, throwable -> {
                    view.toast(throwable.getMessage());
                })
        );
    }

    @Override
    public void onSortTypeOptionSelected(String sortType) {
        sharedPreferencesHelper.setSortType(sortType);
    }

    @Override
    public void onUserDetailsClicked() {
        if (view != null) {
            view.showCurrentUserDetails();
        }
    }
}
