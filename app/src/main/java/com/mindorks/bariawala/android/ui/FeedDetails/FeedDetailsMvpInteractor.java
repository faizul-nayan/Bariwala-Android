package com.mindorks.bariawala.android.ui.FeedDetails;


import com.mindorks.bariawala.android.ui.base.MvpInteractor;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.ui.model.FeedMapModel;

import java.util.List;

/**
 * Created by Faizul Haque Nayan on 18/03/15.
 */

public interface FeedDetailsMvpInteractor extends MvpInteractor {

    List<FeedCardData> getMemberOtherPost();
    List<FeedMapModel> getMapData();
}
