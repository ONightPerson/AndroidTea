package com.liubz.androidtea.stack.launchmode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.R;
import com.liubz.androidtea.stack.launchmode.singleinstance.SingleInstanceActivity;
import com.liubz.androidtea.stack.launchmode.singletask.SingleTaskActivity;
import com.liubz.androidtea.stack.launchmode.singletop.SingleTopActivity;
import com.liubz.androidtea.stack.launchmode.standard.StandardActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc: 验证launch mode
 * @Author: liubaozhu
 * @Date: 2023/2/17 4:51 PM
 */
@SuppressLint("LongLogTag")
public class LaunchModeActivity extends AppCompatActivity {
    private static final String TAG = "LaunchModeActivity" + LAUNCH_MODE_TAG_SUFFIX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
        setTitle("LaunchModeActivity");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.launch_mode_standard_btn)
    void launchStandardMode() {
        startActivity(new Intent(this, StandardActivity.class));
    }

    @OnClick(R.id.launch_mode_single_top_btn)
    void launchSingleTopMode() {
        startActivity(new Intent(this, SingleTopActivity.class));
    }

    @OnClick(R.id.launch_mode_single_task_btn)
    void launchSingleTaskMode() {
        startActivity(new Intent(this, SingleTaskActivity.class));
    }

    @OnClick(R.id.launch_mode_single_instance_btn)
    void launchSingleInstance() {
        startActivity(new Intent(this, SingleInstanceActivity.class));
    }
}
