package com.liubz.androidtea

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.liubz.androidtea.di.koin.module.appModule
import com.liubz.androidtea.utils.ApplicationUtils
import com.liubz.androidtea.utils.CrashHandler
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * @Desc: 应用程序入口，标注 @HiltAndroidApp 触发 Hilt 的代码生成
 */
@HiltAndroidApp
class TeaApplication : Application() {

    companion object {
        private const val TAG = "TeaApplication"
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        ApplicationUtils.initApplication(this)
    }

    override fun onCreate() {
        super.onCreate()

        CrashHandler.getInstance().init(this)

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.i(TAG, "${activity.javaClass.simpleName} onCreate")
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })

        // Initialize Koin
        startKoin {
            androidLogger()
            androidContext(this@TeaApplication)
            modules(appModule)
        }
    }
}
