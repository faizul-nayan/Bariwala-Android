/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mindorks.bariawala.android.di.module;

import android.app.Application;
import android.content.Context;

import com.mindorks.bariawala.android.BuildConfig;
import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.data.db.DbOpenHelper;
import com.mindorks.bariawala.android.data.db.model.DaoMaster;
import com.mindorks.bariawala.android.data.db.model.DaoSession;
import com.mindorks.bariawala.android.data.network.ApiHeader;
import com.mindorks.bariawala.android.data.network.ApiHelper;
import com.mindorks.bariawala.android.data.network.AppApiHelper;
import com.mindorks.bariawala.android.data.prefs.AppPreferencesHelper;
import com.mindorks.bariawala.android.data.prefs.PreferencesHelper;
import com.mindorks.bariawala.android.di.ApiInfo;
import com.mindorks.bariawala.android.di.ApplicationContext;
import com.mindorks.bariawala.android.di.DatabaseInfo;
import com.mindorks.bariawala.android.di.PreferenceInfo;
import com.mindorks.bariawala.android.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(
            @ApiInfo String apiKey,
            PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(DbOpenHelper dbOpenHelper) {
        return new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }
}
