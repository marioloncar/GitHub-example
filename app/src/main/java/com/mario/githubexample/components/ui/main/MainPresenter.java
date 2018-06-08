package com.mario.githubexample.components.ui.main;

import android.util.Log;

import com.mario.githubexample.data.model.repo.Items;
import com.mario.githubexample.data.source.repo.RepoRepository;
import com.mario.githubexample.util.Utils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mario on 06/06/18.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private Disposable reposDisposable;
    private RepoRepository repoRepository;


    @Inject
    MainPresenter() {
    }

    @Override
    public void onDestroy() {
        view = null;
        if (reposDisposable != null) {
            reposDisposable.dispose();
        }
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
        repoRepository = new RepoRepository();
    }

    @Override
    public void searchRepositories(String keyword) {
        repoRepository.getRepoRemoteDataSource().searchRepositoriesAsObservable(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Items>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (reposDisposable != null) {
                            reposDisposable.dispose();
                        }

                        if (!Utils.isConnected(view.getContext())) {
                            d.dispose();
                            view.toast("No internet connection");
                        } else {
                            reposDisposable = d;
                        }
                    }

                    @Override
                    public void onSuccess(List<Items> items) {
                        if (view != null) {
                            if (items.isEmpty()) {
                                view.showNoResults();
                            } else {
                                view.showSearchResults(items);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(getClass().getSimpleName(), "onError: ", e);
                    }
                });
    }
}
