package com.mindorks.bariawala.android.ui.deshboard.FeedFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.di.component.ActivityComponent;
import com.mindorks.bariawala.android.ui.FeedDetails.FeedDetailsActivity;
import com.mindorks.bariawala.android.ui.NewPost.NewPostActivity;
import com.mindorks.bariawala.android.ui.base.BaseFragment;
import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.utils.GridColumnsCount;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by nayan on 18/03/14.
 */

public class FeedFragment extends BaseFragment implements FeedsMvpView {


    //@BindView(R.id.feedRecyclerView)
    private RecyclerView mRecyclerView;

    private GridLayoutManager mGridLayoutManager;

    @Inject
    FeedsMvpPresenter<FeedsMvpView, FeedsMvpInteraactor> mPresenter;

    private FeedCardAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_fragment, null);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            setHasOptionsMenu(true);
            getActivityComponent().inject(this);
            setUnBinder(ButterKnife.bind(getBaseActivity()));
            mPresenter.onAttach(this);
            mRecyclerView = (RecyclerView) view.findViewById(R.id.feedRecyclerView);
            mAdapter = new FeedCardAdapter(getActivity(), mPresenter);
        }

        return view;
    }


    @Override
    protected void setUp(View view) {

        mPresenter.loadFeedCard();

        mAdapter.setViewData(mPresenter.getFeedData());
        mRecyclerView.setAdapter(mAdapter);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        gridLayoutManager = new GridLayoutManager(getActivity(), new GridColumnsCount(getActivity()).calculateNoOfColumns());
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }


    @Override
    public void goToFeedDetails(FeedCardData feedCardData) {
       // Intent intent = FeedDetailsActivity.getStartIntent(getContext());
        startActivity(FeedDetailsActivity.getStartIntent(getActivity()));

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.feed_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_new_post:
                startActivity(NewPostActivity.getStartIntent(getActivity()));
                return true;
            default:
                break;
        }

        return false;
    }

}
