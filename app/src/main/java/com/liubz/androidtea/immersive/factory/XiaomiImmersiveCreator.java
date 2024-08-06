package com.liubz.androidtea.immersive.factory;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.liubz.androidtea.immersive.factory.CommonImmersiveCreator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 8/6/24 3:36 PM
 */
public class XiaomiImmersiveCreator extends CommonImmersiveCreator {

    @Override
    public void setImmerseStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Window window = activity.getWindow();
                window.getDecorView().setSystemUiVisibility(
                  View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        } catch (Throwable t) {
        }
    }

    /**
     * 小米官网适配方案：https://dev.mi.com/distribute/doc/details?pId=1576
     *
     * @param activity
     * @param isDark
     */
    @Override
    public void setStatusBarColor(Activity activity, boolean isDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            super.setStatusBarColor(activity, isDark);
        } else {
            setStatusBarDarkMode(isDark, activity);
        }
    }

    private void setStatusBarDarkMode(boolean darkMode, Activity activity) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), darkMode ? darkModeFlag : 0, darkModeFlag);
        } catch (Exception e) {
        }
    }
}
