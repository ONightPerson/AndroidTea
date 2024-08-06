package com.liubz.androidtea.immersive.factory;

import android.app.Activity;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 8/6/24 3:31 PM
 */
public abstract class ImmersiveCreator {

    // 开启沉浸式模式
    public final void setImmerseMode(Activity activity, boolean isDark) {
        setImmerseStatusBar(activity);
        setStatusBarColor(activity, isDark);
    }

    /**
     * 设置沉浸式状态栏模式
     */
    public abstract void setImmerseStatusBar(Activity activity);

    /**
     * 设置状态栏字体颜色
     * @param isDark 状态栏文字是否为黑色
     */
    public abstract void setStatusBarColor(Activity activity, boolean isDark);
}
