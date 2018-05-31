package com.mindorks.bariawala.android.ui.deshboard.FeedFragment;



import com.mindorks.bariawala.android.di.PerActivity;
import com.mindorks.bariawala.android.ui.base.MvpPresenter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.List;

/**
 * Created by Faizul Haque Nayan on 18/03/15.
 */
@PerActivity
public interface FeedsMvpPresenter<V extends FeedsMvpView, I extends FeedsMvpInteraactor>
        extends MvpPresenter<V, I> {

    void loadFeedCard();

    List<FeedCardData> getFeedData();

    void onClick(FeedCardData feedCardData);

}
