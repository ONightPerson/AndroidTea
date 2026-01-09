package com.liubz.androidtea.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.liubz.androidtea.databinding.ActivityViewStubBinding;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 1/15/24 9:58 AM
 */
public class ViewStubActivity extends Activity {
    private ActivityViewStubBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewStubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.inflateViewStub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflateViewStub();
            }
        });
    }

    private void inflateViewStub() {
        // 在 ViewBinding 中，ViewStub 可以通过 binding 直接访问
        binding.myViewStub.inflate();
    }
}
