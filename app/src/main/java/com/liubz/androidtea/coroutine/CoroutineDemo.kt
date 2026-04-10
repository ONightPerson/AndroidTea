package com.liubz.androidtea.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

/**
 * Created by liubaozhu on 2026/4/2
 */
class CoroutineDemo {
    suspend fun ll() = withContext(Dispatchers.Default) {
        launch {
            delay(1000.milliseconds)
        }
    }

    suspend fun dd() = withContext(Dispatchers.IO) {
        launch {

        }
    }

    suspend fun lf() = withContext(Dispatchers.Main) {
        launch {

        }
    }
}