package com.liubz.androidtea.material;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.liubz.androidtea.R;

import java.util.ArrayList;
import java.util.List;

public class CustomBehaviorTestActivity extends AppCompatActivity {

    private CoordinatorLayout mCoordinatorLayout;

    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behavior_test);

        initData();
        initViews();
    }

    private void initData() {
        mList.add("1");
        mList.add("2");
        mList.add("3");
        mList.add("4");
        mList.add("1");
        mList.add("2");
        mList.add("3");
        mList.add("4");
        mList.add("1");
        mList.add("2");
        mList.add("3");
        mList.add("4");
        mList.add("1");
        mList.add("2");
        mList.add("3");
        mList.add("4");
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle("黄昏");

        mCoordinatorLayout = findViewById(R.id.cl_coordinator_layout);

    }

    public void checkIn(View view) {
        Snackbar.make(mCoordinatorLayout, "标题", Snackbar.LENGTH_SHORT)
                .setAction("点击事件", v -> {
                    Toast.makeText(CustomBehaviorTestActivity.this,
                            "Snackbar appear", Toast.LENGTH_SHORT).show();
                }).show();
    }
}
