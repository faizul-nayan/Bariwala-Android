package com.mindorks.bariawala.android.ui.NewPost;

import com.mindorks.bariawala.android.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public interface NewPostMvpPresenter<V extends NewPostMvpView, I extends  NewPostMvpInteractor>
        extends MvpPresenter<V,I>{

    List<String> getInitViewData();
}
