package com.android.liubz.androidtea.mvvm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.android.liubz.androidtea.R;

/**
 * Created by liubaozhu on 2020/6/23
 */
public class SimpleFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);
    }
}
