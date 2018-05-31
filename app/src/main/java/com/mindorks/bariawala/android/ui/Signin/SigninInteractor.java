package com.mindorks.bariawala.android.ui.Signin;

import com.mindorks.bariawala.android.data.network.ApiHelper;
import com.mindorks.bariawala.android.data.prefs.PreferencesHelper;
import com.mindorks.bariawala.android.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by Faizul Haque Nayan on 18/03/22.
 */

public class SigninInteractor extends BaseInteractor implements SigninMvpInteractor {
    @Inject
    public SigninInteractor(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        super(preferencesHelper, apiHelper);
    }
}
