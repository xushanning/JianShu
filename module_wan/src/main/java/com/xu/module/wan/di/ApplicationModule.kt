package com.xu.module.wan.di

import com.xu.module.wan.api.WanService
import com.xu.module.wan.constant.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class ApplicationModule {

    //provide api
    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): WanService {
        return builder
            .baseUrl(AppConstant.BASE_URL)
            .build()
            .create(WanService::class.java)
    }


}