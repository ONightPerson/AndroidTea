package com.liubz.androidtea.immersive;

import android.app.Activity;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 8/6/24 3:40 PM
 */
public class ImmersiveUtils {
    public static void setImmersiveMode(Activity activity, boolean isDark) {
        ImmersiveCreator creator = ImmersiveFactory.create();
        creator.setImmerseMode(activity, isDark);
    }
}
