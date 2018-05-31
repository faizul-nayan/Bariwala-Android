package com.mindorks.bariawala.android.ui.deshboard.FeedFragment;


import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Faizul Haque Nayan on 18/03/15.
 */

public class FeedsPresenter<V extends FeedsMvpView, I extends FeedsMvpInteraactor>
        extends BasePresenter<V, I> implements FeedsMvpPresenter<V, I> {

    private List<FeedCardData> mFeedCardDataList;

    @Inject
    public FeedsPresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
        mFeedCardDataList = new ArrayList<>();
    }


    @Override
    public void loadFeedCard() {
        mFeedCardDataList = getInteractor().getFeedCardData();
    }

    @Override
    public List<FeedCardData> getFeedData() {
        return mFeedCardDataList;
    }

    @Override
    public void onClick(FeedCardData feedCardData) {
        getMvpView().goToFeedDetails(feedCardData);
    }


}
