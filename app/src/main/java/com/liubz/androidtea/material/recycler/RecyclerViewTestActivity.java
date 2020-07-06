package com.liubz.androidtea.material.recycler;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.liubz.androidtea.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewTestActivity extends Activity implements HomeAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_test);

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
        mRecyclerView = findViewById(R.id.recycler_view);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mHomeAdapter = new HomeAdapter(this, mList);
        mHomeAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "点击第" + (position + 1) + "条", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        new AlertDialog.Builder(this)
                .setTitle("确认删除吗？")
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", (dialog, which) -> {
                    mHomeAdapter.removeData(position);
                }).show();
    }
}
