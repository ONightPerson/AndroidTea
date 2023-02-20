package com.liubz.androidtea.stack.launchmode.standard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 5:25 PM
 */
@SuppressLint("LongLogTag")
public class StandardActivity extends BaseActivity {
    private static final String TAG = "StandardActivity" + LAUNCH_MODE_TAG_SUFFIX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        setTitle("StandardActivity");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.launch_mode_standard_btn)
    void launchStandardActivity() {
        startActivity(new Intent(this, StandardActivity.class));
    }
}
