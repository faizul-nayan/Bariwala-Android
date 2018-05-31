package com.mindorks.bariawala.android.ui.Seetings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.di.component.ActivityComponent;
import com.mindorks.bariawala.android.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Nayan on 3/24/2018.
 */

public class SettingsFragment extends BaseFragment implements SettingsMvpView {

    @Inject
    SettingsMvpPresenter<SettingsMvpView, SettingsMvpInteractor> mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, null);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            setHasOptionsMenu(true);
            getActivityComponent().inject(this);
            setUnBinder(ButterKnife.bind(getBaseActivity()));
            mPresenter.onAttach(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}
