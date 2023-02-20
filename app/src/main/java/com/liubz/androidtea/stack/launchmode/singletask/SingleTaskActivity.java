package com.liubz.androidtea.stack.launchmode.singletask;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.stack.launchmode.OtherActivity;
import com.liubz.androidtea.stack.launchmode.standard.StandardActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 7:11 PM
 */
public class SingleTaskActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
        setTitle("SingleTaskActivity");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.single_task_launch_self_btn)
    void launchSingleTaskActivity() {
        startActivity(new Intent(this, SingleTaskActivity.class));
    }

    @OnClick(R.id.single_task_launch_other_btn)
    void launchOtherActivity() {
        startActivity(new Intent(this, OtherActivity.class));
    }
}
