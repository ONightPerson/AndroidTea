package com.liubz.androidtea.stack.launchmode.singletop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.stack.launchmode.OtherActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 6:49 PM
 */
public class SingleTopActivity extends BaseActivity {
    private static final String TAG = "SingleTopActivity" + LAUNCH_MODE_TAG_SUFFIX;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);
        setTitle("SingleTopActivity");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.launch_mode_single_top_btn)
    void launchSingleTopActivity() {
        startActivity(new Intent(this, SingleTopActivity.class));
    }

    @OnClick(R.id.launch_mode_other_btn)
    void launchOtherActivity() {
        startActivity(new Intent(this, OtherActivity.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent");
    }
}
