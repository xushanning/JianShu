package com.xu.module.wan.di.module

import com.xu.module.wan.api.WanService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class WanModule {
    companion object {
        //provide api
        @Provides
        @Singleton
        fun provideApi(builder: Retrofit.Builder): WanService {
            return builder
                .baseUrl("https://wanandroid.com/")
                .build()
                .create(WanService::class.java)
        }
    }
}