package com.liubz.androidtea.hilt

import com.liubz.androidtea.network.retrofit.service.SuggestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @Desc: 网络依赖注入模块
 * @Author: liubaozhu
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            // 注意：由于 SuggestService 使用了完整的 URL，这里的 baseUrl 仅作为占位符
            .baseUrl("https://dict.youdao.com/") 
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    /**
     * 新增：提供 SuggestService 实例
     */
    @Provides
    @Singleton
    fun provideSuggestService(retrofit: Retrofit): SuggestService {
        return retrofit.create(SuggestService::class.java)
    }
}
