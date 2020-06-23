package com.android.liubz.androidtea.fragmentv1;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
