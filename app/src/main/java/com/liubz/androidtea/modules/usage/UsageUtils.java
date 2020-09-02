package com.liubz.androidtea.modules.usage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by liubaozhu on 2020/8/28
 */
public class UsageUtils {
    private static final String TAG = "UsageUtils";

    public static void startTargetIntentIfNeeded(Context context) {
        if (!checkAuthorityEnable(context)) {
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (isIntentAvailable(context, intent)) {
                context.startActivity(intent);
            }
        }
    }

    public static void printEventStats(Context context) {
        UsageStatsManager manager =
                (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);

        List<UsageStats> usageStats =
                manager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, getTodayBegin(),
                        System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        for (UsageStats stats: usageStats) {
            long usedTime = stats.getTotalTimeInForeground();
            if (usedTime <= 0) {
                continue;
            }
            StringBuilder builder = new StringBuilder();
            builder.append(stats.getPackageName()).append("\n")
                    .append(format.format(new Date(stats.getLastTimeUsed()))).append("\n")
                    .append(usedTime).append("\n\n");
            Log.i(TAG, builder.toString());
        }

    }

    private static long getTodayBegin() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -7);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    private static boolean checkAuthorityEnable(Context context) {
        if (checkBiggerSDKInt(android.os.Build.VERSION_CODES.KITKAT)) {
            AppOpsManager appOps =
                    (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
            int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, Process.myUid(),
                    context.getPackageName());
            boolean granted = mode == AppOpsManager.MODE_ALLOWED;
            return granted;
        }
        return false;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        PackageManager pm = context.getPackageManager();
        if (pm == null) {
            return false;
        }
        try {
            List<ResolveInfo> list = pm.queryIntentActivities(
                    intent, PackageManager.MATCH_DEFAULT_ONLY);
            return list != null && list.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean checkBiggerSDKInt(int compare) {
        return Build.VERSION.SDK_INT >= compare;
    }

}
