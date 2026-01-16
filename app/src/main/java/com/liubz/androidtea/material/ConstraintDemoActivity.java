package com.liubz.androidtea.material;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityConstraintDemoBinding;

/**
 * @Desc: ConstraintLayout 示例页面
 * @Author: liubaozhu
 */
public class ConstraintDemoActivity extends AppCompatActivity {

    private ActivityConstraintDemoBinding binding;
    private static Context sContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConstraintDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sContext = this;

        setTitle("ConstraintLayout 示例");

        initListeners();
    }

    private void initListeners() {
        binding.btnFollow.setOnClickListener(v -> 
            Toast.makeText(this, "已关注 " + binding.tvUsername.getText(), Toast.LENGTH_SHORT).show()
        );

        binding.btnMessage.setOnClickListener(v -> 
            Toast.makeText(this, "正在打开与该开发者的对话框...", Toast.LENGTH_SHORT).show()
        );
    }
}
