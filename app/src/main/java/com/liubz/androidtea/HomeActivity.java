package com.liubz.androidtea;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.HomeActivityBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "HomeActivity";

    private HomeActivityBinding mBinding;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
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
        Log.d(TAG, "onCreate");

        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    private void initViews() {
//        mBinding.clickToLaunch.setOnClickListener(this);
        String[] listOne = {"Hello", "World"};
        String[] listTwo = {"好好学习", "天天向上"};
        ArrayAdapter<String> adapterOne = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, listOne);
        ArrayAdapter<String> adapterTwo = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, listTwo);
        mBinding.listOne.setAdapter(adapterOne);
        mBinding.listTwo.setAdapter(adapterTwo);
    }

    @Override
    public void onClick(View v) {
    }
}
