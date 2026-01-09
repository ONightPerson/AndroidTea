package com.liubz.androidtea.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.databinding.ActivityEditTextBinding;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/5/17 7:27 PM
 */
public class EditTextActivity extends BaseActivity {
    private static final String TAG = "EditTextActivity";
    private ActivityEditTextBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("EditTextActivity");

        binding.inputName.setOnClickListener(v -> inputName());
    }

    private void inputName() {
        String name = binding.inputName.toString();
        Log.i(TAG, "inputName: " + name);
    }
}
