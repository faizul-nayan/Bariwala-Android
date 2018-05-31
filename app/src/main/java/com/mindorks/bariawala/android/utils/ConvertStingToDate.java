package com.mindorks.bariawala.android.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Faizul Haque Nayan on 8/7/17.
 */

public class ConvertStingToDate {

    Date date = null;

    public  String getSoftwareDate(String softwareDate){
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = format.parse(softwareDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.setTime(date);
        String day = new SimpleDateFormat("EE").format(date);

        return day;
    }


}
