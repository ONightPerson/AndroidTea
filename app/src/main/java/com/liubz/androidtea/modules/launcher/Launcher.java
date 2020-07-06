package com.liubz.androidtea.modules.launcher;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;

/**
 * Created by liubaozhu on 2020/7/2
 */
public class Launcher extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);
    }
}
