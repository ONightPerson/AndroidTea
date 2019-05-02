package com.android.liubz.androidtea.fragmentv1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.android.liubz.androidtea.R;

public class FragmentV1Activity extends FragmentActivity implements View.OnClickListener {

    private Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentv1);

        initViews();
    }

    private void initViews() {
        mBtn = findViewById(R.id.button);
        mBtn.setOnClickListener(this);
        replaceFragment(new RightFragment());
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        if (v == mBtn) {
            replaceFragment(new AnotherRightFragment());
        }
    }
}
