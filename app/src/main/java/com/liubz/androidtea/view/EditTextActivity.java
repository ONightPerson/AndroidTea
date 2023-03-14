package com.liubz.androidtea.view;

import android.os.Bundle;
import android.util.Log;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Desc: 输入框点击监听
 * @Author: liubaozhu
 * @Date: 2023/3/14 3:43 PM
 */
public class EditTextActivity extends BaseActivity {
    private static final String TAG = "EditTextActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("EditTextActivity");
        setContentView(R.layout.activity_edit_text);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.input_name)
    void inputName() {
        Log.i(TAG, "inputName: ");
    }
}
