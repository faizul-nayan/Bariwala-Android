package com.mindorks.bariawala.android.ui.deshboard.SearchFragment;

import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public class SearchPresenter<V extends SearchMvpView, I extends SearchMvpInteractor>
        extends BasePresenter<V,I> implements SearchMvpPresenter<V, I> {


    @Inject
    public SearchPresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public List<FeedCardData> getFeedData() {
        return getInteractor().getFeedCardData();
    }

    @Override
    public void onClick(FeedCardData feedCardData) {
        getMvpView().viewItemClick(feedCardData);
    }
}
