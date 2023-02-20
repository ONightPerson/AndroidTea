package com.liubz.androidtea.stack.launchmode.singleinstance;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.stack.launchmode.OtherActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 7:31 PM
 */
public class SingleInstanceActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
        setTitle("SingleInstanceActivity");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.single_instance_launch_other_btn)
    void launchOtherActivity() {
        startActivity(new Intent(this, OtherActivity.class));
    }
}
