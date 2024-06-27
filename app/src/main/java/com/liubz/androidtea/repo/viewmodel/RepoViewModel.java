package com.liubz.androidtea.repo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.liubz.androidtea.network.NetWorkHelper;
import com.liubz.androidtea.network.retrofit.data.Repo;
import com.liubz.androidtea.repo.model.RepoService;
import com.liubz.androidtea.utils.LogHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/27/24 5:17 PM
 */
public class RepoViewModel extends ViewModel {
    private static final String TAG = "RepoViewModel";

    public MutableLiveData<Boolean> showLoading = new MutableLiveData<>(false);

    public MutableLiveData<List<Repo>> data = new MutableLiveData<>(new ArrayList<>());

    public void fetchData() {
        NetWorkHelper.getService(RepoService.class).listRepos("onightperson")
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Subscriber<List<Repo>>() {
              @Override
              public void onStart() {
                  super.onStart();
                  LogHelper.i(TAG, "onStart");
                  showLoading.setValue(true);
              }

              @Override
              public void onCompleted() {
                  LogHelper.i(TAG, "onCompleted");
                  showLoading.setValue(false);
              }

              @Override
              public void onError(Throwable e) {
                  LogHelper.e(TAG, e);
                  showLoading.setValue(false);
              }

              @Override
              public void onNext(List<Repo> repoList) {
                  if (repoList != null) {
                      data.setValue(repoList);
                  } else {
                      data.setValue(new ArrayList<>());
                  }
              }
          });

    }
}
