package com.mindorks.bariawala.android.ui.deshboard.MoreFragment;

import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Faizul Haque Nayan on 18/03/19.
 */

public class MorePresenter<V extends MoreMvpView, I extends MoreMvpInteractor>
        extends BasePresenter<V,I> implements MoreMvpPresenter<V,I>{

    @Inject
    public MorePresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }
}
