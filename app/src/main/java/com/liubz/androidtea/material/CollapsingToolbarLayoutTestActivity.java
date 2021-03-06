package com.liubz.androidtea.material;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.liubz.androidtea.R;
import com.liubz.androidtea.material.tablayout.FragmentAdapter;
import com.liubz.androidtea.material.tablayout.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class CollapsingToolbarLayoutTestActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsingtoolbar_test);

        initViews();
    }

    private void initViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle("黄昏");

        mCoordinatorLayout = findViewById(R.id.cl_coordinator_layout);

        initViewPager();
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tab_layout);
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("体育");
        titles.add("巴萨");
        titles.add("购物");
        titles.add("明星");
        titles.add("视频");
        titles.add("健康");
        titles.add("励志");
        titles.add("图文");
        titles.add("本地");
        titles.add("动漫");
        titles.add("搞笑");

        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new ListFragment());
        }

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),
                fragments, titles);
        // 给ViewPager设置适配器
        mViewPager.setAdapter(fragmentAdapter);
        // 将TabLayout和ViewPager关联起来
        mTabLayout.setupWithViewPager(mViewPager);
//        // 给TabLayout设置适配器
//        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);
    }

    public void checkIn(View view) {
        Snackbar.make(mCoordinatorLayout, "标题", Snackbar.LENGTH_SHORT)
                .setAction("点击事件", v -> {
                    Toast.makeText(CollapsingToolbarLayoutTestActivity.this,
                            "Snackbar appear", Toast.LENGTH_SHORT).show();
                }).show();
    }
}
