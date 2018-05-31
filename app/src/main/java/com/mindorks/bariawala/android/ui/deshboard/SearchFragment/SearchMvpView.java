package com.mindorks.bariawala.android.ui.deshboard.SearchFragment;

import com.mindorks.bariawala.android.ui.base.MvpView;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public interface SearchMvpView extends MvpView{

    void viewItemClick(FeedCardData feedCardData);
}
