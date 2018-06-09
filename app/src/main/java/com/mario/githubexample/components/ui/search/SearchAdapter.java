package com.mario.githubexample.components.ui.search;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mario.githubexample.R;
import com.mario.githubexample.components.adapter.BaseRecyclerViewAdapter;
import com.mario.githubexample.data.model.repo.Items;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;

public class SearchAdapter extends BaseRecyclerViewAdapter<Items, BaseRecyclerViewAdapter.ItemBaseVH> {

    @Inject
    public SearchAdapter() {
    }

    @NonNull
    @Override
    public ItemBaseVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GithubRepoVH((LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false)));
    }

    class GithubRepoVH extends ItemBaseVH {
        @BindView(R.id.imageView_thumb)
        ImageView imageViewThumb;
        @BindView(R.id.textView_repo_name)
        TextView textViewRepoName;
        @BindView(R.id.textView_author_name)
        TextView textViewAuthorName;
        @BindView(R.id.textView_watchers)
        TextView textViewWatchers;
        @BindView(R.id.textView_forks)
        TextView textViewForks;
        @BindView(R.id.textView_issues)
        TextView textViewIssues;

        public GithubRepoVH(View itemView) {
            super(itemView);
            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onItemClick(SearchAdapter.this, GithubRepoVH.this, getAdapterPosition());
                }
            });

            imageViewThumb.setOnClickListener(v -> {
                if (listener != null){
                    listener.onViewClick(SearchAdapter.this, GithubRepoVH.this, imageViewThumb, getAdapterPosition());
                }
            });
        }

        @Override
        protected void performBinding(Items item) {
            final String avatarUrl = item.getOwner().getAvatarUrl();
            final String repoName = item.getName();
            final String authorName = item.getOwner().getLogin();
            final int watchersCount = item.getWatchersCount();
            final int forksCount = item.getForksCount();
            final int issuesCount = item.getOpenIssuesCount();

            Picasso.with(itemView.getContext())
                    .load(avatarUrl)
                    .into(imageViewThumb);

            textViewRepoName.setText(repoName);
            textViewAuthorName.setText(authorName);
            textViewWatchers.setText(String.valueOf(watchersCount));
            textViewForks.setText(String.valueOf(forksCount));
            textViewIssues.setText(String.valueOf(issuesCount));
        }
    }
}
