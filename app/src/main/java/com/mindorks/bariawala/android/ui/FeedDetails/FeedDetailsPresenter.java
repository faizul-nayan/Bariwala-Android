package com.mindorks.bariawala.android.ui.FeedDetails;

import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.ui.model.FeedMapModel;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Faizul Haque Nayan on 18/03/15.
 */

public class FeedDetailsPresenter<V extends FeedDetailsMvpView, I extends FeedDetailsMvpInteractor>
        extends BasePresenter<V, I> implements FeedDetailsMvpPresenter<V, I> {

    @Inject
    public FeedDetailsPresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public List<FeedCardData> getSuggsentionList() {
        return getInteractor().getMemberOtherPost();
    }

    @Override
    public List<FeedMapModel> getMapInfo() {
        return getInteractor().getMapData();
    }

    @Override
    public void onMapClick() {
        getMvpView().onMapClick();
    }
}
