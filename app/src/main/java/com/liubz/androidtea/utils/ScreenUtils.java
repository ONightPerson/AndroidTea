package com.liubz.androidtea.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

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
}
