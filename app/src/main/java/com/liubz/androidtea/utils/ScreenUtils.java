package com.liubz.androidtea.utils;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/5/25 5:34 PM
 */
public class ScreenUtils {
    private static final String TAG = "DensityUtils";

    public static void outputDensityInfo(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        ScreenInfo screenInfo = new ScreenInfo();
        screenInfo.density = dm.density;
        screenInfo.dpi = dm.densityDpi;
        screenInfo.widthPixel = dm.widthPixels;
        screenInfo.heightPixel = dm.heightPixels;
        screenInfo.xdpi = dm.xdpi;
        screenInfo.ydpi = dm.ydpi;
        screenInfo.scaledDensity = dm.scaledDensity;
        Log.i(TAG, "screen info: " + screenInfo);
    }

    static class ScreenInfo {
        public float density;
        public int dpi;
        public int widthPixel;
        public int heightPixel;
        public float xdpi;
        public float ydpi;
        public float scaledDensity;

        @Override
        public String toString() {
            return "ScreenInfo{" +
              "density=" + density +
              ", dpi=" + dpi +
              ", widthPixel=" + widthPixel +
              ", heightPixel=" + heightPixel +
              ", xdpi=" + xdpi +
              ", ydpi=" + ydpi +
              ", scaledDensity=" + scaledDensity +
              '}';
        }
    }

    public static PointF getViewCenter(View view, int offset) {
        if (view == null) {
            return new PointF(0f, 0f);
        }

        int[] location = new int[2];
        view.getLocationOnScreen(location);
        float x = location[0] + view.getWidth() / 2f;
        float y = location[1] + view.getHeight() / 2f - offset;
        return new PointF(x, y);
    }

    public static int getNavigationBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
