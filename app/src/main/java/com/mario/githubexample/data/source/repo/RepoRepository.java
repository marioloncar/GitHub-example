package com.mario.githubexample.data.source.repo;

import com.mario.githubexample.data.prefs.SharedPreferencesHelper;

public class RepoRepository {
    private final RepoRemoteDataSource repoRemoteDataSource;

    public RepoRepository(SharedPreferencesHelper sharedPreferencesHelper) {
        this.repoRemoteDataSource = new RepoRemoteDataSource(sharedPreferencesHelper);
    }

    public RepoRemoteDataSource getRepoRemoteDataSource() {
        return repoRemoteDataSource;
    }
}
