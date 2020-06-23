package com.android.liubz.androidtea.fragmentv2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.liubz.androidtea.R;
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
