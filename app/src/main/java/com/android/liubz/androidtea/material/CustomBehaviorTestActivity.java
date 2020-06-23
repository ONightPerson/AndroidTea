package com.android.liubz.androidtea.material;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.liubz.androidtea.R;
import com.android.liubz.androidtea.material.recycler.DividerItemDecoration;
import com.android.liubz.androidtea.material.recycler.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomBehaviorTestActivity extends AppCompatActivity implements HomeAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
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

        initViewPager();
    }

    private void initViewPager() {
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mHomeAdapter = new HomeAdapter(this, mList);
        mHomeAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    public void checkIn(View view) {
        Snackbar.make(mCoordinatorLayout, "标题", Snackbar.LENGTH_SHORT)
                .setAction("点击事件", v -> {
                    Toast.makeText(CustomBehaviorTestActivity.this,
                            "Snackbar appear", Toast.LENGTH_SHORT).show();
                }).show();
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
