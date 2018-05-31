package com.mindorks.bariawala.android.ui.deshboard.AlertFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.bariawala.android.R;

/**
 * Created by Faizul Hauqe Nayan on 18/03/14.
 */

public class AlertFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.alert_fragment, null);
        return view;
    }
}
