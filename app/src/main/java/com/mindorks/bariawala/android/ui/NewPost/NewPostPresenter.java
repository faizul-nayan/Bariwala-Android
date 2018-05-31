package com.mindorks.bariawala.android.ui.NewPost;

import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public class NewPostPresenter<V extends NewPostMvpView, I extends  NewPostMvpInteractor>
        extends BasePresenter<V,I> implements NewPostMvpPresenter<V,I>{
    @Inject
    public NewPostPresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public List<String> getInitViewData() {
        return getInteractor().initViewData();
    }
}
