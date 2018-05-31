package com.mindorks.bariawala.android.ui.deshboard.SavedFragment;

import com.mindorks.bariawala.android.ui.base.MvpInteractor;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.ArrayList;

/**
 * Created by Faizul Haque Nayan on 18/03/19.
 */

public interface SavedMvpInteractor extends MvpInteractor {

    ArrayList<FeedCardData> getSavedDataList();
}
