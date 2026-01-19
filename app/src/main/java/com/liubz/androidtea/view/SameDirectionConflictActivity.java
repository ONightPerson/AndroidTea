package com.liubz.androidtea.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivitySameDirectionConflictBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 同向滑动冲突测试页面 (内部拦截法演示)
 * @Author: liubaozhu
 */
public class SameDirectionConflictActivity extends AppCompatActivity {

    private ActivitySameDirectionConflictBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySameDirectionConflictBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("同向滑动冲突解决");

        initData();
    }

    private void initData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("同向滑动 - 书籍列表项目 " + i);
        }

        binding.lvInternal.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas) {
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.BLACK);
                return view;
            }
        });
    }
}
