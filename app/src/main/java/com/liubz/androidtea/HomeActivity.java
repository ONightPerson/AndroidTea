package com.liubz.androidtea;

import com.liubz.androidtea.communicate.CommunicationActivity;
import com.liubz.androidtea.databinding.HomeActivityBinding;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";


    private HomeActivityBinding mBinding;

    private int count = 0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = HomeActivityBinding.inflate(getLayoutInflater());
        View root = mBinding.getRoot();
        setContentView(root);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        initViews();

    }

    private void initViews() {
        mBinding.clickToLaunch.setOnClickListener(this);
        mBinding.scrollView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
    }

    @Override
    public void onClick(View v) {
        if (v == mBinding.clickToLaunch) {
            startActivity(new Intent(this, CommunicationActivity.class));
        }
    }
}
