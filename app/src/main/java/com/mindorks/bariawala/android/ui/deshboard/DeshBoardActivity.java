package com.mindorks.bariawala.android.ui.deshboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mindorks.bariawala.android.R;
import com.mindorks.bariawala.android.ui.NewPost.NewPostActivity;
import com.mindorks.bariawala.android.ui.Seetings.SettingsFragment;
import com.mindorks.bariawala.android.ui.base.BaseActivity;
import com.mindorks.bariawala.android.ui.deshboard.AlertFragment.AlertFragment;
import com.mindorks.bariawala.android.ui.deshboard.FeedFragment.FeedFragment;
import com.mindorks.bariawala.android.ui.deshboard.MoreFragment.MoreFragment;
import com.mindorks.bariawala.android.ui.deshboard.SavedFragment.SavedFragment;
import com.mindorks.bariawala.android.ui.deshboard.SearchFragment.SearchFragment;
import com.mindorks.bariawala.android.utils.ConvertStingToDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Faizul Hauqe Nayan on 18/03/14.
 */

public class DeshBoardActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private DrawerLayout drawer;
    private Toolbar toolbar;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;

    private TextView mDate;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feed:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new FeedFragment()).commit();

                    return true;
                case R.id.navigation_search:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new SearchFragment()).commit();
                    return true;
                case R.id.navigation_save:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new SavedFragment()).commit();
                    return true;
                case R.id.navigation_alert:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new AlertFragment()).commit();
                    return true;
                case R.id.navigation_more:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new MoreFragment()).commit();
                    return true;
                case R.id.nav_home:

                    return true;
            }
            return false;
        }
    };


    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, DeshBoardActivity.class);
        return intent;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deshboard);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));
        setUp();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new FeedFragment()).commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        setTitle("Bari Wala");

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    protected void setUp() {
        setupNavMenu();
    }


    void setupNavMenu() {
        View headerLayout = mNavigationView.getHeaderView(0);
        /*mProfileImageView = (RoundedImageView) headerLayout.findViewById(R.id.iv_profile_pic);
        mNameTextView = (TextView) headerLayout.findViewById(R.id.tv_name);
        mEmailTextView = (TextView) headerLayout.findViewById(R.id.tv_email);*/
        mDate = (TextView) headerLayout.findViewById(R.id.dateTextView);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        mDate.setText(dateFormat.format(new Date())+" , "+new ConvertStingToDate().getSoftwareDate(dateFormat.format(new Date()))+"day");
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        mDrawer.closeDrawer(GravityCompat.START);
                        switch (item.getItemId()) {
                            case R.id.nav_home:
                                fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.containerView, new FeedFragment()).commit();
                                return true;
                            case R.id.nav_new_post:
                                startActivity(NewPostActivity.getStartIntent(getApplicationContext()));
                                return true;
                            case R.id.nav_profile:
                                fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.containerView, new MoreFragment()).commit();
                                return true;
                            case R.id.nav_setting:
                                fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.containerView, new SettingsFragment()).commit();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }
}
