package com.android.liubz.androidtea;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by liubaozhu on 2019-09-12
 */
public class TVDemoActivity extends Activity implements View.OnClickListener {

    private Button mTvModelBtn;
    private TextView mTvModelShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_demo);
        assignViews();
    }

    private void assignViews() {
        mTvModelBtn = (Button) findViewById(R.id.tv_model_btn);
        mTvModelBtn.setOnClickListener(this);
        mTvModelShow = (TextView) findViewById(R.id.tv_model_show);
    }



    @Override
    public void onClick(View v) {
        if (v == mTvModelBtn) {
            mTvModelShow.setText("model: " + Build.MODEL + ", brand: " + Build.BRAND
                    + ", MANUFACTURER: " + Build.MANUFACTURER);
        }
    }
}
