package com.android.liubz.androidtea.archcomponents;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by liubaozhu on 2020/7/2
 */
public class NameViewModel extends ViewModel {

    MutableLiveData<String> mObservableName;

    public NameViewModel() {
        mObservableName = new MutableLiveData<>();
        mObservableName.setValue("Lucy");
    }

    public MutableLiveData<String> getName() {
        return mObservableName;
    }
}
