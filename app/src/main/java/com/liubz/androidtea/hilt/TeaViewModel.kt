package com.liubz.androidtea.hilt

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * @Desc: 使用 Hilt 注入 Repository 的 ViewModel
 * @Author: liubaozhu
 */
@HiltViewModel
class TeaViewModel @Inject constructor(
    private val repository: TeaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<TeaInfo>>(emptyList())
    val uiState: StateFlow<List<TeaInfo>> = _uiState

    init {
        // 加载数据
        _uiState.value = repository.getTeaList()
    }
}
