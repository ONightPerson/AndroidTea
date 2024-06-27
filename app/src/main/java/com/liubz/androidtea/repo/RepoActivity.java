package com.liubz.androidtea.repo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.network.retrofit.data.Repo;
import com.liubz.androidtea.repo.view.RepoAdapter;
import com.liubz.androidtea.repo.viewmodel.RepoViewModel;
import com.liubz.androidtea.repo.viewmodel.RepoViewModelFactory;
import com.liubz.androidtea.utils.ProcessHandler;

import java.util.List;

/**
 * @Desc: 获取个人github仓库，使用mvvm来实现
 * 目的：用于练习mvvm框架
 * 应用框架：dagger2、fragment、databinding、livedata、ViewModel、lifecycle
 * header refresh、动效、数据库
 * @Author: liubaozhu
 * @Date: 6/26/24 11:03 AM
 */
public class RepoActivity extends BaseActivity {
    private static final String TAG = "RepoActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        init();
    }

    private void init() {
        RepoViewModel viewModel = new ViewModelProvider(getViewModelStore(), new RepoViewModelFactory()).get(RepoViewModel.class);
        RecyclerView rv = findViewById(R.id.repo_recycler_view);
        final RepoAdapter adapter = new RepoAdapter(this, viewModel);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        final ProcessHandler processHandler = new ProcessHandler(this);
        viewModel.showLoading.observe(this, showLoading -> {
            if (showLoading) {
                processHandler.showProcessDialog();
            } else {
                processHandler.dismissProcessDialog();
            }
        });
        viewModel.data.observe(this, repoList -> adapter.notifyDataSetChanged());
        viewModel.fetchData();
    }
}
