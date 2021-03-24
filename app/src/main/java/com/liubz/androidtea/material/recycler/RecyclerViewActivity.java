package com.liubz.androidtea.material.recycler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liubz.androidtea.Constants;
import com.liubz.androidtea.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_recyclerview);

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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mHomeAdapter = new HomeAdapter(this, mList);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "点击第" + (position + 1) + "条", Toast.LENGTH_SHORT).show();
    }

    public void onItemLongClick(View view, int position) {
        new AlertDialog.Builder(this)
                .setTitle("确认删除吗？")
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", (dialog, which) -> {
                    mHomeAdapter.removeData(position);
                }).show();
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
        private static final String TAG = "HomeAdapter" + Constants.RECYCLER_VIEW_SUFFIX;
        private List<Integer> mRandomHeightList;

        private Context mContext;
        private List<String> mList;

        public HomeAdapter(Context context, List<String> list) {
            mContext = context;
            mList = list;
            mRandomHeightList = new ArrayList<>();
            for (int i = 0; i < mList.size(); i++) {
                mRandomHeightList.add((int) (100 + Math.random() * 300));
            }
        }

        public void removeData(int position) {
            mList.remove(position);
            notifyItemRemoved(position);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(
                    R.layout.item_recycler, parent, false));
            return holder;
        }

        @SuppressLint("LongLogTag")
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mList.get(position));
            holder.tv.setOnClickListener(v -> {
                onItemClick(holder.tv, position);
            });

            holder.tv.setOnLongClickListener(v -> {
                int pos = holder.getLayoutPosition();
                onItemLongClick(holder.tv, pos);
                return true;
            });
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tv_item);
            }
        }
    }
}
