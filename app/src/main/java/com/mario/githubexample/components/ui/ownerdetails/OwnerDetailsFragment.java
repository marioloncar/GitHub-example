package com.mario.githubexample.components.ui.ownerdetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.mario.githubexample.R;
import com.mario.githubexample.components.ui.base.BaseDialogFragment;
import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.data.model.repo.Owner;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.mario.githubexample.util.Constants.OWNER_EXTRA_KEY;

@ActivityScoped
public class OwnerDetailsFragment extends BaseDialogFragment<OwnerDetailsContract.Presenter> implements OwnerDetailsContract.View {

    @Inject
    OwnerDetailsContract.Presenter presenter;

    @Inject
    public OwnerDetailsFragment() {
    }

    @BindView(R.id.imageView_owner_avatar)
    ImageView imageViewAvatar;
    @BindView(R.id.textView_owner_name)
    TextView textViewName;
    @BindView(R.id.textView_owner_type)
    TextView textViewType;
    @BindView(R.id.imageView_owner_site_admin)
    ImageView imageViewSiteAdmin;

    @Override
    protected OwnerDetailsContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_owner_details;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter != null) {
            presenter.setView(this);
        }
    }

    @Override
    public Owner getOwnerExtra() {
        return getActivity().getIntent().getParcelableExtra(OWNER_EXTRA_KEY);
    }

    @Override
    public void showUserData(Owner user) {
        Picasso.with(getContext())
                .load(user.getAvatarUrl())
                .into(imageViewAvatar);

        textViewName.setText(user.getLogin());
        textViewType.setText(user.getType());

        if (user.isSiteAdmin()) {
            imageViewSiteAdmin.setImageResource(R.drawable.ic_true);
        } else {
            imageViewSiteAdmin.setImageResource(R.drawable.ic_false);
        }
    }

    @Override
    public void showUserDetailsInBrowser(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    @OnClick(R.id.fab_owner_open_in_web)
    public void onClick() {
        presenter.onOpenInBrowserClicked();
    }
}
