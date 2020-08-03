package com.liubz.androidtea.modules.ui.customview;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.liubz.androidtea.R;

/**
 * Created by liubaozhu on 2019-05-19
 */
public class CustomViewActivity extends Activity {
    private static final String TAG = "ViewPropertyActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_activity);

    }

}
