package com.liubz.androidtea.switchpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liubz.androidtea.network.websocket.ConnectStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SwitchPageViewModel : ViewModel() {

    private val _infraredStatus = MutableLiveData<ConnectStatus>(ConnectStatus.Closed)
    val infraredStatus: LiveData<ConnectStatus> = _infraredStatus

    private val _deformationStatus = MutableLiveData<ConnectStatus>(ConnectStatus.Closed)
    val deformationStatus: LiveData<ConnectStatus> = _deformationStatus

    fun fetchInfraredStatus() {
        if (_infraredStatus.value == ConnectStatus.Connecting) return
        
        viewModelScope.launch {
            _infraredStatus.value = ConnectStatus.Connecting
            // 模拟获取连接状态的耗时操作
            delay(1000)
            _infraredStatus.value = ConnectStatus.Open
        }
    }

    fun fetchDeformationStatus() {
        if (_deformationStatus.value == ConnectStatus.Connecting) return

        viewModelScope.launch {
            _deformationStatus.value = ConnectStatus.Connecting
            // 模拟获取连接状态的耗时操作
            delay(1500)
            _deformationStatus.value = ConnectStatus.Open
        }
    }
}
