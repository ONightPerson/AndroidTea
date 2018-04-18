package com.android.liubz.androidtea.service.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.android.liubz.androidtea.R;

import java.util.List;

/**
 * Created by liubz on 18-4-18.
 */

@SuppressLint("LongLogTag")
public class MyAccessibilityService extends AccessibilityService {
    private static final String TAG = AccessibilityConstant.TAG + "MyAccessibilityService";
    
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onServiceConnected() {
        Log.i(TAG, "onServiceConnected");
        super.onServiceConnected();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.i(TAG, "onAccessibilityEvent: event: " + event);
        AccessibilityNodeInfo info = event.getSource();
        Log.i(TAG, "onAccessibilityEvent: info: " + info);

        autoClick(info);
    }

    @Override
    public void onInterrupt() {
        Log.i(TAG, "onInterrupt: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: intent: " + intent);
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    private void autoClick(AccessibilityNodeInfo info) {
        if (info == null) {
            return;
        }
        String text = getString(R.string.accessibility_auto_click);
        List<AccessibilityNodeInfo> nodes = info.findAccessibilityNodeInfosByText(text);
        Log.i(TAG, "autoClick: nodes: " + nodes);
        for (AccessibilityNodeInfo node : nodes) {
            Log.i(TAG, "autoClick: node: " + node);
            if (TextUtils.equals(node.getText(), text) && TextUtils.equals(
                    node.getClassName(),  "android.widget.Button")) {
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                AccessibilityJumpActivity.dismiss(this);
            }
        }
    }
}
