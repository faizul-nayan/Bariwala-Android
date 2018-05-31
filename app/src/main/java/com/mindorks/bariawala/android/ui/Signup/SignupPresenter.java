package com.mindorks.bariawala.android.ui.Signup;

import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Faizul Haque Nayan on 18/03/22.
 */

public class SignupPresenter<V extends SignupMvpView, I extends SignupMvpInteractor>
        extends BasePresenter<V,I> implements SignupMvpPresenter<V,I>{

    @Inject
    public SignupPresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

}
