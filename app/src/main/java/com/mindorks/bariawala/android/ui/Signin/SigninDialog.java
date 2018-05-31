package com.mindorks.bariawala.android.ui.Signin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.di.component.ActivityComponent;
import com.mindorks.bariawala.android.ui.base.BaseDialog;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Faizul Haque Nayan on 18/03/22.
 */

public class SigninDialog extends BaseDialog implements SigninMvpView{

    @Inject
    SigninMvpPresenter<SigninMvpView, SigninMvpInteractor> mPresenter;

    public static SigninDialog newInstance() {
        SigninDialog dialog = new SigninDialog();
        Bundle bundle = new Bundle();
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {

            component.inject(this);

            setUnBinder(ButterKnife.bind(this, view));

            mPresenter.onAttach(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}
