package com.liubz.androidtea.stack.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.stack.launchmode.singleinstance.SingleInstanceActivity;
import com.liubz.androidtea.stack.launchmode.singletask.SingleTaskActivity;
import com.liubz.androidtea.stack.launchmode.singletop.SingleTopActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 6:49 PM
 */
public class OtherActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        setTitle("OtherActivity");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.other_single_top_btn)
    void launchSingleTopActivity() {
        startActivity(new Intent(this, SingleTopActivity.class));
    }

    @OnClick(R.id.other_single_task_btn)
    void launchSingleTaskActivity() {
        startActivity(new Intent(this, SingleTaskActivity.class));
    }

    @OnClick(R.id.other_single_instance_btn)
    void launchSingleInstanceActivity() {
        startActivity(new Intent(this, SingleInstanceActivity.class));
    }
}
