package com.mario.githubexample.data.source.user;

import com.mario.githubexample.helper.SharedPreferencesHelper;

public class UserRepository {
    private final UserRemoteDataSource userRemoteDataSource;

    public UserRepository(SharedPreferencesHelper sharedPreferencesHelper) {
        this.userRemoteDataSource = new UserRemoteDataSource(sharedPreferencesHelper);
    }

    public UserRemoteDataSource getUserRemoteDataSource() {
        return userRemoteDataSource;
    }
}
