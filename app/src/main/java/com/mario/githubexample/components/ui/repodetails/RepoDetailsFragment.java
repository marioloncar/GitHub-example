package com.mario.githubexample.components.ui.repodetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseDialogFragment;
import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.ui.userdetails.UserDetailsActivity;
import com.mario.githubexample.data.model.repo.Items;
import com.mario.githubexample.data.model.repo.Owner;
import com.mario.githubexample.util.Utils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.mario.githubexample.util.Constants.ITEMS_EXTRA_KEY;
import static com.mario.githubexample.util.Constants.OWNER_EXTRA_KEY;

/**
 * Created by mario on 08/06/18.
 */

@ActivityScoped
public class RepoDetailsFragment extends BaseDialogFragment<RepoDetailsContract.Presenter> implements RepoDetailsContract.View {

    @Inject
    RepoDetailsContract.Presenter presenter;

    @Inject
    public RepoDetailsFragment() {
    }

    @BindView(R.id.textView_repo_full_name)
    TextView textViewFullName;
    @BindView(R.id.textView_repo_description)
    TextView textViewDescription;
    @BindView(R.id.textView_repo_language)
    TextView textViewLanguage;
    @BindView(R.id.textView_repo_created)
    TextView textViewCreated;
    @BindView(R.id.textView_repo_last_update)
    TextView textViewUpdated;
    @BindView(R.id.textView_repo_forks)
    TextView textViewForks;
    @BindView(R.id.textView_repo_watchers)
    TextView textViewWatchers;
    @BindView(R.id.textView_repo_issues)
    TextView textViewIssues;
    @BindView(R.id.imageView_repo_private)
    ImageView imageViewPrivate;
    @BindView(R.id.imageView_repo_archived)
    ImageView imageViewArchived;
    @BindView(R.id.imageView_repo_fork)
    ImageView imageViewFork;

    @Override
    protected RepoDetailsContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_repo_details;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter != null) {
            presenter.setView(this);
        }
    }

    @Override
    public Items getItemsExtra() {
        return getActivity().getIntent().getParcelableExtra(ITEMS_EXTRA_KEY);
    }

    @Override
    public void showRepoDetails(Items items) {
        textViewFullName.setText(items.getFullName());
        textViewDescription.setText(items.getDescription());
        textViewWatchers.setText(String.valueOf(items.getWatchersCount()));
        textViewForks.setText(String.valueOf(items.getForksCount()));
        textViewIssues.setText(String.valueOf(items.getOpenIssuesCount()));
        textViewLanguage.setText(items.getLanguage());
        textViewUpdated.setText(Utils.convertDate(items.getUpdatedAt()));
        textViewCreated.setText(Utils.convertDate(items.getCreatedAt()));


        if (items.isFork()) {
            imageViewFork.setImageResource(R.drawable.ic_true);
        } else {
            imageViewFork.setImageResource(R.drawable.ic_false);
        }

        if (items.isArchived()) {
            imageViewArchived.setImageResource(R.drawable.ic_true);
        } else {
            imageViewArchived.setImageResource(R.drawable.ic_false);
        }

        if (items.isPrivateRepo()) {
            imageViewPrivate.setImageResource(R.drawable.ic_true);
        } else {
            imageViewPrivate.setImageResource(R.drawable.ic_false);
        }

    }

    @Override
    public void showRepoDetailsInBrowser(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    @Override
    public void showOwnerDetails(Owner owner) {
        final Intent intent = new Intent(getContext(), UserDetailsActivity.class);
        intent.putExtra(OWNER_EXTRA_KEY, owner);
        startActivity(intent);
    }

    @OnClick({R.id.button_repo_open_in_browser, R.id.button_repo_show_owner_details})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_repo_open_in_browser:
                presenter.onOpenInBrowserClicked();
                break;
            case R.id.button_repo_show_owner_details:
                presenter.onShowOwnerDetailsClicked();
                break;
        }
    }
}
