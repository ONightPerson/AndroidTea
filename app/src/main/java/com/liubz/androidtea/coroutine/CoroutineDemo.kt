package com.liubz.androidtea.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

/**
 * Created by liubaozhu on 2026/4/2
 */
class CoroutineDemo {

    suspend fun printL() = coroutineScope {
        repeat(5000) {
            this.launch {
                println("liubaozhu")
            }
        }
    }

    fun hello() {
        repeat(5000) {
            Thread {
                println("liubaozhu")
            }.start()
        }
    }

    fun Ddd() {

    }
}