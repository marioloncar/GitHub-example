package com.mario.githubexample.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    private static final String GITHUB_EXAMPLE_SHARED_PREF_KEY = "githubExampleSharedPrefKey";
    private static final String SORT_TYPE_KEY = "sortTypeKey";
    private static final String AUTH_TOKEN_KEY = "authTokenKey";

    private final Context context;

    public SharedPreferencesHelper(Context context) {
        this.context = context;
    }

    public SharedPreferences.Editor editor() {
        return context.getSharedPreferences(GITHUB_EXAMPLE_SHARED_PREF_KEY, Context.MODE_PRIVATE).edit();
    }

    public SharedPreferences preferences() {
        return context.getSharedPreferences(GITHUB_EXAMPLE_SHARED_PREF_KEY, Context.MODE_PRIVATE);
    }


    public void setSortType(String sortType) {
        editor().putString(SORT_TYPE_KEY, sortType).commit();
    }

    public String getSortType() {
        return preferences().getString(SORT_TYPE_KEY, null);
    }

    public String getToken() {
        final String token = preferences().getString(AUTH_TOKEN_KEY, "");
        if (token.isEmpty()) {
            return null;
        }
        return token;
    }

    public void storeToken(String authToken) {
        editor().putString(AUTH_TOKEN_KEY, authToken).commit();
    }

    public boolean isUserExisting() {
        return getToken() != null;
    }

    public void clearUser() {
        editor().remove(AUTH_TOKEN_KEY).commit();
    }

}
