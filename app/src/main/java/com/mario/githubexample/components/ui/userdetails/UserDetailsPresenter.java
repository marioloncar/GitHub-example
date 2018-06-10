package com.mario.githubexample.components.ui.userdetails;

import com.mario.githubexample.R;
import com.mario.githubexample.data.source.user.UserRepository;
import com.mario.githubexample.helper.SharedPreferencesHelper;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mario on 10/06/18.
 */

public class UserDetailsPresenter implements UserDetailsContract.Presenter {

    private UserDetailsContract.View view;
    private UserRepository userRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    UserDetailsPresenter() {
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
    public void setView(UserDetailsContract.View view) {
        this.view = view;
        final SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(view.getContext());
        userRepository = new UserRepository(sharedPreferencesHelper);
        getUserDetails();
    }

    private void getUserDetails() {
        view.showDialog(R.string.loading, true);
        compositeDisposable.add(userRepository.getUserRemoteDataSource().getCurrentUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    if (view != null) {
                        view.dismissDialog();
                        view.showUserDetails(user);
                    }
                }, throwable -> {
                    view.dismissDialog();
                    view.toast(throwable.getMessage());
                }));
    }
}
