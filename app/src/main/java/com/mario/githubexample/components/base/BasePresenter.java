package com.mario.githubexample.components.base;

/**
 * Created by mario on 13/04/18.
 */

/**
 * Base class to help eliminate all the boilerplate code for anything that implement MvpPresenter
 *
 * @param <P> presenter
 */
public abstract class BasePresenter<P extends MvpPresenter> extends BaseFragment {

    private MvpPresenter presenter;

    /**
     * Provide presenter
     *
     * @return the current presenter for View
     */
    protected abstract P getPresenter();

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if ((presenter = getPresenter()) != null) {
            presenter.onDestroy();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onResume() {
        super.onResume();
        if ((presenter = getPresenter()) != null) {
            presenter.onResume();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onPause() {
        super.onPause();
        if ((presenter = getPresenter()) != null) {
            presenter.onPause();
        }
    }
}
