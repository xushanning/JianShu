package com.xu.module.jianshu.di.module

import com.xu.module.jianshu.api.WanService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author 言吾許
 */
@Module
class JianShuModule {
    @Module
    companion object {
        //provide api
        @JvmStatic
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