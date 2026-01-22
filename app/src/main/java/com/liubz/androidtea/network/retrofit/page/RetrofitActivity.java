package com.liubz.androidtea.network.retrofit.page;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.databinding.ActivityRetrofitBinding;
import com.liubz.androidtea.network.retrofit.data.Suggest;
import com.liubz.androidtea.network.retrofit.service.SuggestService;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AndroidEntryPoint
public class RetrofitActivity extends BaseActivity {

    @Inject
    SuggestService mSuggestService;
    private static final String TAG = "RetrofitActivity";
    private ActivityRetrofitBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetrofitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("RetrofitActivity");

        binding.dictSuggest.setOnClickListener(v -> dictSuggest());
    }

    private void dictSuggest() {
        Call<Suggest> call = mSuggestService.getCall("中国");
        call.enqueue(new Callback<Suggest>() {
            @Override
            public void onResponse(@NonNull Call<Suggest> call, @NonNull Response<Suggest> response) {
                Suggest suggest = response.body();
                Log.i(TAG, "dictSuggest --> suggest: " + suggest.toString());
            }

            @Override
            public void onFailure(@NonNull Call<Suggest> call, @NonNull Throwable t) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }
}
