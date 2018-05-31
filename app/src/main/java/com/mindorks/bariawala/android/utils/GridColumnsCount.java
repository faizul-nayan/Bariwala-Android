package com.mindorks.bariawala.android.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Faizul Haque Nayan on 18/03/18.
 */

public class  GridColumnsCount {


    private Context mContext;

    public GridColumnsCount(Context context) {
        this.mContext = context;
    }

    public int calculateNoOfColumns() {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 180);
        return noOfColumns;
    }
}
