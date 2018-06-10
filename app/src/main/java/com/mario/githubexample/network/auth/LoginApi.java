package com.mario.githubexample.network.auth;

import com.mario.githubexample.data.model.token.AccessToken;
import com.mario.githubexample.network.ApiService;
import com.mario.githubexample.util.Constants;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginApi {

    @FormUrlEncoded
    @Headers({"Accept: application/json"}) // Use JsonReader.setLenient(true) to accept malformed JSON -> Gson bug: https://github.com/square/retrofit/issues/1465
    @POST(Constants.GITHUB_URL + "login/oauth/access_token") // Full URL because it is different from BASE_URL
    Single<AccessToken> getAccessToken(
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("code") String code);
}