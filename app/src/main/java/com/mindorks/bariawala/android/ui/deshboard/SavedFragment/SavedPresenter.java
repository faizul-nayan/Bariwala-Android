package com.mindorks.bariawala.android.ui.deshboard.SavedFragment;

import android.util.Log;
import android.widget.Toast;

import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Faizul Haque Nayan on 18/03/19.
 */

public class SavedPresenter<V extends SavedMvpView, I extends SavedMvpInteractor>
        extends BasePresenter<V,I> implements SavedMvpPresenter<V,I>{

    @Inject
    public SavedPresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public ArrayList<FeedCardData> getSavedList() {
        return getInteractor().getSavedDataList();
    }

}
