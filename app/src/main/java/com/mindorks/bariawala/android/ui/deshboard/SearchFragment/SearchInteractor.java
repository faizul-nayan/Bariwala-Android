package com.mindorks.bariawala.android.ui.deshboard.SearchFragment;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.data.network.ApiHelper;
import com.mindorks.bariawala.android.data.prefs.PreferencesHelper;
import com.mindorks.bariawala.android.ui.base.BaseInteractor;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public class SearchInteractor extends BaseInteractor implements SearchMvpInteractor {

    @Inject
    public SearchInteractor(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        super(preferencesHelper, apiHelper);
    }

    @Override
    public List<FeedCardData> getFeedCardData() {
        List<FeedCardData> data = new ArrayList<>();

        for (int i = 0; i <10; i++){
            FeedCardData feedCardData = new FeedCardData();
            feedCardData.setPhotoId(R.mipmap.test_room);
            feedCardData.setTitle("Be where the future, Singlex@Airport");
            feedCardData.setPrice(3300);
            feedCardData.setLocation("Airport");
            feedCardData.setTime("3 hrs");
            data.add(feedCardData);
        }

        return data;
    }
}
