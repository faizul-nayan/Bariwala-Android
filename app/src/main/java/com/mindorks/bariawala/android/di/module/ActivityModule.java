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

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.mindorks.bariawala.android.data.network.model.BlogResponse;
import com.mindorks.bariawala.android.data.network.model.OpenSourceResponse;
import com.mindorks.bariawala.android.di.ActivityContext;
import com.mindorks.bariawala.android.di.PerActivity;
import com.mindorks.bariawala.android.ui.FeedDetails.FeedDetailsInteractor;
import com.mindorks.bariawala.android.ui.FeedDetails.FeedDetailsMvpInteractor;
import com.mindorks.bariawala.android.ui.FeedDetails.FeedDetailsMvpPresenter;
import com.mindorks.bariawala.android.ui.FeedDetails.FeedDetailsMvpView;
import com.mindorks.bariawala.android.ui.FeedDetails.FeedDetailsPresenter;
import com.mindorks.bariawala.android.ui.NewPost.NewPostImageAdapter;
import com.mindorks.bariawala.android.ui.NewPost.NewPostInteractor;
import com.mindorks.bariawala.android.ui.NewPost.NewPostMvpInteractor;
import com.mindorks.bariawala.android.ui.NewPost.NewPostMvpPresenter;
import com.mindorks.bariawala.android.ui.NewPost.NewPostMvpView;
import com.mindorks.bariawala.android.ui.NewPost.NewPostPresenter;
import com.mindorks.bariawala.android.ui.Seetings.SettingsInteractor;
import com.mindorks.bariawala.android.ui.Seetings.SettingsMvpInteractor;
import com.mindorks.bariawala.android.ui.Seetings.SettingsMvpPresenter;
import com.mindorks.bariawala.android.ui.Seetings.SettingsMvpView;
import com.mindorks.bariawala.android.ui.Seetings.SettingsPresenter;
import com.mindorks.bariawala.android.ui.Signin.SigninInteractor;
import com.mindorks.bariawala.android.ui.Signin.SigninMvpInteractor;
import com.mindorks.bariawala.android.ui.Signin.SigninMvpPresenter;
import com.mindorks.bariawala.android.ui.Signin.SigninMvpView;
import com.mindorks.bariawala.android.ui.Signin.SigninPresenter;
import com.mindorks.bariawala.android.ui.Signup.SignupInteractor;
import com.mindorks.bariawala.android.ui.Signup.SignupMvpInteractor;
import com.mindorks.bariawala.android.ui.Signup.SignupMvpPresenter;
import com.mindorks.bariawala.android.ui.Signup.SignupMvpView;
import com.mindorks.bariawala.android.ui.Signup.SignupPresenter;
import com.mindorks.bariawala.android.ui.about.AboutInteractor;
import com.mindorks.bariawala.android.ui.about.AboutMvpInteractor;
import com.mindorks.bariawala.android.ui.about.AboutMvpPresenter;
import com.mindorks.bariawala.android.ui.about.AboutMvpView;
import com.mindorks.bariawala.android.ui.about.AboutPresenter;
import com.mindorks.bariawala.android.ui.deshboard.FeedFragment.FeedsInteractor;
import com.mindorks.bariawala.android.ui.deshboard.FeedFragment.FeedsMvpInteraactor;
import com.mindorks.bariawala.android.ui.deshboard.FeedFragment.FeedsMvpPresenter;
import com.mindorks.bariawala.android.ui.deshboard.FeedFragment.FeedsMvpView;
import com.mindorks.bariawala.android.ui.deshboard.FeedFragment.FeedsPresenter;
import com.mindorks.bariawala.android.ui.deshboard.MoreFragment.MoreInteractor;
import com.mindorks.bariawala.android.ui.deshboard.MoreFragment.MoreMvpInteractor;
import com.mindorks.bariawala.android.ui.deshboard.MoreFragment.MoreMvpPresenter;
import com.mindorks.bariawala.android.ui.deshboard.MoreFragment.MoreMvpView;
import com.mindorks.bariawala.android.ui.deshboard.MoreFragment.MorePresenter;
import com.mindorks.bariawala.android.ui.deshboard.SavedFragment.SavedAdapter;
import com.mindorks.bariawala.android.ui.deshboard.SavedFragment.SavedInteractor;
import com.mindorks.bariawala.android.ui.deshboard.SavedFragment.SavedMvpInteractor;
import com.mindorks.bariawala.android.ui.deshboard.SavedFragment.SavedMvpPresenter;
import com.mindorks.bariawala.android.ui.deshboard.SavedFragment.SavedMvpView;
import com.mindorks.bariawala.android.ui.deshboard.SavedFragment.SavedPresenter;
import com.mindorks.bariawala.android.ui.deshboard.SearchFragment.SearchInteractor;
import com.mindorks.bariawala.android.ui.deshboard.SearchFragment.SearchMvpInteractor;
import com.mindorks.bariawala.android.ui.deshboard.SearchFragment.SearchMvpPresenter;
import com.mindorks.bariawala.android.ui.deshboard.SearchFragment.SearchMvpView;
import com.mindorks.bariawala.android.ui.deshboard.SearchFragment.SearchPresenter;
import com.mindorks.bariawala.android.ui.feed.FeedInteractor;
import com.mindorks.bariawala.android.ui.feed.FeedMvpInteractor;
import com.mindorks.bariawala.android.ui.feed.FeedMvpPresenter;
import com.mindorks.bariawala.android.ui.feed.FeedMvpView;
import com.mindorks.bariawala.android.ui.feed.FeedPagerAdapter;
import com.mindorks.bariawala.android.ui.feed.FeedPresenter;
import com.mindorks.bariawala.android.ui.feed.blogs.BlogAdapter;
import com.mindorks.bariawala.android.ui.feed.blogs.BlogInteractor;
import com.mindorks.bariawala.android.ui.feed.blogs.BlogMvpInteractor;
import com.mindorks.bariawala.android.ui.feed.blogs.BlogMvpPresenter;
import com.mindorks.bariawala.android.ui.feed.blogs.BlogMvpView;
import com.mindorks.bariawala.android.ui.feed.blogs.BlogPresenter;
import com.mindorks.bariawala.android.ui.feed.opensource.OpenSourceAdapter;
import com.mindorks.bariawala.android.ui.feed.opensource.OpenSourceInteractor;
import com.mindorks.bariawala.android.ui.feed.opensource.OpenSourceMvpInteractor;
import com.mindorks.bariawala.android.ui.feed.opensource.OpenSourceMvpPresenter;
import com.mindorks.bariawala.android.ui.feed.opensource.OpenSourceMvpView;
import com.mindorks.bariawala.android.ui.feed.opensource.OpenSourcePresenter;
import com.mindorks.bariawala.android.ui.login.LoginInteractor;
import com.mindorks.bariawala.android.ui.login.LoginMvpInteractor;
import com.mindorks.bariawala.android.ui.login.LoginMvpPresenter;
import com.mindorks.bariawala.android.ui.login.LoginMvpView;
import com.mindorks.bariawala.android.ui.login.LoginPresenter;
import com.mindorks.bariawala.android.ui.main.MainInteractor;
import com.mindorks.bariawala.android.ui.main.MainMvpInteractor;
import com.mindorks.bariawala.android.ui.main.MainMvpPresenter;
import com.mindorks.bariawala.android.ui.main.MainMvpView;
import com.mindorks.bariawala.android.ui.main.MainPresenter;
import com.mindorks.bariawala.android.ui.main.rating.RatingDialogInteractor;
import com.mindorks.bariawala.android.ui.main.rating.RatingDialogMvpInteractor;
import com.mindorks.bariawala.android.ui.main.rating.RatingDialogMvpPresenter;
import com.mindorks.bariawala.android.ui.main.rating.RatingDialogMvpView;
import com.mindorks.bariawala.android.ui.main.rating.RatingDialogPresenter;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.ui.splash.SplashInteractor;
import com.mindorks.bariawala.android.ui.splash.SplashMvpInteractor;
import com.mindorks.bariawala.android.ui.splash.SplashMvpPresenter;
import com.mindorks.bariawala.android.ui.splash.SplashMvpView;
import com.mindorks.bariawala.android.ui.splash.SplashPresenter;
import com.mindorks.bariawala.android.utils.rx.AppSchedulerProvider;
import com.mindorks.bariawala.android.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView, SplashMvpInteractor> provideSplashPresenter(
            SplashPresenter<SplashMvpView, SplashMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView, AboutMvpInteractor> provideAboutPresenter(
            AboutPresenter<AboutMvpView, AboutMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView, LoginMvpInteractor> provideLoginPresenter(
            LoginPresenter<LoginMvpView, LoginMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView, MainMvpInteractor> provideMainPresenter(
            MainPresenter<MainMvpView, MainMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView,
            RatingDialogMvpInteractor> provideRateUsPresenter(

            RatingDialogPresenter<RatingDialogMvpView, RatingDialogMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView, FeedMvpInteractor> provideFeedPresenter(
            FeedPresenter<FeedMvpView, FeedMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView,
            OpenSourceMvpInteractor> provideOpenSourcePresenter(

            OpenSourcePresenter<OpenSourceMvpView, OpenSourceMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView, BlogMvpInteractor> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView, BlogMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    @PerActivity
    SplashMvpInteractor provideSplashMvpInteractor(SplashInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    AboutMvpInteractor provideAboutMvpInteractor(AboutInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    LoginMvpInteractor provideLoginMvpInteractor(LoginInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    MainMvpInteractor provideMainMvpInteractor(MainInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    RatingDialogMvpInteractor provideRatingDialogMvpInteractor(
            RatingDialogInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    FeedMvpInteractor provideFeedMvpInteractor(FeedInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    OpenSourceMvpInteractor provideOpenSourceMvpInteractor(
            OpenSourceInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    BlogMvpInteractor provideBlogMvpInteractor(BlogInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    FeedsMvpPresenter<FeedsMvpView, FeedsMvpInteraactor> provideFeedsPresenter(
            FeedsPresenter<FeedsMvpView, FeedsMvpInteraactor> presenter) {

        return presenter;
    }

    @Provides
    @PerActivity
    FeedsMvpInteraactor provideFeedsMvpInteractor(FeedsInteractor interactor) {
        return interactor;
    }


    @Provides
    @PerActivity
    FeedDetailsMvpPresenter<FeedDetailsMvpView, FeedDetailsMvpInteractor> provideFeedDetailsPresenter(
            FeedDetailsPresenter<FeedDetailsMvpView, FeedDetailsMvpInteractor> presenter) {

        return presenter;
    }

    @Provides
    @PerActivity
    FeedDetailsMvpInteractor provideFeedDetailsMvpInteractor(FeedDetailsInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    SearchMvpPresenter<SearchMvpView, SearchMvpInteractor> provideSearchPresenter(
            SearchPresenter<SearchMvpView, SearchMvpInteractor> presenter) {

        return presenter;
    }

    @Provides
    @PerActivity
    SearchMvpInteractor provideSearchMvpInteractor(SearchInteractor interactor) {
        return interactor;
    }


    @Provides
    @PerActivity
    NewPostMvpPresenter<NewPostMvpView, NewPostMvpInteractor> provideNewPostPresenter(
            NewPostPresenter<NewPostMvpView, NewPostMvpInteractor> presenter) {

        return presenter;
    }

    @Provides
    @PerActivity
    NewPostMvpInteractor provideNewPostMvpInteractor(NewPostInteractor interactor) {
        return interactor;
    }

    @Provides
    NewPostImageAdapter provideNewPostImageAdapter() {
        return new NewPostImageAdapter(new ArrayList<Bitmap>());
    }


    @Provides
    @PerActivity
    SavedMvpPresenter<SavedMvpView, SavedMvpInteractor> provideSavedPresenter(
            SavedPresenter<SavedMvpView, SavedMvpInteractor> presenter) {

        return presenter;
    }

    @Provides
    @PerActivity
    SavedMvpInteractor provideSavedMvpInteractor(SavedInteractor interactor) {
        return interactor;
    }

    @Provides
    SavedAdapter provideSavedAdapter() {
        return new SavedAdapter(new ArrayList<FeedCardData>());
    }

    @Provides
    @PerActivity
    MoreMvpPresenter<MoreMvpView, MoreMvpInteractor> provideMorePresenter(
            MorePresenter<MoreMvpView, MoreMvpInteractor> presenter) {

        return presenter;
    }

    @Provides
    @PerActivity
    MoreMvpInteractor provideMoreMvpInteractor(MoreInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    SignupMvpPresenter<SignupMvpView, SignupMvpInteractor> provideSignupPresenter(
            SignupPresenter<SignupMvpView, SignupMvpInteractor> presenter) {

        return presenter;
    }

    @Provides
    @PerActivity
    SignupMvpInteractor provideSignupMvpInteractor(SignupInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    SigninMvpPresenter<SigninMvpView, SigninMvpInteractor> provideSigninPresenter(
                    SigninPresenter<SigninMvpView, SigninMvpInteractor> presenter) {

        return presenter;
    }

    @Provides
    @PerActivity
    SigninMvpInteractor provideSigninMvpInteractor(SigninInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    SettingsMvpPresenter<SettingsMvpView, SettingsMvpInteractor> provideSettingsPresenter(
            SettingsPresenter<SettingsMvpView, SettingsMvpInteractor> presenter) {

        return presenter;
    }

    @Provides
    @PerActivity
    SettingsMvpInteractor provideSettingsMvpInteractor(SettingsInteractor interactor) {
        return interactor;
    }
}
