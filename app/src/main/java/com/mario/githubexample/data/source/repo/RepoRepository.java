package com.mario.githubexample.data.source.repo;

public class RepoRepository {
    private final RepoRemoteDataSource repoRemoteDataSource;

    public RepoRepository() {
        this.repoRemoteDataSource = new RepoRemoteDataSource();
    }

    public RepoRemoteDataSource getRepoRemoteDataSource() {
        return repoRemoteDataSource;
    }
}
