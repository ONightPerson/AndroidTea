package com.liubz.androidtea.viewpager

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liubz.androidtea.network.websocket.ConnectStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * ViewModel scoped to the ViewPager activity. Keeps statuses for both pages and
 * provides simulated fetch methods.
 */
class ViewPagerViewModel : ViewModel() {
    
    companion object {
        private const val TAG = "ViewPagerViewModel"
    }

    private val _infraredStatus = MutableLiveData<ConnectStatus>(ConnectStatus.Closed)
    val infraredStatus: LiveData<ConnectStatus> = _infraredStatus

    private val _deformationStatus = MutableLiveData<ConnectStatus>(ConnectStatus.Closed)
    val deformationStatus: LiveData<ConnectStatus> = _deformationStatus

    fun fetchInfraredStatus() {
        Log.i(TAG, "fetchInfraredStatus: start fetching infrared status _infraredStatus=${_infraredStatus.value}")
        if (_infraredStatus.value == ConnectStatus.Connecting) return

        viewModelScope.launch {
            _infraredStatus.value = ConnectStatus.Connecting
            delay(1000)
            _infraredStatus.value = ConnectStatus.Open
        }
    }

    fun fetchDeformationStatus() {
        Log.i(TAG, "fetchDeformationStatus: start fetching deformation status _deformationStatus=${_deformationStatus.value}")
        if (_deformationStatus.value == ConnectStatus.Connecting) return

        viewModelScope.launch {
            _deformationStatus.value = ConnectStatus.Connecting
            delay(1500)
            _deformationStatus.value = ConnectStatus.Open
        }
    }
}

