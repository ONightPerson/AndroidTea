package com.liubz.androidtea.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 1/15/24 9:58 AM
 */
public class ViewStubActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.inflate_view_stub)
    void inflateViewStub() {
        ViewStub stub = findViewById(R.id.my_view_stub);
        View inflated = stub.inflate();
    }
}
