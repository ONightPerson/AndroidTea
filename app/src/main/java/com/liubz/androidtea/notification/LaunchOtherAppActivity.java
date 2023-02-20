package com.liubz.androidtea.notification;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.View;

import com.liubz.androidtea.R;

public class LaunchOtherAppActivity extends Activity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_test);
    }

    public void clickToThird(View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.learnopengles.android",
                "com.learnopengles.android.lesson_OpenGL_ES_2.TriangleActivity"));
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
