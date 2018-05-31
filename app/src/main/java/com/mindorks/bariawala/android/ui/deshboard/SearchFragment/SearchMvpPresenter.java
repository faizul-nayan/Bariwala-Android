package com.mindorks.bariawala.android.ui.deshboard.SearchFragment;

import com.mindorks.bariawala.android.ui.base.MvpPresenter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.List;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public interface SearchMvpPresenter<V extends SearchMvpView, I extends SearchMvpInteractor>
        extends MvpPresenter<V, I>{

    List<FeedCardData> getFeedData();
    void onClick(FeedCardData feedCardData);
}
