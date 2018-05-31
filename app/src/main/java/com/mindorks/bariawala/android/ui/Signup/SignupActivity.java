package com.mindorks.bariawala.android.ui.Signup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.ui.Signin.SigninDialog;
import com.mindorks.bariawala.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends BaseActivity implements SignupMvpView{

    @Inject
    SignupPresenter<SignupMvpView, SignupMvpInteractor> mPresenter;

    @BindView(R.id.singupStartLayout)
    LinearLayout mSignupStartLayout;
    @BindView(R.id.signUpLayout)
    LinearLayout mSignupLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SignupActivity.this);
        setUp();
    }

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, SignupActivity.class);
        return intent;
    }

    @Override
    protected void setUp() {
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


    @OnClick(R.id.signupByEmailButton)
    void signupByEmail(){
        mSignupStartLayout.setVisibility(View.GONE);
        mSignupLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.loginStartTextView)
    void loginStartClick(){
        SigninDialog.newInstance().show(getSupportFragmentManager(),"");
    }

    @OnClick(R.id.loginEndTextView)
    void loginEndClick(){
        SigninDialog.newInstance().show(getSupportFragmentManager(),"");
    }
}
