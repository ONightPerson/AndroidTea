package com.android.liubz.androidtea.interprocess;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.liubz.androidtea.R;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_test);
    }
}
