package com.liubz.androidtea.stack.launchmode;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/19 6:22 PM
 */
@SuppressWarnings("LongLogTag")
public class TransparentActivity extends BaseActivity {
    private static final String TAG = "TransparentActivity" + LAUNCH_MODE_TAG_SUFFIX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
//        setTitle("TransparentActivity");
    }
}
