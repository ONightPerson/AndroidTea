package com.liubz.androidtea.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by liubaozhu on 2020/9/2
 */
public class TimeUtils {

    public static String getLocalDateTimeString(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");

        return simpleDateFormat.format(new Date(time));
    }

    public static String getUTCDateTimeString(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        return simpleDateFormat.format(new Date(time));
    }

    public static String getLocalTimeString(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

        return simpleDateFormat.format(new Date(time));
    }

    public static String getUTCTimeString(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        return simpleDateFormat.format(new Date(time));
    }

    public static String getUTCTimeString(Long[] times) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (long time : times) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String result = simpleDateFormat.format(new Date(time));
            builder.append(result).append(",");
        }
        return builder.substring(0, builder.length() - 2) + "]";
    }

    public static long getLocalDaysPreTime(int n) {
        // 获取的为本地时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -n);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
//        SimpleDateFormat localFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        String localTime = localFormat.format(calendar.getTime());
//
//        SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//        Date utcDate = null;
//        try {
//            utcDate = utcFormat.parse(localTime);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return utcDate.getTime();

        return calendar.getTimeInMillis();
    }

    /**
     * 计算给定时间戳当天零点的时间戳
     * @param time
     * @return
     */
    public static long getGivenMidnightTime(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTimeInMillis();
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

    public static long getElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    /**
     * 获取应用安装时间
     * @param cxt context
     * @param pkgName 应用包名
     */
    public static long getInstalledTime(Context cxt, String pkgName) {
        long installTime = 0L;
        PackageInfo pkgInfo = PackageUtils.getPkgInfo(cxt, pkgName);
        if (pkgInfo != null) {
            installTime = pkgInfo.firstInstallTime;
        }
        return installTime;

    }
}
