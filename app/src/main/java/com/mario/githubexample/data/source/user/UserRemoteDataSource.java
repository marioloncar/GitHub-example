package com.mario.githubexample.data.source.user;

import com.mario.githubexample.data.model.user.User;
import com.mario.githubexample.data.prefs.SharedPreferencesHelper;
import com.mario.githubexample.data.network.ApiHelper;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class UserRemoteDataSource {
    private SharedPreferencesHelper sharedPreferencesHelper;
    private final UserApi userApi = ApiHelper.createService(UserApi.class);

    public UserRemoteDataSource(SharedPreferencesHelper sharedPreferencesHelper) {
        this.sharedPreferencesHelper = sharedPreferencesHelper;
    }

    public Single<User> getCurrentUser() {
        return userApi.getCurrentUser(sharedPreferencesHelper.getToken());
    }

    interface UserApi {
        @GET("user")
        Single<User> getCurrentUser(@Query("access_token") String token);
    }
}
