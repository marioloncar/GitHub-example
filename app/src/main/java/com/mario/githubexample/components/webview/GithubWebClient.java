package com.mario.githubexample.components.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by mario on 07/06/18.
 */

public class GithubWebClient extends WebViewClient {

    private Activity activity;

    public GithubWebClient(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith("mailto:")) {
            Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse(url));
            activity.startActivity(i);
            return true;
        }

        return false;
    }
}
