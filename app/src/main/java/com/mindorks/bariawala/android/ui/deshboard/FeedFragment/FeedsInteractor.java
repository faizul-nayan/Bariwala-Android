package com.mindorks.bariawala.android.ui.deshboard.FeedFragment;


import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.data.network.ApiHelper;
import com.mindorks.bariawala.android.data.prefs.PreferencesHelper;
import com.mindorks.bariawala.android.ui.base.BaseInteractor;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Faizul Haque Nayan on 18/03/15.
 */

public class FeedsInteractor extends BaseInteractor implements FeedsMvpInteraactor {

    @Inject
    public FeedsInteractor(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        super(preferencesHelper, apiHelper);
    }


    @Override
    public List<FeedCardData> getFeedCardData() {

        List<FeedCardData> data = new ArrayList<>();

        for (int i = 0; i <10; i++){
            FeedCardData feedCardData = new FeedCardData();
            feedCardData.setPhotoId(R.mipmap.test_room);
            feedCardData.setTitle("Be where the future, Duplex@Purbachal");
            feedCardData.setPrice(1500);
            feedCardData.setLocation("Mohammadpur");
            feedCardData.setTime("5 hrs");
            data.add(feedCardData);
        }

        return data;
    }
}
