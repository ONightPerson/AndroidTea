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

public class LoginActivity extends FragmentActivity implements View.OnClickListener {

    private Button mBtn;
    private Fragment mFirstStepFg;
    private Fragment mSecondStepFg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        mFirstStepFg = new LeftFragment();
        showFirstStep(mFirstStepFg);
    }

    private void showFirstStep(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frame_layout, fragment);
        transaction.commit();
    }

    public void goToSecondStep() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(mFirstStepFg);
        if (mSecondStepFg == null) {
            mSecondStepFg = new AnotherRightFragment();
        }
        transaction.add(R.id.frame_layout, mSecondStepFg);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onClick(View v) {

    }
}
