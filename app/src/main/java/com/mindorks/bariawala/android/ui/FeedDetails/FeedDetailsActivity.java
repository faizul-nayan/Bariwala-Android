package com.mindorks.bariawala.android.ui.FeedDetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FeedDetailsActivity extends BaseActivity implements FeedDetailsMvpView {


    @BindView(R.id.suggestionListView)
    RecyclerView mRecyclerView;

    @BindView(R.id.mapRecyclerView)
    RecyclerView mMapRecyclerView;

    private DetailsSuggestionAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    private LinearLayoutManager mHorizontalLayout;

    private FeedMapAdapter mMapAdapter;

    @Inject
    FeedDetailsMvpPresenter<FeedDetailsMvpView, FeedDetailsMvpInteractor> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_details);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));
        showLoading();
        mPresenter.onAttach(FeedDetailsActivity.this);
        mAdapter = new DetailsSuggestionAdapter(this, mPresenter);
        mMapAdapter = new FeedMapAdapter(this, mPresenter);
        setUp();
    }

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, FeedDetailsActivity.class);
        return intent;
    }

    @Override
    protected void setUp() {
        hideLoading();
        mAdapter.setViewData(mPresenter.getSuggsentionList());
        mRecyclerView.setAdapter(mAdapter);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mHorizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mMapAdapter.setViewData(mPresenter.getMapInfo());
        mMapRecyclerView.setAdapter(mMapAdapter);
        mMapRecyclerView.setLayoutManager(mHorizontalLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onMapClick() {
        MapDetailsDialog.newInstance().show(getSupportFragmentManager(),"");
    }
}
