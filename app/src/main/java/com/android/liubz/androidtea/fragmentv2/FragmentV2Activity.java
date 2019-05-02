package com.android.liubz.androidtea.fragmentv2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.android.liubz.androidtea.R;
import com.android.liubz.androidtea.fragmentv1.AnotherRightFragment;
import com.android.liubz.androidtea.fragmentv1.LeftFragment;
import com.android.liubz.androidtea.fragmentv1.RightFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentV2Activity extends FragmentActivity {

    private List<Fragment> mFragmentContainer;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentv2);

        initFragments();
    }

    private void initFragments() {
        Fragment left = new LeftFragment();
        Fragment right = new RightFragment();
        mFragmentContainer = new ArrayList<>();
        mFragmentContainer.add(left);
        mFragmentContainer.add(right);

        mViewPager = findViewById(R.id.view_pager);
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mFragmentContainer.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragmentContainer.get(position);
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }
}
