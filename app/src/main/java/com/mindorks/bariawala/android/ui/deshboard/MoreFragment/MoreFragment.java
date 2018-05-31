package com.mindorks.bariawala.android.ui.deshboard.MoreFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.di.component.ActivityComponent;
import com.mindorks.bariawala.android.ui.Signup.SignupActivity;
import com.mindorks.bariawala.android.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by nayan on 18/03/14.
 */

public class MoreFragment extends BaseFragment implements MoreMvpView {


    private LinearLayout mSignInLayout;
    private TextView mSigninTextView;
    private LinearLayout mLoginLayout;
    private TextView mSignupNowTextView;

    @Inject
    MoreMvpPresenter<MoreMvpView, MoreMvpInteractor> mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.more_fragment, null);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            setHasOptionsMenu(true);
            getActivityComponent().inject(this);
            setUnBinder(ButterKnife.bind((Activity) getContext()));
            mSignInLayout = (LinearLayout) view.findViewById(R.id.signInLayout);
            mSigninTextView = (TextView) view.findViewById(R.id.signInTextView);
            mLoginLayout = (LinearLayout) view.findViewById(R.id.loginLayout);
            mSignupNowTextView = (TextView) view.findViewById(R.id.singupNowTextView);
            //mRecyclerView = (RecyclerView) view.findViewById(R.id.savedRecyclerView);
            mPresenter.onAttach(this);

            //mAdapter = new SavedAdapter(getActivity(), mPresenter);
        }

        mSigninTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSignInLayout.setVisibility(View.GONE);
                mLoginLayout.setVisibility(View.VISIBLE);
            }
        });

        mSignupNowTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SignupActivity.getStartIntent(getContext()));
            }
        });
        return view;
    }

    @Override
    protected void setUp(View view) {

    }

}
