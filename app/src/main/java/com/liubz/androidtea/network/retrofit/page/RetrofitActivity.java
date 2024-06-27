package com.liubz.androidtea.network.retrofit.page;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.network.retrofit.data.Suggest;
import com.liubz.androidtea.network.retrofit.service.SuggestService;

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
