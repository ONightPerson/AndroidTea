package com.liubz.androidtea.repo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.network.retrofit.data.Repo;
import com.liubz.androidtea.network.retrofit.service.CustomService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    private RepoAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        initViews();

        loadData();
    }

    private void initViews() {
        RecyclerView rv = findViewById(R.id.repo_recycler_view);
        RepoAdapter adapter = new RepoAdapter(this, null);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        mAdapter = adapter;
    }

    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
          .baseUrl("https://api.github.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .build();

        CustomService service = retrofit.create(CustomService.class);
        Call<List<Repo>> call = service.listRepos("onightperson");
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Log.i(TAG, "onResponse -- call: " + response);
                List<Repo> data = response.body();
                Log.i(TAG, "onResponse -- data size: " + data.size() + ", data detail: " + data);
                mAdapter.dataChanged(data);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}
