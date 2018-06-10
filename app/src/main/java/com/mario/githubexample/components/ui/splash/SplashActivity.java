package com.mario.githubexample.components.ui.splash;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mario.githubexample.components.ui.login.LoginActivity;
import com.mario.githubexample.components.ui.search.SearchActivity;

/**
 * Created by Mario on 06/06/2018.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}