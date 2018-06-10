package com.mario.githubexample.components.ui.userdetails;

import android.util.Log;

import com.mario.githubexample.R;
import com.mario.githubexample.data.model.user.User;
import com.mario.githubexample.data.source.user.UserRepository;
import com.mario.githubexample.helper.SharedPreferencesHelper;
import com.mario.githubexample.util.Utils;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserDetailsPresenter implements UserDetailsContract.Presenter {

    private UserDetailsContract.View view;
    private UserRepository userRepository;
    private Disposable userDisposable;

    @Inject
    UserDetailsPresenter() {
    }

    @Override
    public void onDestroy() {
        view = null;
        if (userDisposable != null) {
            userDisposable.dispose();
        }
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
        userRepository.getUserRemoteDataSource().getCurrentUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (userDisposable != null) {
                            userDisposable.dispose();
                        }

                        if (!Utils.isConnected(view.getContext())) {
                            d.dispose();
                            view.toast(R.string.no_internet_connection);
                        } else {
                            userDisposable = d;
                        }
                    }

                    @Override
                    public void onSuccess(User user) {
                        view.dismissDialog();
                        if (view != null) {
                            if (user != null) {
                                view.showUserDetails(user);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.dismissDialog();
                        Log.i(getClass().getSimpleName(), "onError: ", e);
                    }
                });
    }
}
