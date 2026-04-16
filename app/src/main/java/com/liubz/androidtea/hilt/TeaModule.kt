package com.liubz.androidtea.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Desc: Hilt 依赖注入模块
 * 用于向 Hilt 提供外部库或需要特殊实例化的对象
 * @Author: liubaozhu
 */
@Module
@InstallIn(SingletonComponent::class)
object TeaModule {

    // 示例：向 Hilt 提供全局唯一的 TeaRepository 实例
    // 虽然 Repository 已经加了 @Inject，但有时我们需要通过 Module 进行更复杂的配置
    @Provides
    @Singleton
    fun provideTeaRepository(): TeaRepository {
        return TeaRepository()
    }
}
