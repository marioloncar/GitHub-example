package com.mario.githubexample.components.ui.userdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseDialogFragment;
import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.data.model.user.User;
import com.mario.githubexample.util.Utils;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;

@ActivityScoped
public class UserDetailsFragment extends BaseDialogFragment<UserDetailsContract.Presenter> implements UserDetailsContract.View {

    @Inject
    UserDetailsContract.Presenter presenter;

    @Inject
    public UserDetailsFragment() {
    }

    @BindView(R.id.imageView_user_avatar)
    ImageView imageViewAvatar;
    @BindView(R.id.textView_user_name)
    TextView textViewName;
    @BindView(R.id.textView_user_location)
    TextView textViewLocation;
    @BindView(R.id.textView_user_email)
    TextView textViewEmail;
    @BindView(R.id.textView_user_bio)
    TextView textViewBio;
    @BindView(R.id.textView_user_followers)
    TextView textViewFollowers;
    @BindView(R.id.textView_user_public_repos)
    TextView textViewPublicRepos;
    @BindView(R.id.textView_user_created_at)
    TextView textViewCreatedAt;

    @Override
    protected UserDetailsContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_details;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter != null) {
            presenter.setView(this);
        }
    }

    @Override
    public void showUserDetails(User user) {
        Picasso.with(getContext())
                .load(user.getAvatarUrl())
                .into(imageViewAvatar);

        textViewName.setText(user.getName());
        textViewLocation.setText(user.getLocation());
        textViewEmail.setText(user.getEmail());
        textViewBio.setText(user.getBio());

        textViewFollowers.setText(String.valueOf(user.getFollowers()));
        textViewPublicRepos.setText(String.valueOf(user.getPublicRepos()));
        textViewCreatedAt.setText(Utils.convertDate(user.getCreatedAt()));
    }
}
