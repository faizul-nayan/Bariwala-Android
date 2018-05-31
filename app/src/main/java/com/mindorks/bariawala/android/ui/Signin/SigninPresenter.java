package com.mindorks.bariawala.android.ui.Signin;

import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.ui.base.MvpPresenter;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import dagger.multibindings.IntKey;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Faizul Haque Nayan on 18/03/22.
 */

public class SigninPresenter<V extends SigninMvpView, I extends SigninMvpInteractor>
        extends BasePresenter<V, I> implements SigninMvpPresenter<V, I> {

    @Inject
    public SigninPresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }
}
