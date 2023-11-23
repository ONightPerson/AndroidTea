package com.liubz.androidtea.stack.launchmode;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * Android 8.0
 *
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/19 6:22 PM
 */
@SuppressWarnings("LongLogTag")
public class TransparentActivity extends BaseActivity {
    private static final String TAG = "TransparentActivity" + LAUNCH_MODE_TAG_SUFFIX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        boolean isTranslucentOrFloating = isTranslucentOrFloating();
        Log.i(TAG, "onCreate: isTranslucentOrFloating: " + isTranslucentOrFloating);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O && isTranslucentOrFloating) {
            boolean fixed = fixOrientation();
            Log.i(TAG, "onCreate: fixed: " + fixed);
        }
        super.onCreate(savedInstanceState);
    }

    private boolean isTranslucentOrFloating() {
        boolean isTranslucentOrFloating = false;
        try {
            int[] attrs = (int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null);
            final TypedArray ta = obtainStyledAttributes(attrs);
            Method m = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            m.setAccessible(true);
            isTranslucentOrFloating = (boolean) m.invoke(null, ta);
            m.setAccessible(false);
            ta.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isTranslucentOrFloating;
    }

    private boolean fixOrientation() {
        try {
            Field f = Activity.class.getDeclaredField("mActivityInfo");
            f.setAccessible(true);
            ActivityInfo ai = (ActivityInfo) f.get(this);
            ai.screenOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
            f.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
