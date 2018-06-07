package com.mario.githubexample.data.source.repo;

import com.mario.githubexample.data.model.repo.GithubRepo;
import com.mario.githubexample.data.model.repo.Items;
import com.mario.githubexample.network.ApiService;

import java.io.IOException;
import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RepoRemoteDataSource {

    private RepoApi repoApi = ApiService.getRetrofitInstance().create(RepoApi.class);

    private List<Items> searchRepositories(String keyword) {
        try {
            return repoApi.searchRepositories(keyword).execute().body().getItems();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Single<List<Items>> searchRepositoriesAsObservable(String keyword) {
        return Single.fromCallable(() -> searchRepositories(keyword));
    }


    interface RepoApi {
        @GET("search/repositories")
        Call<GithubRepo> searchRepositories(@Query("q") String keyword);
    }
}
