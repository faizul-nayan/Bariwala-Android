package com.mindorks.bariawala.android.ui.deshboard.SavedFragment;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.data.network.ApiHelper;
import com.mindorks.bariawala.android.data.prefs.PreferencesHelper;
import com.mindorks.bariawala.android.ui.base.BaseInteractor;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Faizul Haque Nayan on 18/03/19.
 */

public class SavedInteractor extends BaseInteractor implements SavedMvpInteractor {
    @Inject
    public SavedInteractor(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        super(preferencesHelper, apiHelper);
    }

    @Override
    public ArrayList<FeedCardData> getSavedDataList() {
        ArrayList<FeedCardData> dataList = new ArrayList<>();

        for(int i = 0; i <5; i++){
            FeedCardData data = new FeedCardData();
            data.setTitle("2520 stf 3 bed apartment sale");
            data.setLocation("Uttara");
            data.setPrice(13000);
            data.setTime("8 Mar 09:30 PM");
            data.setPhotoId(R.mipmap.test_room);
            dataList.add(data);
        }

        return dataList;
    }
}
