package com.liubz.androidtea.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityConflictTestBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 滑动冲突测试页面
 * @Author: liubaozhu
 */
public class ConflictTestActivity extends AppCompatActivity {

    private ActivityConflictTestBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConflictTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("滑动冲突解决方案");

        initData();
    }

    private void initData() {
        createList(binding.listView1, "页面 A", Color.parseColor("#BBDEFB"));
        createList(binding.listView2, "页面 B", Color.parseColor("#C8E6C9"));
        createList(binding.listView3, "页面 C", Color.parseColor("#FFF9C4"));
    }

    private void createList(ListView listView, String prefix, int color) {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add(prefix + " - 书籍 " + i);
        }

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas) {
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.BLACK);
                view.setBackgroundColor(color);
                return view;
            }
        });
    }
}
