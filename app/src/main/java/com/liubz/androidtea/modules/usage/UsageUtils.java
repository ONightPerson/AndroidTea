package com.liubz.androidtea.modules.usage;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.liubz.androidtea.utils.TimeUtils;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by liubaozhu on 2020/8/28
 */
public class UsageUtils {
    private static final boolean DEBUG = true;
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
        @SuppressLint("WrongConstant")
        UsageStatsManager manager =
                (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);

        long startTime = TimeUtils.getLocalDaysPreTime(6);
        //        long endTime = TimeUtils.getDaysPreUtcTime(0);
        long endTime = System.currentTimeMillis();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Log.i(TAG, "startTime: " + TimeUtils.getUTCDateTimeString(startTime)
                + ", endTime: " + TimeUtils.getUTCDateTimeString(endTime) + ", interval: "
                + simpleDateFormat.format(endTime - startTime));

        List<UsageStats> usageStats =
                manager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTime, endTime);
        //        Collections.sort(usageStats, new Comparator<UsageStats>() {
        //            @Override
        //            public int compare(UsageStats o1, UsageStats o2) {
        //                return o1.getPackageName().compareTo(o2.getPackageName());
        //            }
        //        });
        for (UsageStats stats : usageStats) {
            long usedTime = stats.getTotalTimeInForeground();
            if (usedTime <= 0) {
                continue;
            }
            Log.d(TAG,
                    "ForegroundTime: " + TimeUtils
                            .getLocalTimeString(stats.getTotalTimeInForeground())
                            + "\tlastUsedTime: " + TimeUtils
                            .getLocalTimeString(stats.getLastTimeUsed())
                            + "\tlastTimeStamp: " + TimeUtils
                            .getLocalDateTimeString(stats.getLastTimeStamp())
                            + "\tfirstTimeStamp:" + TimeUtils
                            .getLocalDateTimeString(stats.getFirstTimeStamp())
                            + "\tinterval: " + TimeUtils.getLocalTimeString(stats.getLastTimeStamp()
                            - stats.getFirstTimeStamp())
                            + "\tPkg: " + stats.getPackageName());
        }

    }

    public static void queryUsageEvents(Context context, long startTime, long endTime) {
        Log.i(TAG, "queryUsageEvents: startTime: " + TimeUtils.getLocalDateTimeString(startTime)
                        + ", endTime: " + TimeUtils.getLocalDateTimeString(endTime));
        UsageStatsManager mUsageStatsManager = getUsageStatsManager(context);
        UsageEvents.Event currentEvent;
        UsageEvents usageEvents = mUsageStatsManager.queryEvents(startTime, endTime);
        //capturing all events in a array to compare with next element
        Map<String, Long> statsMap = new HashMap<>();
        long resumeTime = 0;
        while (usageEvents.hasNextEvent()) {
            currentEvent = new UsageEvents.Event();
            usageEvents.getNextEvent(currentEvent);
            String pkgName = currentEvent.getPackageName();
            int eventType = currentEvent.getEventType();
            if (eventType != UsageEvents.Event.ACTIVITY_RESUMED
                    && currentEvent.getEventType() != UsageEvents.Event.ACTIVITY_PAUSED) {
                continue;
            }
            Log.i(TAG, "queryUsageEvents: pkg: " + pkgName
                    + ", eventType: " + currentEvent.getEventType()
                    + ", time: " + TimeUtils.getLocalDateTimeString(currentEvent.getTimeStamp()));
            if (!statsMap.containsKey(pkgName)) {
                statsMap.put(pkgName, 0L);
            }
            if (eventType == UsageEvents.Event.ACTIVITY_RESUMED) {
                resumeTime = currentEvent.getTimeStamp();
            } else if (eventType == UsageEvents.Event.ACTIVITY_PAUSED) {
                if (resumeTime == 0) {
                    continue;
                }
                long delta = currentEvent.getTimeStamp() - resumeTime;
                if (delta > 30 * 60 * 60 * 1000L) {
                    Log.e(TAG, "queryUsageEvents: interval: " + delta);
                }
                statsMap.put(pkgName, statsMap.get(pkgName) + delta);
            }
        }
        if (statsMap.containsKey("com.android.settings")) {
            Log.i(TAG, "queryUsageEvents --> consume time: "
                    + statsMap.get("com.android.settings"));

        }
    }

    /**
     * @param context
     * @return
     */
    public static Map<String, UsageStats> getUsageStatsList(Context context) {
        UsageStatsManager usm = getUsageStatsManager(context);
        long startTime = TimeUtils.getLocalDaysPreTime(6);
        long endTime = TimeUtils.getLocalDaysPreTime(0);
        //        long endTime = System.currentTimeMillis();

        Log.d(TAG, "Range start:" + TimeUtils.getLocalDateTimeString(startTime));
        Log.d(TAG, "Range end:" + TimeUtils.getLocalDateTimeString(endTime));

        Map<String, UsageStats> usageStatsMap =
                usm.queryAndAggregateUsageStats(startTime, endTime);
        return usageStatsMap;
    }

    public static void printUsageStats(Map<String, UsageStats> usageStatsMap) {
        Set<Map.Entry<String, UsageStats>> entries = usageStatsMap.entrySet();
        for (Map.Entry<String, UsageStats> entry : entries) {
            String pkg = entry.getKey();
            UsageStats u = entry.getValue();
            Log.d(TAG, "Pkg: " + pkg
                    + "\tForegroundTime: " + u.getTotalTimeInForeground()
                    + "\tlastUsedTime: " + TimeUtils.getLocalDateTimeString(u.getLastTimeUsed())
                    + "\tlastTimeStamp: " + TimeUtils.getLocalDateTimeString(u.getLastTimeStamp())
                    + "\tfirstTimeStamp:" + TimeUtils
                    .getLocalDateTimeString(u.getFirstTimeStamp()));
        }

    }

    private static boolean checkAuthorityEnable(Context context) {
        if (checkBiggerSDKInt(android.os.Build.VERSION_CODES.KITKAT)) {
            @SuppressLint("WrongConstant")
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

    private static UsageStatsManager getUsageStatsManager(Context context) {
        @SuppressLint("WrongConstant")
        UsageStatsManager usm =
                (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);
        return usm;
    }

    public static Map<String, Long> getUsageStatsMap(UsageStatsManager usm, long startTime,
                                                      long endTime) {
        if (DEBUG) {
            Log.d(TAG, "startTime: " + TimeUtils.getLocalDateTimeString(startTime)
                    + ", endTime: " + TimeUtils.getLocalDateTimeString(endTime));
        }

        UsageEvents usageEvents = usm.queryEvents(startTime, endTime);
        // 存储每个应用的应用使用时长
        Map<String, Long> pkgStatsMap = new HashMap<>();
        long resumeTime = 0L;
        UsageEvents.Event curEvent;
        int lastEventType = UsageEvents.Event.NONE;
        String lastPkg = "";
        long lastTimeStamp = 0L;
        while (usageEvents.hasNextEvent()) {
            curEvent = new UsageEvents.Event();
            usageEvents.getNextEvent(curEvent);
            String pkgName = curEvent.getPackageName();
            int eventType = curEvent.getEventType();
            // 只关注应用前后台切换事件
            if (eventType != UsageEvents.Event.ACTIVITY_RESUMED
                    && eventType != UsageEvents.Event.ACTIVITY_PAUSED) {
                continue;
            }
            lastEventType = eventType;
            lastPkg = pkgName;
            lastTimeStamp = curEvent.getTimeStamp();
//            if (DEBUG) {
//                Log.d(TAG, "pkg: " + pkgName + ", eventType: " + eventType + ", time: "
//                        + TimeUtils.getLocalDateTimeString(curEvent.getTimeStamp()));
//            }

            if (eventType == UsageEvents.Event.ACTIVITY_RESUMED) {
                if (!pkgStatsMap.containsKey(pkgName)) {
                    pkgStatsMap.put(pkgName, 0L);
                }
                resumeTime = curEvent.getTimeStamp();
            } else if (eventType == UsageEvents.Event.ACTIVITY_PAUSED) {
                long pausedTime = curEvent.getTimeStamp();
                if (pkgStatsMap.containsKey(pkgName)) {
                    pkgStatsMap.put(pkgName, pkgStatsMap.get(pkgName) + pausedTime - resumeTime);
                } else {
                    long interval = pausedTime - TimeUtils.getGivenMidnightTime(pausedTime);
                    pkgStatsMap.put(pkgName, interval);
                }
            }
        }

        if (lastEventType == UsageEvents.Event.ACTIVITY_RESUMED && !TextUtils.isEmpty(lastPkg)) {
            long interval = System.currentTimeMillis() - lastTimeStamp;
            Log.i(TAG,
                    "lastPkg: " + lastPkg + ", interval: " + TimeUtils.getUTCDateTimeString(interval));
            if (pkgStatsMap.containsKey(lastPkg)) {
                pkgStatsMap.put(lastPkg, pkgStatsMap.get(lastPkg) + interval);
            } else {
                pkgStatsMap.put(lastPkg, interval);
            }

        }

        return pkgStatsMap;
    }

    public static Map<String, Long[]> getWeekUsageStatsMap(UsageStatsManager usm) {
        Map<String, Long[]> result = new HashMap<>();
        for (int i = 6; i >= 1; i--) {
            Map<String, Long> map = getUsageStatsMap(usm, TimeUtils.getLocalDaysPreTime(i),
                    TimeUtils.getLocalDaysPreTime(i - 1));
            mergeStatsMap(result, map, i);

        }
        Map<String, Long> todayUsageStats = getUsageStatsMap(usm,
                TimeUtils.getLocalDaysPreTime(0), System.currentTimeMillis());
        mergeStatsMap(result, todayUsageStats, 0);

        return result;
    }

    private static void mergeStatsMap(Map<String, Long[]> ans, Map<String, Long> map, int pos) {
        Set<Map.Entry<String, Long>> entries = map.entrySet();
        for (Map.Entry<String, Long> entry : entries) {
            String pkg = entry.getKey();
            Long usedTime = entry.getValue();
            if (ans.containsKey(pkg)) {
                ans.get(pkg)[pos] = usedTime;
            } else {
                Long[] statsArray = new Long[7];
                Arrays.fill(statsArray, 0L);
                statsArray[pos] = usedTime;
                ans.put(pkg, statsArray);
            }
        }
    }
}
