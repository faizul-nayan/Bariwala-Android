package com.mindorks.bariawala.android.ui.deshboard.SearchFragment;

import com.mindorks.bariawala.android.ui.base.MvpInteractor;
import com.mindorks.bariawala.android.ui.deshboard.FeedFragment.FeedsMvpInteraactor;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.List;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public interface SearchMvpInteractor extends MvpInteractor, FeedsMvpInteraactor {

    List<FeedCardData> getFeedCardData();
}
