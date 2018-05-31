package com.mindorks.bariawala.android.ui.deshboard.SavedFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.di.component.ActivityComponent;
import com.mindorks.bariawala.android.ui.FeedDetails.FeedDetailsActivity;
import com.mindorks.bariawala.android.ui.base.BaseFragment;
import com.mindorks.bariawala.android.ui.model.FeedCardData;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by nayan on 18/03/14.
 */

public class SavedFragment extends BaseFragment implements SavedMvpView, SavedAdapter.Callback{

    @Inject
    SavedMvpPresenter<SavedMvpView, SavedMvpInteractor> mPresenter;

    @Inject
    SavedAdapter mSavedAdapter;

    //@BindView(R.id.savedRecyclerView)
    private RecyclerView mRecyclerView;

    private LinearLayoutManager mLinearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.saved_fragment, null);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            setHasOptionsMenu(true);
            getActivityComponent().inject(this);
            setUnBinder(ButterKnife.bind(getBaseActivity()));
            mRecyclerView = (RecyclerView) view.findViewById(R.id.savedRecyclerView);
            mPresenter.onAttach(this);
            mSavedAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        mSavedAdapter.setViewData(mPresenter.getSavedList());
        mRecyclerView.setAdapter(mSavedAdapter);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
    }


    @Override
    public void onSavedItemClick() {
        Log.e("onSavedItemClick","Clicked");
        Toast.makeText(getContext(),"Item click", Toast.LENGTH_LONG).show();
        startActivity(FeedDetailsActivity.getStartIntent(getContext()));
    }
}
