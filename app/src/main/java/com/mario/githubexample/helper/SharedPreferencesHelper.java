package com.mario.githubexample.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    private static final String GITHUB_EXAMPLE_SHARED_PREF_KEY = "githubExampleSharedPrefKey";
    private static final String SORT_TYPE_KEY = "sortTypeKey";

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
}
