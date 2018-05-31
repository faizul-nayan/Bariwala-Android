package com.mindorks.bariawala.android.ui.FeedDetails;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.data.network.ApiHelper;
import com.mindorks.bariawala.android.data.prefs.PreferencesHelper;
import com.mindorks.bariawala.android.ui.base.BaseInteractor;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.ui.model.FeedMapModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Faizul Haque Nayan on 18/03/15.
 */

public class FeedDetailsInteractor extends BaseInteractor implements FeedDetailsMvpInteractor {

    @Inject
    public FeedDetailsInteractor(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        super(preferencesHelper, apiHelper);
    }

    @Override
    public List<FeedCardData> getMemberOtherPost() {
        List<FeedCardData> dataList = new ArrayList<>();

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

    @Override
    public List<FeedMapModel> getMapData() {
        List<FeedMapModel> list = new ArrayList<>();
        FeedMapModel data1 = new FeedMapModel();
        data1.setPhotoId(R.mipmap.if_map);
        data1.setTitle("Map");
        list.add(data1);
        data1 = new FeedMapModel();
        data1.setPhotoId(R.mipmap.if_street);
        data1.setTitle("Street");
        list.add(data1);
        data1 = new FeedMapModel();
        data1.setPhotoId(R.mipmap.if_police);
        data1.setTitle("Police");
        list.add(data1);
        data1 = new FeedMapModel();
        data1.setPhotoId(R.mipmap.if_school);
        data1.setTitle("School");
        list.add(data1);
        data1 = new FeedMapModel();
        data1.setPhotoId(R.mipmap.if_bank);
        data1.setTitle("Bank");
        list.add(data1);
        data1 = new FeedMapModel();
        data1.setPhotoId(R.mipmap.if_restaurant);
        data1.setTitle("Restaurant");
        list.add(data1);
        data1 = new FeedMapModel();
        data1.setPhotoId(R.mipmap.if_shopping);
        data1.setTitle("Shopping");
        list.add(data1);
        data1 = new FeedMapModel();
        data1.setPhotoId(R.mipmap.if_hospital);
        data1.setTitle("Hospital");
        list.add(data1);
        return list;

    }
}
