package com.mindorks.bariawala.android.ui.deshboard.FeedFragment;


import com.mindorks.bariawala.android.ui.base.MvpView;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

/**
 * Created by Faizul Haque Nayan on 18/03/15.
 */

public interface FeedsMvpView extends MvpView {

    void goToFeedDetails(FeedCardData feedCardData);
}
