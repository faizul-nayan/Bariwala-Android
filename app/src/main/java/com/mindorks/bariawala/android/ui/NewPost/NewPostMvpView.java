package com.mindorks.bariawala.android.ui.NewPost;

import com.mindorks.bariawala.android.ui.base.MvpView;

import java.util.List;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public interface NewPostMvpView extends MvpView {

    void loadInitViewData(List<String> list);
}
