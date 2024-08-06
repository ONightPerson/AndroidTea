package com.liubz.androidtea.immersive;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 8/6/24 3:36 PM
 */
public class MeizuImmersiveCreator extends CommonImmersiveCreator {
    private static Method mSetStatusBarDarkIcon;
    private static Field mStatusBarColorFiled;
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 0;

    @Override
    public void setStatusBarColor(Activity activity, boolean isDark) {
        setFlymeStatusBarDarkIcon(activity, isDark);
    }

    private void setFlymeStatusBarDarkIcon(Activity activity, boolean dark) {
        try {
            mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", boolean.class);
        } catch (NoSuchMethodException e) {
        }
        try {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e) {
        }
        setFlymeStatusBarDarkIcon(activity, dark, true);
    }

    /**
     * 魅族手机的状态栏颜色修改
     */
    private void setFlymeStatusBarDarkIcon(Activity activity, boolean dark, boolean flag) {

        if (mSetStatusBarDarkIcon != null) {
            try {
                mSetStatusBarDarkIcon.invoke(activity, dark);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        } else {
            if (flag) {
                setFlymeStatusBarDarkIcon(activity, activity.getWindow(), dark);
            }
        }
    }

    private void setFlymeStatusBarDarkIcon(Activity activity, Window window, boolean dark) {
        View decorView = window.getDecorView();
        if (decorView != null) {
            super.setStatusBarColor(activity, dark);
            setFlymeStatusBarColor(window, 0);
        }
    }

    private void setFlymeStatusBarColor(Window window, int color) {
        WindowManager.LayoutParams winParams = window.getAttributes();
        if (mStatusBarColorFiled != null) {
            try {
                int oldColor = mStatusBarColorFiled.getInt(winParams);
                if (oldColor != color) {
                    mStatusBarColorFiled.set(winParams, color);
                    window.setAttributes(winParams);
                }
            } catch (IllegalAccessException e) {
            }
        }
    }
}
