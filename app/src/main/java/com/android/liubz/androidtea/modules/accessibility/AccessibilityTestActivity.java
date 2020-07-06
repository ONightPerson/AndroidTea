package com.android.liubz.androidtea.modules.accessibility;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.liubz.androidtea.R;

import org.jetbrains.annotations.Nullable;

/**
 * Created by liubz on 18-4-18.
 */

@SuppressLint("LongLogTag")
public class AccessibilityTestActivity extends Activity {
    private static final String TAG = AccessibilityConstant.TAG + "AccessibilityTestActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessibility_test);

    }

    public void showToast(View v) {
        switch (v.getId()) {
            case R.id.accessibility_click_tips:
                Log.i(TAG, "showToast: v: " + v);
                Toast.makeText(getApplicationContext(), R.string.accessibility_auto_click_toast,
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }
}
