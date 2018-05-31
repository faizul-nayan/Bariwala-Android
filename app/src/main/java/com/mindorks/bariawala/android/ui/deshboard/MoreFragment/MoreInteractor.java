package com.mindorks.bariawala.android.ui.deshboard.MoreFragment;

import com.mindorks.bariawala.android.data.network.ApiHelper;
import com.mindorks.bariawala.android.data.prefs.PreferencesHelper;
import com.mindorks.bariawala.android.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by Faizul Haque Nayan on 18/03/19.
 */

public class MoreInteractor extends BaseInteractor implements MoreMvpInteractor {

    @Inject
    public MoreInteractor(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        super(preferencesHelper, apiHelper);
    }
}
