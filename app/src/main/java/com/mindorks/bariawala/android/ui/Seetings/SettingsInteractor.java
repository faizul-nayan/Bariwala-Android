package com.mindorks.bariawala.android.ui.Seetings;

import com.mindorks.bariawala.android.data.network.ApiHelper;
import com.mindorks.bariawala.android.data.prefs.PreferencesHelper;
import com.mindorks.bariawala.android.ui.base.BaseInteractor;

import javax.inject.Inject;

/**
 * Created by Nayan on 3/24/2018.
 */

public class SettingsInteractor extends BaseInteractor implements SettingsMvpInteractor {
    @Inject
    public SettingsInteractor(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        super(preferencesHelper, apiHelper);
    }
}
