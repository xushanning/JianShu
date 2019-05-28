package com.xu.commonlib.di.module

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.xu.commonlib.base.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author 言吾許
 */
@Module
class AppModule(application: BaseApplication) {
    private var mApplication: BaseApplication = application


    @Provides
    fun provideApplicationContext(): BaseApplication {
        return mApplication
    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}