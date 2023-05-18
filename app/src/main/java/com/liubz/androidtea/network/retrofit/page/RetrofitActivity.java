package com.liubz.androidtea.network.retrofit.page;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.network.retrofit.data.Suggest;
import com.liubz.androidtea.network.retrofit.service.CustomService;
import com.liubz.androidtea.network.retrofit.data.Repo;
import com.liubz.androidtea.network.retrofit.service.SuggestService;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends BaseActivity {
    private static final String TAG = "RetrofitActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("RetrofitActivity");
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.list_repo)
    void listRepo() {
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
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    @OnClick(R.id.dict_suggest)
    void dictSuggest() {
        Retrofit retrofit = new Retrofit.Builder()
          .baseUrl("http://fy.iciba.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .build();

        SuggestService service = retrofit.create(SuggestService.class);
        Call<Suggest> call = service.getCall("中国");
        call.enqueue(new Callback<Suggest>() {
            @Override
            public void onResponse(Call<Suggest> call, Response<Suggest> response) {
                Suggest suggest = response.body();
                Log.i(TAG, "request --> suggest: " + suggest);
            }

            @Override
            public void onFailure(Call<Suggest> call, Throwable t) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }
}
