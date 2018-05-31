package com.mindorks.bariawala.android.ui.FeedDetails;


import com.mindorks.bariawala.android.di.PerActivity;
import com.mindorks.bariawala.android.ui.base.MvpPresenter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.ui.model.FeedMapModel;

import java.util.List;

/**
 * Created by Faizul Haque Nayan on 18/03/15.
 */
@PerActivity
public interface FeedDetailsMvpPresenter<V extends FeedDetailsMvpView, I extends FeedDetailsMvpInteractor>
        extends MvpPresenter<V, I> {

    List<FeedCardData> getSuggsentionList();

    List<FeedMapModel> getMapInfo();

    void onMapClick();

}
