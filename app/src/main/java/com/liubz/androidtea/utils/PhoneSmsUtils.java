package com.liubz.androidtea.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.provider.Telephony;

import java.util.List;

/**
 * Created by liubaozhu on 2020/7/30
 */
public class PhoneSmsUtils {

    public static String getPhoneAppPkg(Context cxt) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        ResolveInfo ri = cxt.getPackageManager().resolveActivity(intent, 0);
        return ri == null ? null : ri.activityInfo.packageName;
    }

    public static String getSmsPkg(Context cxt) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Telephony.Sms.getDefaultSmsPackage(cxt);
        }
        return null;
//        Intent intent = new Intent(Intent.ACTION_SEND);
////        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
//        ResolveInfo ri = cxt.getPackageManager().resolveActivity(intent, 0);
//        return ri == null ? null : ri.activityInfo.packageName;
    }

    public static String getSmsPkgScheme1(Context cxt) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        ResolveInfo ri = cxt.getPackageManager().resolveActivity(smsIntent, 0);
        return ri == null ? null : ri.activityInfo.packageName;
    }

    public static String getSmsListScheme1(Context cxt) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        List<ResolveInfo> infoList = cxt.getPackageManager().queryIntentActivities(smsIntent, PackageManager.MATCH_ALL);
        StringBuilder builder = new StringBuilder();
        for (ResolveInfo info : infoList) {
            builder.append(info.activityInfo.packageName).append(",");
        }
        return builder.toString();
    }

    public static String getSmsPkgScheme2(Context cxt) {
        String defApp = Settings.Secure.getString(cxt.getContentResolver(), "sms_default_application");
        PackageManager pm = cxt.getApplicationContext().getPackageManager();
        Intent iIntent = pm.getLaunchIntentForPackage(defApp);
        ResolveInfo mInfo = pm.resolveActivity(iIntent,0);
        return mInfo.activityInfo.packageName;
    }
}
