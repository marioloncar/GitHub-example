package com.mario.githubexample.components.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.jakewharton.rxbinding2.widget.RxSearchView;
import com.mario.githubexample.R;
import com.mario.githubexample.components.adapter.BaseRecyclerViewAdapter;
import com.mario.githubexample.components.base.BaseDialogFragment;
import com.mario.githubexample.components.di.ActivityScoped;
import com.mario.githubexample.components.ui.userdetails.UserDetailsActivity;
import com.mario.githubexample.components.ui.userdetails.UserDetailsFragment;
import com.mario.githubexample.data.model.repo.Items;
import com.mario.githubexample.data.model.repo.Owner;
import com.mario.githubexample.util.Constants;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import static com.mario.githubexample.util.Constants.OWNER_EXTRA_KEY;

/**
 * Created by mario on 06/06/18.
 */

@ActivityScoped
public class MainFragment extends BaseDialogFragment<MainContract.Presenter> implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @Inject
    MainAdapter mainAdapter;

    @Inject
    public MainFragment() {
    }

    @BindView(R.id.searchview_repository)
    SearchView searchViewRepo;
    @BindView(R.id.recyclerview_search_results)
    RecyclerView recyclerViewResults;

    private Disposable disposable;


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
        if (presenter != null) {
            presenter.setView(this);
        }
        setHasOptionsMenu(true);
        recyclerViewResults.setHasFixedSize(true);
        recyclerViewResults.setAdapter(mainAdapter);

        RxSearchView.queryTextChanges(searchViewRepo)
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CharSequence>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(CharSequence charSequence) {
                        if (charSequence.length() != 0) {
                            presenter.searchRepositories(charSequence.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(getClass().getSimpleName(), "onError: ", e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i(getClass().getSimpleName(), "onComplete: ");

                    }
                });

        mainAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onViewClick(BaseRecyclerViewAdapter adapter, RecyclerView.ViewHolder viewHolder, View view, int position) {
                // Open user details
                final Items items = (Items) adapter.getItemAt(position);
                final Owner owner = items.getOwner();

                final Intent intent = new Intent(getContext(), UserDetailsActivity.class);
                intent.putExtra(OWNER_EXTRA_KEY, owner);
                startActivity(intent);
            }

            @Override
            public void onItemClick(BaseRecyclerViewAdapter adapter, RecyclerView.ViewHolder viewHolder, int position) {
                // Open repo details
            }
        });

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

    @Override
    public void showSearchResult(List<Items> items) {
        mainAdapter.setItems(items);
        mainAdapter.notifyDataSetChanged();
    }

}
