/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mindorks.bariawala.android.ui.about;

import com.mindorks.bariawala.android.ui.base.BasePresenter;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

public class AboutPresenter<V extends AboutMvpView,
        I extends AboutMvpInteractor> extends BasePresenter<V, I>
        implements AboutMvpPresenter<V, I> {

    @Inject
    public AboutPresenter(I mvpInteractor,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }
}
