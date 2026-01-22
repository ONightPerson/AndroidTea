package com.liubz.androidtea.hilt

import android.content.Context
import com.liubz.androidtea.contentprovider.BookDbHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Desc: 持久化（数据库）依赖注入模块
 * @Author: liubaozhu
 */
@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideBookDbHelper(@ApplicationContext context: Context): BookDbHelper {
        // 使用 Hilt 提供的 ApplicationContext 初始数据库单例
        return BookDbHelper.getInstance(context)
    }
}
