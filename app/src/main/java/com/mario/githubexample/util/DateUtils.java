package com.mario.githubexample.util;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String convertDate(String date) {
        final DateTime dateTime = new DateTime(date);
        final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(new Date(dateTime.getMillis()));
    }
}
