package com.liubz.androidtea.cherish.utils;

import java.util.Calendar;

/**
 * Created by liubaozhu on 2020/9/15
 */
public class DateTimeUtils {

    public static void main(String[] args) {
        long day1 = 1600139955628L;
        long day2 = 1599794355000L;
        System.out.println(daysBetween(day1, day2));
        System.out.println((day1 - day2) / (24 * 60 * 60 * 1000L));
    }

    public static int daysBetween(long before, long after) {
        Calendar cAfter = Calendar.getInstance();
        Calendar cBefore = Calendar.getInstance();
        if (after > before) {
            cAfter.setTimeInMillis(after);
            cBefore.setTimeInMillis(before);
        } else {
            cAfter.setTimeInMillis(before);
            cBefore.setTimeInMillis(after);
        }
        int year1 = cAfter.get(Calendar.YEAR);
        int year2 = cBefore.get(Calendar.YEAR);
        int day1 = cAfter.get(Calendar.DAY_OF_YEAR);
        int day2 = cBefore.get(Calendar.DAY_OF_YEAR);

        int between;
        if (year1 == year2) {
            between = day1 - day2;
        } else {
            int offsetY = year1 - year2 - 1;
            between = offsetY * 365 + day1 + (cBefore.getActualMaximum(Calendar.DAY_OF_YEAR) - day2);
        }
        return between;
    }


}
