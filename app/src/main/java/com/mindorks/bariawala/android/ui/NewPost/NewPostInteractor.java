package com.mindorks.bariawala.android.ui.NewPost;

import com.mindorks.bariawala.android.data.network.ApiHelper;
import com.mindorks.bariawala.android.data.prefs.PreferencesHelper;
import com.mindorks.bariawala.android.ui.base.BaseInteractor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public class NewPostInteractor extends BaseInteractor implements NewPostMvpInteractor {
    @Inject
    public NewPostInteractor(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        super(preferencesHelper, apiHelper);
    }

    @Override
    public List<String> initViewData() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Rent an floor");
        data.add("Rent flat");
        data.add("Rent single room");
        data.add("Rent double room");
        data.add("Rent single sit");
        data.add("Rent double sit");
        data.add("Rent multiple sit");
        data.add("Rent space");
        data.add("Rent shop");
        data.add("Other");
        return data;
    }
}
