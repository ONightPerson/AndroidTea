package com.liubz.androidtea;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("NonConstantResourceId")
public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    void onClick() {
        Toast.makeText(this, "点击了button", Toast.LENGTH_SHORT).show();
    }
}
