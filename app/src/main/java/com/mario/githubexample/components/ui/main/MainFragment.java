package com.mario.githubexample.components.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.mario.githubexample.R;
import com.mario.githubexample.components.base.BaseDialogFragment;
import com.mario.githubexample.components.di.ActivityScoped;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by mario on 06/06/18.
 */

@ActivityScoped
public class MainFragment extends BaseDialogFragment<MainContract.Presenter> implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @Inject
    public MainFragment() {
    }

    @BindView(R.id.edittext_search)
    EditText editTextSearch;
    @BindView(R.id.recyclerview_search_results)
    RecyclerView recyclerViewResults;

    @Override
    protected MainContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.setView(this);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.options_item_filter, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_filter:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
