package com.liubz.androidtea.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import java.io.Closeable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

private const val DEFAULT_TAG = "SingleThreadScope"

/**
 * A single-threaded CoroutineScope instance that can be closed. Use [createSingleThreadScope]
 * to create instances. Each instance has its own single-threaded executor and SupervisorJob.
 */
class SingleThreadScope internal constructor(
    private val name: String,
    private val exceptionHandler: CoroutineExceptionHandler,
    private val executor: ExecutorService
) : CoroutineScope, Closeable {

    private val dispatcher = executor.asCoroutineDispatcher()
    private val supervisor = SupervisorJob()

    override val coroutineContext = dispatcher + supervisor + exceptionHandler + CoroutineName(name)

    /**
     * Launch a coroutine on this single-threaded scope. Tasks execute on the single thread.
     */
    fun launchSerial(block: suspend CoroutineScope.() -> Unit): Job = launch { block() }

    /**
     * Cancel the scope and shutdown the underlying thread. Call when no longer needed to avoid leaks.
     */
    override fun close() {
        try {
            supervisor.cancel()
            executor.shutdown()
        } catch (t: Throwable) {
            Log.w(DEFAULT_TAG, "Error shutting down SingleThreadScope($name)", t)
        }
    }
}

/**
 * Create a new single-threaded scope. Caller must call [Closeable.close] when the scope is
 * no longer needed to release the underlying thread.
 *
 * @param name coroutine name for debugging
 * @param exceptionHandler optional custom coroutine exception handler; if null a default
 *        handler that logs to Log.e will be used.
 */
fun createSingleThreadScope(
    name: String = "SingleThreadCoroutineScope",
    exceptionHandler: CoroutineExceptionHandler? = null
): SingleThreadScope {
    val tag = DEFAULT_TAG
    val handler = exceptionHandler ?: CoroutineExceptionHandler { _, throwable ->
        Log.e(tag, "Uncaught coroutine exception in scope=$name", throwable)
    }

    val executor = Executors.newSingleThreadExecutor { runnable ->
        Thread(runnable, "$name-thread").apply { isDaemon = true }
    }

    return SingleThreadScope(name, handler, executor)
}

