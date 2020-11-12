package com.liubz.androidtea.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * author: created by liubaozhu on 2020/5/4
 * email: liubaozhu@baidu.com
 */
public class PackageUtils {

    /**
     * Get standard package information from system PackageManager
     *
     * @return Instance of PackageInfo or null
     */
    public static PackageInfo getPkgInfo(Context ctx, String pkgName) {
        try {
            PackageManager pm = ctx.getPackageManager();
            if (pm != null) {
                return pm.getPackageInfo(pkgName, 0);
            }
        } catch (Exception e) {
            // fix for bug[sjws-13430]
            // don't care about the exception
        }
        return null;
    }
}
