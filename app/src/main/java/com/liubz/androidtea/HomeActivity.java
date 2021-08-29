package com.liubz.androidtea;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.codec.CodecUtils;

import java.io.IOException;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @OnClick(R.id.btn)
    void onClick() {
        AssetManager am = getAssets();
        AssetFileDescriptor afd = null;
        try {
            afd = am.openFd("demo.mp4");
            CodecUtils.showSupportedColorFormat(afd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
