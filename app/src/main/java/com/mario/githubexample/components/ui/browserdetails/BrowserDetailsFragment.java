package com.mario.githubexample.components.ui.browserdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseDialogFragment;
import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.webview.GithubWebChromeClient;
import com.mario.githubexample.components.webview.GithubWebClient;

import javax.inject.Inject;

import butterknife.BindView;

import static com.mario.githubexample.util.Constants.OWNER_EXTRA_URL_KEY;

/**
 * Created by mario on 07/06/18.
 */

@ActivityScoped
public class BrowserDetailsFragment extends BaseDialogFragment<BrowserDetailsContract.Presenter> implements BrowserDetailsContract.View {

    @Inject
    BrowserDetailsContract.Presenter presenter;

    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @Inject
    public BrowserDetailsFragment() {
    }

    @Override
    protected BrowserDetailsContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_webview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter != null) {
            presenter.setView(this);
            webView.setWebChromeClient(new GithubWebChromeClient(progressBar));
            webView.setWebViewClient(new GithubWebClient(getActivity()));
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }

    @Override
    public void onDestroy() {
        if (webView != null) {
            webView.stopLoading();
            webView.loadUrl("about:blank");
            webView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (webView != null) {
            webView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override
    public void loadWebsite(String url) {
        webView.loadUrl(url);
    }

    @Override
    public String getUrlExtra() {
        return getActivity().getIntent().getStringExtra(OWNER_EXTRA_URL_KEY);
    }
}
