package com.liubz.androidtea.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by liubaozhu on 2019-12-28
 */
public class InstrumentationProxy extends Instrumentation {
    private static final String TAG = "InstrumentationProxy";

    private Instrumentation mInstrumentation;

    public InstrumentationProxy(Instrumentation instrumentation) {
        mInstrumentation = instrumentation;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {
        Log.d(TAG, "execStartActivity: wait for a second");
        // 通过反射找到 Instrumentation的 execStartActivity 方法
        try {
            Method method = Class.forName("android.app.Instrumentation").getDeclaredMethod("execStartActivity",
                    Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, int.class, Bundle.class);
            return (ActivityResult) method.invoke(mInstrumentation, who, contextThread, token, target, intent, requestCode, options);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "execStartActivity --> NoSuchMethodException: ", e);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "execStartActivity --> ClassNotFoundException: ", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "execStartActivity --> IllegalAccessException: ", e);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "execStartActivity --> InvocationTargetException: ", e);
        }
        return null;
    }

    public static void replaceActivityInstrumentation(Activity activity) {
        try {
            Field instrumentationField = Activity.class.getDeclaredField("mInstrumentation");
            instrumentationField.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) instrumentationField.get(activity);
            instrumentationField.set(activity, new InstrumentationProxy(instrumentation));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void replaceContextInstrumentation() {
        try {
            Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");
            Field sCurrentActivityThreadField = activityThreadClazz.getDeclaredField("sCurrentActivityThread");
            sCurrentActivityThreadField.setAccessible(true);
            Object sCurrentActivityThread = sCurrentActivityThreadField.get(null);

            Field instrumentationFiled = activityThreadClazz.getDeclaredField("mInstrumentation");
            instrumentationFiled.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) instrumentationFiled.get(sCurrentActivityThread);
            instrumentationFiled.set(sCurrentActivityThread, new InstrumentationProxy(instrumentation));
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "replaceContextInstrumentation --> ClassNotFoundException: ", e);
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "replaceContextInstrumentation --> NoSuchFieldException: ", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "replaceContextInstrumentation --> IllegalAccessException: ", e);
        }
    }

}
