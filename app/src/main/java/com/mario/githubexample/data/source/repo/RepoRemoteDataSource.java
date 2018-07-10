package com.mario.githubexample.data.source.repo;

import android.support.annotation.Nullable;

import com.mario.githubexample.data.model.repo.GithubRepo;
import com.mario.githubexample.data.prefs.SharedPreferencesHelper;
import com.mario.githubexample.data.network.ApiHelper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RepoRemoteDataSource {
    private SharedPreferencesHelper sharedPreferencesHelper;
    private RepoApi repoApi;

    public RepoRemoteDataSource(SharedPreferencesHelper sharedPreferencesHelper) {
        this.sharedPreferencesHelper = sharedPreferencesHelper;
        repoApi = ApiHelper.createService(RepoApi.class, sharedPreferencesHelper.getToken());
    }

    public Observable<GithubRepo> searchRepositories(String keyword) {
        return repoApi.searchRepositories(keyword, sharedPreferencesHelper.getSortType());
    }

    interface RepoApi {
        @GET("search/repositories")
        Observable<GithubRepo> searchRepositories(@Query("q") String keyword,
                                                  @Nullable @Query("sort") String sortType);
    }
}
