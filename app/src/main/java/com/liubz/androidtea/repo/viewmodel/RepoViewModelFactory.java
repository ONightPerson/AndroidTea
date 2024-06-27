package com.liubz.androidtea.repo.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/27/24 5:12 PM
 */
public class RepoViewModelFactory extends NewInstanceFactory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return super.create(modelClass);
    }
}
