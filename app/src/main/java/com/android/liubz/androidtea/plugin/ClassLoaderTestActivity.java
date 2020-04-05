package com.android.liubz.androidtea.plugin;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.android.liubz.androidtea.R;

import dalvik.system.DexClassLoader;

/**
 * Created by liubaozhu on 2020-03-13
 */
public class ClassLoaderTestActivity extends Activity {
    private TextView mTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classloader_test);

        initViews();

        classloaderLog();
    }

    private void initViews() {
        mTV = findViewById(R.id.classloader);
    }

    private void classloaderLog() {
    }
}
