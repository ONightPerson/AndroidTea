package com.liubz.androidtea.immersive;

import android.app.Activity;

import com.liubz.androidtea.immersive.factory.ImmersiveCreator;
import com.liubz.androidtea.immersive.factory.ImmersiveFactory;

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
