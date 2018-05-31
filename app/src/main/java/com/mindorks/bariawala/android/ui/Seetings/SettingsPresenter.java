package com.mindorks.bariawala.android.ui.Seetings;

import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Nayan on 3/24/2018.
 */

public class SettingsPresenter<V extends SettingsMvpView, I extends SettingsMvpInteractor>
        extends BasePresenter<V,I> implements SettingsMvpPresenter<V,I>{

    @Inject
    public SettingsPresenter(I mvpInteractor, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }
}
