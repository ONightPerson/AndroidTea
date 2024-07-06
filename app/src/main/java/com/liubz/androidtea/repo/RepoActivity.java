package com.liubz.androidtea.repo;

import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.repo.view.BezierRedPointView;
import com.liubz.androidtea.repo.view.RepoAdapter;
import com.liubz.androidtea.repo.viewmodel.RepoViewModel;
import com.liubz.androidtea.repo.viewmodel.RepoViewModelFactory;
import com.liubz.androidtea.utils.ProcessHandler;
import com.liubz.androidtea.utils.ScreenUtils;
import com.liubz.androidtea.view.widget.SwipeRefreshLayout;

/**
 * @Desc: 获取个人github仓库，使用mvvm来实现
 * 目的：用于练习mvvm框架
 * 应用框架：dagger2、fragment、databinding、livedata、ViewModel、lifecycle
 * header refresh、动效、数据库
 * @Author: liubaozhu
 * @Date: 6/26/24 11:03 AM
 */
public class RepoActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, RepoAdapter.RepoSelectListener {
    private static final String TAG = "RepoActivity";

    private RepoViewModel mViewModel;
    private ImageView mShopCartView;
    private RelativeLayout mContainer;
    private int offsetTop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        init();
    }

    private void init() {
        mContainer = findViewById(R.id.container);
        mContainer.post(new Runnable() {
            @Override
            public void run() {
                int[] loc = new int[2];
                mContainer.getLocationOnScreen(loc);
                offsetTop = loc[1];
            }
        });
        mShopCartView = findViewById(R.id.shopcart_view);
        SwipeRefreshLayout spl = findViewById(R.id.swipe_refresh_layout);
        spl.setOnRefreshListener(this);
        RepoViewModel viewModel = new ViewModelProvider(getViewModelStore(), new RepoViewModelFactory()).get(RepoViewModel.class);
        mViewModel = viewModel;
        RecyclerView rv = findViewById(R.id.repo_recycler_view);
        final RepoAdapter adapter = new RepoAdapter(this, viewModel);
        adapter.setRepoSelectListener(this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        final ProcessHandler processHandler = new ProcessHandler(this);
        viewModel.showLoading.observe(this, showLoading -> {
            if (showLoading) {
                processHandler.showProcessDialog();
            } else {
                processHandler.dismissProcessDialog();
                spl.setRefreshing(false);
            }
        });
        viewModel.data.observe(this, repoList -> adapter.notifyDataSetChanged());
        viewModel.fetchData();
    }

    @Override
    public void onRefresh() {
        mViewModel.fetchData();
    }

    @Override
    public void onSelectAnim(View startView) {
        // 获取起点和终点的中心点坐标
        PointF startPoint = ScreenUtils.getViewCenter(startView, offsetTop);
        PointF endPoint = ScreenUtils.getViewCenter(mShopCartView, offsetTop);

        // 定义控制点，控制点可以根据需求调整
        PointF controlPoint = new PointF((startPoint.x + endPoint.x) / 2, startPoint.y);

        BezierRedPointView view = new BezierRedPointView(this);
        // 启动动画
        view.startAnimation(mContainer, startPoint, endPoint, controlPoint);
    }
}
