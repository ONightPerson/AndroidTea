package com.android.liubz.androidtea.archcomponents;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.android.liubz.androidtea.Constants;
import com.android.liubz.androidtea.R;

/**
 * Created by liubaozhu on 2020/7/2
 */
public class ShowNameActivity extends AppCompatActivity {
    private static final String TAG = "ShowNameActivity" + Constants.LIFECYCLE_SUFFIX;

    private TextView mShowName;
    private Button mUpdateBtn;
    private NameViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);

        initData();
        initViews();

    }

    @SuppressLint("LongLogTag")
    private void initData() {
        mViewModel = new ViewModelProvider(this).get(NameViewModel.class);
        mViewModel.getName().observe(this, s -> {
            mShowName.setText(s);
            Log.i(TAG, "onChanged: init name");
        });
    }

    private void initViews() {
        mShowName = findViewById(R.id.show_name);
        mUpdateBtn = findViewById(R.id.update_name);
        mUpdateBtn.setOnClickListener(this::updateView);
    }

    @SuppressLint("LongLogTag")
    private void updateView(View v) {
        String anotherName = "David";
        mViewModel.getName().setValue(anotherName);
        Log.i(TAG, "updateView: update name");
    }
}
