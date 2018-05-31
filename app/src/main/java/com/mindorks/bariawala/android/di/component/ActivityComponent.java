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

package com.mindorks.bariawala.android.di.component;

import com.mindorks.bariawala.android.di.PerActivity;
import com.mindorks.bariawala.android.di.module.ActivityModule;
import com.mindorks.bariawala.android.ui.FeedDetails.FeedDetailsActivity;
import com.mindorks.bariawala.android.ui.FeedDetails.MapDetailsDialog;
import com.mindorks.bariawala.android.ui.NewPost.NewPostActivity;
import com.mindorks.bariawala.android.ui.Seetings.SettingsFragment;
import com.mindorks.bariawala.android.ui.Signin.SigninDialog;
import com.mindorks.bariawala.android.ui.Signup.SignupActivity;
import com.mindorks.bariawala.android.ui.about.AboutFragment;
import com.mindorks.bariawala.android.ui.deshboard.DeshBoardActivity;
import com.mindorks.bariawala.android.ui.deshboard.FeedFragment.FeedFragment;
import com.mindorks.bariawala.android.ui.deshboard.MoreFragment.MoreFragment;
import com.mindorks.bariawala.android.ui.deshboard.SavedFragment.SavedFragment;
import com.mindorks.bariawala.android.ui.deshboard.SearchFragment.SearchFragment;
import com.mindorks.bariawala.android.ui.feed.FeedActivity;
import com.mindorks.bariawala.android.ui.feed.blogs.BlogFragment;
import com.mindorks.bariawala.android.ui.feed.opensource.OpenSourceFragment;
import com.mindorks.bariawala.android.ui.login.LoginActivity;
import com.mindorks.bariawala.android.ui.main.MainActivity;
import com.mindorks.bariawala.android.ui.main.rating.RateUsDialog;
import com.mindorks.bariawala.android.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(FeedActivity activity);

    void inject(FeedDetailsActivity activity);

    void inject(NewPostActivity activity);

    void inject(DeshBoardActivity activity);

    void inject(SignupActivity signupActivity);

    void inject(FeedFragment fragment);

    void inject(SearchFragment fragment);

    void inject(SavedFragment fragment);

    void inject(MoreFragment fragment);

    void inject(SettingsFragment fragment);

    void inject(AboutFragment fragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);

    void inject(SigninDialog dialog);

    void inject(MapDetailsDialog dialog);
}
