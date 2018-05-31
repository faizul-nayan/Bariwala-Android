package com.mindorks.bariawala.android.ui.deshboard.SearchFragment;

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
import android.widget.LinearLayout;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.di.component.ActivityComponent;
import com.mindorks.bariawala.android.ui.FeedDetails.FeedDetailsActivity;
import com.mindorks.bariawala.android.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

import com.mindorks.bariawala.android.ui.model.FeedCardData;
import com.mindorks.bariawala.android.utils.GridColumnsCount;


/**
 * Created by nayan on 18/03/14.
 */

public class SearchFragment extends BaseFragment implements SearchMvpView {

    //@BindView(R.id.feedRecyclerView)
    private RecyclerView mRecyclerView;

    private SearchAdapter mAdapter;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayout mSearchLayout;
    private static int temp = 0;

    @Inject
    SearchMvpPresenter<SearchMvpView, SearchMvpInteractor> mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search_fragment, null);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            setHasOptionsMenu(true);
            getActivityComponent().inject(this);
            setUnBinder(ButterKnife.bind(getBaseActivity()));
            mPresenter.onAttach(this);
            mRecyclerView = (RecyclerView) view.findViewById(R.id.feedRecyclerView);
            mSearchLayout = (LinearLayout) view.findViewById(R.id.searchLayout);
            mAdapter = new SearchAdapter(getActivity(), mPresenter);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {

        mAdapter.setViewData(mPresenter.getFeedData());
        mRecyclerView.setAdapter(mAdapter);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        gridLayoutManager = new GridLayoutManager(getActivity(), new GridColumnsCount(getContext()).calculateNoOfColumns());
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 3));
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.searchMenuItem:
                if(temp == 0) {
                    mSearchLayout.setVisibility(View.VISIBLE);
                    mRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 2.2f));
                    temp++;
                }
                else if(temp == 1){
                    mSearchLayout.setVisibility(View.GONE);
                    mRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 3f));
                    temp--;
                }
                return true;
            default:
                break;
        }

        return false;
    }

    @Override
    public void viewItemClick(FeedCardData feedCardData) {
        startActivity(FeedDetailsActivity.getStartIntent(getContext()));
    }
}
