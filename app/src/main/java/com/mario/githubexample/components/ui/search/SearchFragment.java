package com.mario.githubexample.components.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxSearchView;
import com.mario.githubexample.R;
import com.mario.githubexample.components.adapter.BaseRecyclerViewAdapter;
import com.mario.githubexample.components.base.BaseDialogFragment;
import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.ui.ownerdetails.OwnerDetailsActivity;
import com.mario.githubexample.components.ui.repodetails.RepoDetailsActivity;
import com.mario.githubexample.components.ui.userdetails.UserDetailsActivity;
import com.mario.githubexample.data.model.repo.Items;
import com.mario.githubexample.data.model.repo.Owner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

import static com.mario.githubexample.util.Constants.ITEMS_EXTRA_KEY;
import static com.mario.githubexample.util.Constants.OWNER_EXTRA_KEY;

/**
 * Created by mario on 06/06/18.
 */

@ActivityScoped
public class SearchFragment extends BaseDialogFragment<SearchContract.Presenter> implements SearchContract.View, AdapterView.OnItemSelectedListener {

    @Inject
    SearchContract.Presenter presenter;

    @Inject
    SearchAdapter mainAdapter;

    @Inject
    public SearchFragment() {
    }

    @BindView(R.id.searchView_repository)
    SearchView searchViewRepo;
    @BindView(R.id.recyclerView_search_results)
    RecyclerView recyclerViewResults;
    @BindView(R.id.textView_no_results)
    TextView textViewNoResults;
    @BindView(R.id.spinner_sort_types)
    Spinner spinnerSortTypes;

    @Override
    protected SearchContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter != null) {
            presenter.setView(this);
        }

        setHasOptionsMenu(true);

        spinnerSortTypes.setOnItemSelectedListener(this);
        recyclerViewResults.setHasFixedSize(true);
        recyclerViewResults.setAdapter(mainAdapter);

        RxSearchView.queryTextChanges(searchViewRepo)
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<CharSequence>() {
                    @Override
                    public void onNext(CharSequence charSequence) {
                        if (charSequence.length() != 0) {
                            presenter.searchRepositories(charSequence.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.i(e.getMessage(), "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Timber.i("onComplete: ");

                    }
                });

        mainAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onViewClick(BaseRecyclerViewAdapter adapter, RecyclerView.ViewHolder viewHolder, View view, int position) {
                // Open user details
                presenter.onRepoOwnerClicked(position);

            }

            @Override
            public void onItemClick(BaseRecyclerViewAdapter adapter, RecyclerView.ViewHolder viewHolder, int position) {
                // Open repo details
                presenter.onRepoClicked(position);
            }
        });

    }

    @Override
    public void showSearchResults(List<Items> items) {
        mainAdapter.setItems(items);
        mainAdapter.notifyDataSetChanged();

        recyclerViewResults.setVisibility(View.VISIBLE);
        textViewNoResults.setVisibility(View.GONE);
    }

    @Override
    public void showNoResults() {
        recyclerViewResults.setVisibility(View.GONE);
        textViewNoResults.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCurrentUserDetails() {
        startActivity(new Intent(getActivity(), UserDetailsActivity.class));
    }

    @Override
    public void startRepoOwnerDetails(Owner owner) {
        final Intent intent = new Intent(getContext(), OwnerDetailsActivity.class);
        intent.putExtra(OWNER_EXTRA_KEY, owner);
        startActivity(intent);
    }

    @Override
    public void startRepoDetails(Items items) {
        final Intent intent = new Intent(getContext(), RepoDetailsActivity.class);
        intent.putExtra(ITEMS_EXTRA_KEY, items);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final String sortType = parent.getItemAtPosition(position).toString();
        presenter.onSortTypeOptionSelected(sortType);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        presenter.onSortTypeOptionSelected(null);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.options_menu_user, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_user:
                presenter.onUserDetailsClicked();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
