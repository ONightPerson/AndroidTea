package com.liubz.androidtea.network.retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/5/12 4:58 PM
 */
public class RetrofitActivity1 extends BaseActivity {
    private static final String TAG = "RetrofitActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        request();
    }

    private void request() {
        Retrofit retrofit = new Retrofit.Builder()
          .baseUrl("http://fy.iciba.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .build();

        TranslationService service = retrofit.create(TranslationService.class);
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
